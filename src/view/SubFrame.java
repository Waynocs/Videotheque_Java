package view;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class SubFrame extends JFrame {
	private static final long serialVersionUID = 37336346948113039L;
	private Window parent;
    public SubFrame(Window p) {
        parent = p;
	    setLocationRelativeTo(p);
        addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(final WindowEvent e) {
            }
            @Override
            public void windowClosing(final WindowEvent e) {
                parent.setVisible(true);
            }
            @Override
            public void windowClosed(final WindowEvent e) {
            }
            @Override
            public void windowIconified(final WindowEvent e) {
            }
            @Override
            public void windowDeiconified(final WindowEvent e) {
            }
            @Override
            public void windowActivated(final WindowEvent e) {
            }
            @Override
            public void windowDeactivated(final WindowEvent e) {
            }
        });
    }
    @Override
    public void setVisible(boolean b) {
        if (b)
            parent.setVisible(false);
        super.setVisible(b);
    }
}