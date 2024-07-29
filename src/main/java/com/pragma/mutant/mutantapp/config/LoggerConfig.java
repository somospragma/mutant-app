package com.pragma.mutant.mutantapp.config;

import com.pragma.mutant.mutantapp.logger.ILoggerStrategy;
import com.pragma.mutant.mutantapp.logger.Log4jImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {

    @Bean
    @ConditionalOnProperty(name = "logger.impl",havingValue = "log4j")
    public ILoggerStrategy LogStrategy (){
        return new Log4jImpl();
    }
}
