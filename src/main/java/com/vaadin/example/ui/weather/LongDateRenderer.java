package com.vaadin.example.ui.weather;

import java.util.Date;

import com.vaadin.ui.renderers.AbstractRenderer;
import com.vaadin.ui.renderers.DateRenderer;

import elemental.json.JsonValue;

public class LongDateRenderer extends AbstractRenderer<Object, Long> {

    private final DateRenderer internalRenderer;

    public LongDateRenderer() {
        super(Long.class);
        this.internalRenderer = new DateRenderer();
    }

    @Override
    public JsonValue encode(Long value) {
        return internalRenderer.encode(new Date(value));
    }
}
