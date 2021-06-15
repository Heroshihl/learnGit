package applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/31
 * @CLASSNAME
 * @description
 */
public class ExampleEventHandling extends Applet
        implements MouseListener {
    StringBuffer strBuffer;

    @Override
    public void init() {
        addMouseListener(this);
        strBuffer = new StringBuffer();
        addItem("initializing the applet ");
    }

    @Override
    public void start() {
        addItem("starting the applet ");
    }

    @Override
    public void stop() {
        addItem("stopping the applet ");
    }

    @Override
    public void destroy() {
        addItem("unloading the applet");
    }

    void addItem(String word) {
        System.out.println(word);
        strBuffer.append(word);
        strBuffer.append("\t");
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        //Draw a Rectangle around the applet's display area.
        g.drawRect(0, 0,
                getWidth() - 1,
                getHeight() - 1);

        //display the string inside the rectangle.
        g.drawString(strBuffer.toString(), 10, 20);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        addItem("mouse clicked! ");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
