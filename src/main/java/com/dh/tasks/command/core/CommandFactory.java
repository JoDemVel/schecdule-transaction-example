package com.dh.tasks.command.core;

import org.springframework.context.ApplicationContext;

public abstract class CommandFactory {
    public<CMD extends Command> CMD createInstance(Class<CMD> commandClass) {
        return getApplicationContext().getBean(commandClass);
    }

    protected abstract ApplicationContext getApplicationContext();
}
