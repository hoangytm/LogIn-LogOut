package com.programming.hoangpn.Login_LogOut;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching
public class LogIn_LogOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogIn_LogOutApplication.class, args);
    }
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("login"); // Cache Vendor
    }
}
