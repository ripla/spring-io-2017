package com.vaadin.example.ui.reactive;

import java.util.List;

import com.vaadin.ui.ComboBox;

public class ReactiveComboBox<T> extends ComboBox<T> implements
        ReactiveHasValue<T>{
    public ReactiveComboBox(String caption, List<T> values) {
        super(caption,values);
    }
}
