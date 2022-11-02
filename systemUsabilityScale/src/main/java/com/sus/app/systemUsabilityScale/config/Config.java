package com.sus.app.systemUsabilityScale.config;

import com.sus.app.systemUsabilityScale.services.ScaleService;
import com.sus.app.systemUsabilityScale.services.ScaleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
public class Config {

    @Bean
    public ScaleService scaleService() {
        return new ScaleServiceImpl();
    }

}
