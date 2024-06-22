package me.aikovdp.jormungandr.workflows;

public record OutputKey<T>(String path) {
    public static final OutputKey<Attributes> ATTRIBUTES = new OutputKey<>("attributes");
}
