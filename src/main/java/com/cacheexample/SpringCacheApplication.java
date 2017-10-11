package com.cacheexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * Created by Simeon_Markov on 7/12/2017.
 */

@SpringBootApplication
@EnableCaching
@Slf4j
public class SpringCacheApplication {

    /**
     * some comment
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCacheApplication.class, args);
        log.debug("Application is up...");
        System.exit(0);
    }
}
