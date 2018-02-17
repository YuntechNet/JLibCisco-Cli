package tw.edu.yuntech.yunnet.gui.component;

import javax.swing.*;
import java.awt.*;

public class CRouter extends JComponent {

    public CRouter() {}

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillOval(0, 10, 76, 30);

        g2d.setColor(Color.decode("0xd0d0d0"));
        for(int i = 1; i < 9; ++i)
            g2d.fillOval(0, 10 - i, 76, 30);

        g2d.setColor(Color.decode("0x2894ff"));
        g2d.fillOval(0, 0, 75, 30);

        g2d.setColor(Color.BLACK);
        g2d.drawOval(0, 0, 75, 30);
        g2d.drawLine(0, 15, 0, 27);
        g2d.drawLine(75, 15, 75, 27);
        //g2d.drawLine(137, 115, 137, 115); // Center anchor point

        Arrow.paintk(g2d, 57, 24, 42, 18);
        Arrow.paintk(g2d, 18, 6, 33, 12);
        Arrow.paintk(g2d, 42, 12, 57, 6);
        Arrow.paintk(g2d, 33, 18, 18, 24);

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
