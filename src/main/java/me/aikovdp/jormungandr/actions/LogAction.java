package me.aikovdp.jormungandr.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class LogAction implements Action<LogAction.Input, Void> {
    private final Logger logger;

    public LogAction() {
        logger = LoggerFactory.getLogger(LogAction.class);
    }

    public LogAction(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Void execute(Input input) {
        logger.makeLoggingEventBuilder(input.level).log(input.message, input.params);
        return null;
    }

    public record Input(
            Level level,
            String message,
            Object... params
    ) {
    }
}
