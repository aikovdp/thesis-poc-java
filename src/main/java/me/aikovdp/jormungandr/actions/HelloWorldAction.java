package me.aikovdp.jormungandr.actions;

import me.aikovdp.jormungandr.workflows.WorkflowContext;

public class HelloWorldAction implements Action<Void, Void> {

    @Override
    public Void execute(Void input, WorkflowContext context) {
        System.out.println("Hello World!");
        return null;
    }
}
