package com.example.trelloapiwithspringboot.service.boardColumn;

import com.example.trelloapiwithspringboot.domains.board.Board;
import com.example.trelloapiwithspringboot.domains.board.BoardColumn;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnCreateDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnOrderChangeDTO;
import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.mappers.board.BoardColumnMapper;
import com.example.trelloapiwithspringboot.repository.board.BoardRepository;
import com.example.trelloapiwithspringboot.repository.boardColumn.BoardColumnRepository;
import com.example.trelloapiwithspringboot.validators.board.BoardColumnValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:16 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BoardColumnServiceImpl implements BoardColumnService {
    private final BoardColumnRepository boardColumnRepository;
    private final BoardColumnValidator boardColumnValidator;
    private final BoardRepository boardRepository;
    private final BoardColumnMapper boardColumnMapper;

    @Override
    public BoardColumnDTO save(BoardColumnCreateDTO dto) {
        boardColumnValidator.validOnCreate(dto);
        BoardColumn boardColumn = boardColumnMapper.fromCreateDTO(dto);
        Board board = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new GenericNotFoundException("board not found by id: %s".formatted(dto.getBoardId())));
        boardColumn.setBoard(board);
        return boardColumnMapper.fromBoardColumn(boardColumnRepository.save(boardColumn));
    }

    @Override
    public BoardColumnDTO changeOrder(BoardColumnOrderChangeDTO dto) {
        boardColumnValidator.validateOnChangeOrder(dto);
        BoardColumn boardColumn = boardColumnRepository.findById(dto.getId())
                .orElseThrow(() -> new GenericNotFoundException(
                        "Board column not found by id: " + dto.getId()
                ));
        boardColumn.getBoard().getBoardColumns().stream()
                .filter(bc -> bc.getOrder() >= dto.getOrder())
                .forEach(nbc -> nbc.setOrder(nbc.getOrder() + 1));
        boardColumn.setOrder(dto.getOrder());
        return boardColumnMapper.fromBoardColumn(boardColumnRepository.save(boardColumn));
    }

    @Override
    public void deleteColumn(Long id) {
        boardColumnValidator.validateOnDelete(id);
        BoardColumn boardColumn = boardColumnRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(
                        "Board column not found by id: " + id
                ));
        Set<BoardColumn> boardColumns = boardColumn.getBoard()
                .getBoardColumns();
        boardColumns.stream()
                .filter(bc -> bc.getOrder() > boardColumn.getOrder())
                .forEach(nbc -> nbc.setOrder(nbc.getOrder() - 1));
        boardColumns.remove(boardColumn);
        boardColumn.setIsDeleted(true);
        boardColumnRepository.save(boardColumn);
    }
}
