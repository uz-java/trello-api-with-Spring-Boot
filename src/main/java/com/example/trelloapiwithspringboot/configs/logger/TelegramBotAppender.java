package com.example.trelloapiwithspringboot.configs.logger;

import com.example.trelloapiwithspringboot.configs.logger.sender.MyBot;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:38 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Plugin(name = "TelegramBotAppender",category = Core.CATEGORY_NAME,elementType = Appender.ELEMENT_TYPE)
public class TelegramBotAppender extends AbstractAppender {

    private final MyBot myBot=new MyBot();

    protected TelegramBotAppender(String name, Filter filter) {
        super(name, filter, PatternLayout.newBuilder().build(), true, null);
    }
    @Override
    public void append(LogEvent event) {
        if (event.getLevel().isMoreSpecificThan(Level.ERROR))
            myBot.SendMessage(
                    event.getSource().getMethodName() + "\n"
                            + event.getSource().getClassName() + "\n"
                            + event.getMessage().getFormattedMessage());
    }

    @PluginFactory
    public static TelegramBotAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") Filter filter
    )

    {
        return new TelegramBotAppender(name, filter);
    }

}
