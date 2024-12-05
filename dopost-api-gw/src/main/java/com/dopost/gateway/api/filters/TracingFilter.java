package com.dopost.gateway.api.filters;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class TracingFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(TracingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestId = exchange.getRequest().getId();
        String requestPath = exchange.getRequest().getURI().getPath();
        Instant startTime = Instant.now();

        logger.info("Request ID: {} - Incoming request to {} at {}", requestId, requestPath, startTime);

        exchange.getRequest().mutate()
            .header("X-Request-Id", requestId)
            .build();

        return chain.filter(exchange)
            .doOnTerminate(() -> {
                Instant endTime = Instant.now();
                logger.info("Request ID: {} - Completed request to {} in {} ms", 
                            requestId, requestPath, Duration.between(startTime, endTime).toMillis());
            });
    }

    @Override
    public int getOrder() {
        return -1;
    }
}