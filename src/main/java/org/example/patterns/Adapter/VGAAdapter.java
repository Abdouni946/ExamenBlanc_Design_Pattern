package org.example.patterns.Adapter;

public class VGAAdapter implements HDMI {
    private VGADisplay vgaDisplay;

    public VGAAdapter(VGADisplay vgaDisplay) {
        this.vgaDisplay = vgaDisplay;
    }

    @Override
    public void display(String content) {
        vgaDisplay.show(content); // Adaptation
    }
}