package com.github.notyy.principle.lsp;

public class Rectangle {
    private int width;
    private int height;

    public int area() {
        return width*height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
