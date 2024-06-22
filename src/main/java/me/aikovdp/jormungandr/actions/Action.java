package me.aikovdp.jormungandr.actions;

import me.aikovdp.jormungandr.workflows.WorkflowContext;

public interface Action<I, O> {
    O execute(I input, WorkflowContext context);
}
