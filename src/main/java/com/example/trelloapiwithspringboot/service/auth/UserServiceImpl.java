package com.example.trelloapiwithspringboot.service.auth;

import com.example.trelloapiwithspringboot.configs.security.UserDetails;
import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import com.example.trelloapiwithspringboot.dtos.auth.LoginRequestDTO;
import com.example.trelloapiwithspringboot.dtos.auth.UserCreateDTO;
import com.example.trelloapiwithspringboot.dtos.auth.UserDTO;
import com.example.trelloapiwithspringboot.dtos.jwt.JwtResponseDTO;
import com.example.trelloapiwithspringboot.dtos.jwt.RefreshTokenRequest;
import com.example.trelloapiwithspringboot.exceptions.UserNotFoundException;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.mappers.auth.UserMapper;
import com.example.trelloapiwithspringboot.repository.auth.UserRepository;
import com.example.trelloapiwithspringboot.service.token.RefreshTokenService;
import com.example.trelloapiwithspringboot.utils.jwt.JwtUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:13 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Lazy AuthenticationManager authenticationManager, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JwtResponseDTO login(LoginRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String accessToken = JwtUtils.accessTokenService.generateToken(userDetails);
        String refreshToken = JwtUtils.refreshTokenService.generateToken(userDetails);
        return new JwtResponseDTO(accessToken, refreshToken, "Bearer");
    }

    @Override
    public UserDTO register(UserCreateDTO dto) {
        AuthUser authUser = userRepository.save(AuthUser.builder()
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .build());
        return userMapper.fromUser(authUser);
    }

    @Override
    public JwtResponseDTO refreshToken(RefreshTokenRequest request) {
        String token = request.token();
        RefreshTokenService refreshTokenService = JwtUtils.refreshTokenService;
        if (!refreshTokenService.isValid(token))
            throw new ValidationException("Refresh token is invalid");
        String username = refreshTokenService.getSubject(token);
        UserDetails userDetails = loadUserByUsername(username);
        String accessToken = JwtUtils.accessTokenService.generateToken(userDetails);
        return new JwtResponseDTO(accessToken, request.token(), "Bearer");
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AuthUser authUser=userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found by email %s".formatted(email)));
        return new UserDetails(authUser);
    }
}
