package tw.edu.yuntech.yunnet.gui.component;

import java.awt.*;

public class Arrow {

    public static  void paintk(Graphics2D g, int  x1, int  y1, int  x2, int  y2)  {

        double H = 3;
        double L = 3;
        int x3 = 0 ;
        int y3 = 0 ;
        int x4 = 0 ;
        int y4 = 0 ;
        double awrad = Math.atan(L / H);
        double arraow_len = Math.sqrt(L * L + H * H);
        double[] arrXY_1 = rotateVec(x2 - x1, y2 - y1, awrad,  true , arraow_len);
        double[] arrXY_2 = rotateVec(x2 - x1, y2 - y1, - awrad,  true , arraow_len);
        double x_3 = x2 - arrXY_1[0];
        double y_3 = y2 - arrXY_1[1];
        double x_4 = x2 - arrXY_2[0];
        double y_4 = y2 - arrXY_2[1];

        Double X3 = new Double(x_3);
        x3 =  X3.intValue();
        Double Y3 = new Double(y_3);
        y3 = Y3.intValue();
        Double X4 = new Double(x_4);
        x4 = X4.intValue();
        Double Y4 = new Double(y_4);
        y4 = Y4.intValue();
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(3.0f));
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x2, y2, x4, y4);

    }

    public static double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen) {
        double mathstr[] = new double[2];
        double vx = px * Math.cos(ang) - py * Math.sin(ang);
        double vy = px * Math.sin(ang) + py * Math.cos(ang);
        if(isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathstr[0] = vx;
            mathstr[1] = vy;
        }
        return mathstr;
    }

}
