package com.tujuhsembilan.maincore.configuration;

import io.github.bucket4j.Bucket;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimitConfig {

    @Bean
    public Bucket bucket() {
        return Bucket.builder()
            .addLimit(limit -> limit.capacity(2).refillGreedy(2, Duration.ofMinutes(1)))
            .build();
    }
}
