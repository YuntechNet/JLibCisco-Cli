package tw.edu.yuntech.yunnet.gui;

import tw.edu.yuntech.yunnet.server.RemoteServer;
import tw.edu.yuntech.yunnet.utils.EnumLoginMode;
import tw.edu.yuntech.yunnet.utils.LimitDocByRegex;
import tw.edu.yuntech.yunnet.utils.NetUtils;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GLogin implements ActionListener {

    private JFrame frame;
    private JLabel[] labels = {
            new JLabel("Login"),
            new JLabel("Server : "),
            new JLabel("Account : "),
            new JLabel("Password : "),
            new JLabel("Identify : ")
    };
    private JTextField[] fields = { new JTextField(20), new JTextField(20), new JPasswordField(20) };
    private PlainDocument[] docs = {
            new LimitDocByRegex(39, "[0-9A-Fa-f:.]{1}"),
            new LimitDocByRegex(10, "[0-9A-Za-z~!@#$%^&*()_+]{1}"),
            new LimitDocByRegex(10, "[0-9A-Za-z~!@#$%^&*()_+]{1}")
    };
    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton[] radios = { new JRadioButton("LibServer", true), new JRadioButton("ActiveDirectory") };
    private JButton[] buttons = { new JButton("Login"), new JButton("Cancel") };

    public GLogin(boolean border) {
        frame = new JFrame("JLibCisco-Cli - Login");
        frame.setSize(new Dimension(550, 300));
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
        for(int i = 3; i < labels.length; ++i) {
            GridBagConstraints g3 = new GridBagConstraints();
            g3.gridx = 0;
            g3.gridy = i;
            g3.fill = GridBagConstraints.HORIZONTAL;
            g3.anchor = GridBagConstraints.WEST;
            frame.add(labels[i], g3);
        }
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
            if(docs[i] != null)
                fields[i].setDocument(docs[i]);
            frame.add(fields[i], g);
        }
    }

    private void radioGenerate(boolean border) {
        if(border)
            for(JRadioButton radio : radios)
                radio.setBorder(BorderFactory.createLineBorder(Color.RED));

        for(int i = 0; i < radios.length; ++i) {
            GridBagConstraints g = new GridBagConstraints();
            g.gridx = i + 1;
            g.gridy = 4;
            radios[i].setActionCommand(radios[i].getText());
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
            g.gridy = 5;
            buttons[i].addActionListener(this);
            frame.add(buttons[i], g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals(buttons[0].getText())) { // Login
            if (fields[0].getText().equals("") || fields[1].getText().equals("")) { // Account or Password filed empty error.
                JOptionPane.showMessageDialog(new JFrame(), "Account or Password is empty.", "Error", JOptionPane.WARNING_MESSAGE);
            } else if (!NetUtils.isInetAddress(fields[0].getText().split(":")[0])) { // Host is invalid.
                JOptionPane.showMessageDialog(new JFrame(), "Server Address is not valid.", "Errpr", JOptionPane.WARNING_MESSAGE);
            } else {
                EnumLoginMode loginMode = EnumLoginMode.valueOf(bg.getSelection().getActionCommand());
                System.out.println(loginMode.getValue());
                RemoteServer rs = new RemoteServer(fields[0].getText().split(":")[0], Integer.valueOf(fields[0].getText().split(":")[1]));
                rs.send("Init");
                rs.close();
            }
        } else if(cmd.equals(buttons[1].getText())) { // Cancel
            System.exit(0);
        } else { // Unexpected action command received.
            System.out.println(cmd);
        }
    }

}

