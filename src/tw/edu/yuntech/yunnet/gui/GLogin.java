package tw.edu.yuntech.yunnet.gui;

import javax.swing.*;
import java.awt.*;

public class GLogin {

    private JFrame frame;
    private JLabel[] labels = {
            new JLabel("Login"), new JLabel("Account : "), new JLabel("Password : "), new JLabel("Identify : ")
    };
    private JTextField[] fields = {
            new JTextField(20), new JTextField(20)
    };
    private JRadioButton[] radios = {
            new JRadioButton("LibServer"), new JRadioButton("AD / LDAP")
    };
    private JButton[] buttons = {
            new JButton("Login"), new JButton("Cancel")
    };

    public GLogin(boolean border) {
        frame = new JFrame("JLibCisco-Cli - Login");
        frame.setSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());

        lblGenerate(border);
        fieldGenerate(border);
        radioGenerate(border);
        btnGenerate(border);

        frame.setVisible(true);
    }

    private void lblGenerate(boolean border) {
        if(border)
            for(JLabel lbl : labels)
                lbl.setBorder(BorderFactory.createLineBorder(Color.RED));

        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 3;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.WEST;
        frame.add(labels[0], g);
        for(int i = 1; i < 3; ++i) {
            GridBagConstraints g2 = new GridBagConstraints();
            g2.gridx = 0;
            g2.gridy = i;
            g2.fill = GridBagConstraints.HORIZONTAL;
            g2.anchor = GridBagConstraints.WEST;
            frame.add(labels[i], g2);
        }
        GridBagConstraints g3 = new GridBagConstraints();
        g3.gridx = 0;
        g3.gridy = 3;
        g3.fill = GridBagConstraints.HORIZONTAL;
        g3.anchor = GridBagConstraints.WEST;
        frame.add(labels[3], g3);
    }

    private void fieldGenerate(boolean border) {
        if(border)
            for(JTextField filed : fields)
                filed.setBorder(BorderFactory.createLineBorder(Color.RED));

        for(int i = 0; i < fields.length; ++i) {
            GridBagConstraints g = new GridBagConstraints();
            g.gridx = 1;
            g.gridy = i + 1;
            g.gridwidth = 2;
            g.anchor = GridBagConstraints.CENTER;
            frame.add(fields[i], g);
        }
    }

    private void radioGenerate(boolean border) {
        if(border)
            for(JRadioButton radio : radios)
                radio.setBorder(BorderFactory.createLineBorder(Color.RED));

        ButtonGroup bg = new ButtonGroup();
        for(int i = 0; i < radios.length; ++i) {
            GridBagConstraints g = new GridBagConstraints();
            g.gridx = i + 1;
            g.gridy = 3;
            frame.add(radios[i], g);
            bg.add(radios[i]);
        }
    }

    private void btnGenerate(boolean border) {
        if(border)
            for(JButton btn : buttons)
                btn.setBorder(BorderFactory.createLineBorder(Color.RED));

        for(int i = 0; i < buttons.length; ++i) {
            GridBagConstraints g = new GridBagConstraints();
            g.gridx = i;
            g.gridy = 4;
            frame.add(buttons[i], g);
        }
    }

}
