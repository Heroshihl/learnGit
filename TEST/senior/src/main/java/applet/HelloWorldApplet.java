package applet;

import java.applet.Applet;
import java.awt.*;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/31
 * @CLASSNAME
 * @description
 */
public class HelloWorldApplet extends Applet {
    @Override
    public void paint(Graphics g) {
        g.drawString("hello world ",25,50);
    }
}
