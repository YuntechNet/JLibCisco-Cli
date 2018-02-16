package tw.edu.yuntech.yunnet.gui;

import javax.swing.*;
import java.awt.*;

public class GStatus {

    private JFrame frame;

    public GStatus(boolean border) {
        frame = new JFrame("JLibCisco-Cli - Status");
        frame.setSize(new Dimension(400, 300));
        frame.setResizable(false);

        frame.setVisible(true);
    }

}
