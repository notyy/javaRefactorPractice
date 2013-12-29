package com.github.notyy.principle.lsp;

public class Apple extends Fruit {
    @Override
    public void split() {
        throw new IllegalStateException("no! you can't eat me!");
    }
}
