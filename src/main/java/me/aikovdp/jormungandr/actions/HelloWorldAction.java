package me.aikovdp.jormungandr.actions;

public class HelloWorldAction implements Action<Void, Void> {

    @Override
    public Void execute(Void input) {
        System.out.println("Hello World!");
        return null;
    }
}
