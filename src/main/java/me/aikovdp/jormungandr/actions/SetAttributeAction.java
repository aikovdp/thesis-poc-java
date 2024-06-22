package me.aikovdp.jormungandr.actions;

import me.aikovdp.jormungandr.workflows.Attributes;
import me.aikovdp.jormungandr.workflows.OutputKey;
import me.aikovdp.jormungandr.workflows.WorkflowContext;

import java.util.List;

public class SetAttributeAction implements Action<SetAttributeAction.Input, Void> {
    @Override
    public Void execute(Input input, WorkflowContext context) {
        Attributes attributes = context.getOutput().computeIfAbsent(OutputKey.ATTRIBUTES, (k) -> new Attributes());
        attributes.setAttribute(input.category(), input.name(), input.values());

        return null;
    }

    public record Input(
            String category,
            String name,
            List<String> values
    ) {
        public Input(String category, String name, String value) {
            this(category, name, List.of(value));
        }
    }
}
