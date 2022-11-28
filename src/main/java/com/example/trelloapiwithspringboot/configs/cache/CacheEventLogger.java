package com.example.trelloapiwithspringboot.configs.cache;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:37 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Slf4j
public class CacheEventLogger implements CacheEventListener<Object,Object> {
    @Override
    public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        System.out.println("Cache event listener => " + cacheEvent.getKey() + cacheEvent.getOldValue() + cacheEvent.getNewValue());
    }
}
