package me.aikovdp.jormungandr;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import me.aikovdp.jormungandr.actions.LogAction;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import static org.junit.jupiter.api.Assertions.*;

public class LogActionTest {
    @Test
    public void testLogAction() {
        Logger logger = (Logger) LoggerFactory.getLogger(LogActionTest.class);
        ListAppender<ILoggingEvent> appender = new ListAppender<>();
        appender.setContext(logger.getLoggerContext());
        appender.start();
        logger.addAppender(appender);
        LogAction action = new LogAction(logger);

        action.execute(
                new LogAction.Input(
                        Level.INFO,
                        "This is a test with {} and {} as parameters",
                        "APPLE", "PEAR"
                )
        );

        assertEquals(
                appender.list.getFirst().getFormattedMessage(),
                "This is a test with APPLE and PEAR as parameters"
        );
    }
}
