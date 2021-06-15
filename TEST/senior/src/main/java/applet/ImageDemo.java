package applet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/31
 * @CLASSNAME
 * @description
 */
public class ImageDemo extends Applet {
    private Image image;
    private AppletContext context;

    @Override
    public void init() {
        context = this.getAppletContext();
        String imageURL = this.getParameter("image");
        if (imageURL == null) {
            imageURL = "E:/笔记/picture/shiro.jpg";
        }
        try {
            URL url = new URL(this.getDocumentBase(), imageURL);
            image = context.getImage(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // Display in browser status bar
            context.showStatus("Could not load image!");
        }
    }

    @Override
    public void paint(Graphics g) {
        context.showStatus("Displaying image");
        g.drawImage(image, 0, 0, 200, 84, null);
        g.drawString("www.javalicense.com", 35, 100);
    }
}
