package com.pch.homework.config;

import org.springframework.context.annotation.Bean;

public class StringTrimmingConfiguration {

    @Bean
    public TrimmedAnnotationBeanPostProcessor trimmedAnnotationBeanPostProcessor() {
        return new TrimmedAnnotationBeanPostProcessor();
    }
}
