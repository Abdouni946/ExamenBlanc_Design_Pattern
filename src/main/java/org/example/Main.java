package org.example;

import org.example.agentManager.Agent;
import org.example.agentManager.Container;
import org.example.patterns.Adapter.HDMI;
import org.example.patterns.Adapter.HDMIdisplay;
import org.example.patterns.Adapter.VGAAdapter;
import org.example.patterns.Adapter.VGADisplay;

public class Main {
    public static void main(String[] args) {
        HDMI hdmiDisplay = new HDMIdisplay();
        hdmiDisplay.display("Conteneur d'agents en HDMI");

        VGADisplay vgaDisplay = new VGADisplay();
        HDMI adapter = new VGAAdapter(vgaDisplay);
        adapter.display("Conteneur d'agents en VGA via adaptateur");

    }
}
