package tw.edu.yuntech.yunnet.gui.component;

import javax.swing.*;
import java.awt.*;

public class CSwitch extends JComponent {

    public CSwitch() {}

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode("0x2894ff"));
        for (int i = 0; i < 35; ++i)
            g2d.drawLine(35 - i, i, 35 - i + 100, i);

        g2d.setColor(Color.decode("0xd0d0d0"));
        for(int i = 0; i < 20; ++i) {
            g2d.drawLine(0, 35 + i, 100, 35 + i);
            g2d.drawLine(135, 0 + i, 100, 35 + i);
        }
        g2d.setColor(Color.BLACK);

        g2d.drawLine(35, 0, 135, 0);

        g2d.drawLine(135, 0, 100, 35);
        g2d.drawLine(0, 35, 35, 0);
        g2d.drawLine(135, 0, 135, 20);
        g2d.drawRect(0, 35, 100, 20);
        g2d.drawLine(100, 55, 135, 20);

        //g2d.drawLine(85, 0, 50, 35); // center anchor line

        Arrow.paintk(g2d,95, 8, 115, 8);
        Arrow.paintk(g2d,65, 13, 45, 13);
        Arrow.paintk(g2d,75, 18, 95, 18);
        Arrow.paintk(g2d,45, 23, 25, 23);
        //Arrow.paintk();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }


}
