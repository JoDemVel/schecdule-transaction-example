package com.dh.tasks.command.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CommandFactoryProducer implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CommandFactory commandFactory() {
        return new CommandFactory() {
            @Override
            protected ApplicationContext getApplicationContext() {
                return CommandFactoryProducer.this.applicationContext;
            }
        };
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}