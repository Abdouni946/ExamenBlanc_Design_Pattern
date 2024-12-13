package org.example.patterns.Adapter;

public class HDMIdisplay implements HDMI {
    @Override
    public void display(String content) {
        System.out.println("HDMI Display: " + content);
    }
}

