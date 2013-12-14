package com.github.notyy.principle.lsp;

public class Drawer {
    public void area(Rectangle rectangle){
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        assert(rectangle.area() == 20);
    }
}
