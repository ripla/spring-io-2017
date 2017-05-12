package com.vaadin.example.ui.reactive;

import java.util.List;

import com.vaadin.ui.RadioButtonGroup;

public class ReactiveRadioButtonGroup<T> extends RadioButtonGroup<T> implements
        ReactiveHasValue<T>{
    public ReactiveRadioButtonGroup(String caption, List<T> values) {
        super(caption, values);
    }
}
