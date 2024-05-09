package me.aikovdp.jormungandr.actions;

public interface Action<I, O> {
    O execute(I input);
}
