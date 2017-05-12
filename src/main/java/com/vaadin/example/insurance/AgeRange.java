package com.vaadin.example.insurance;

public enum AgeRange {
    LOW("15-21"), MEDIUM("22-40"), HIGH("40+");

    private final String caption;

    AgeRange(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
