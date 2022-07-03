package com.wgx.waterboss.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author:wgx
 * version:1.0
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public IKeyGenerator oracleGenerator() {
        return new OracleKeyGenerator();
    }
}
