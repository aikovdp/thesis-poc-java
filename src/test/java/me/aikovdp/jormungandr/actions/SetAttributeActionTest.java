package me.aikovdp.jormungandr.actions;

import me.aikovdp.jormungandr.workflows.OutputKey;
import me.aikovdp.jormungandr.workflows.WorkflowContext;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetAttributeActionTest {
    @Test
    void testSetAttributeAction() {
        var action = new SetAttributeAction();
        var context = new WorkflowContext();

        action.execute(new SetAttributeAction.Input("testCategory", "testName", "testValue"), context);

        assertEquals(
                context.getOutput().get(OutputKey.ATTRIBUTES).getAttribute("testCategory", "testName"),
                List.of("testValue")
        );
    }
}
