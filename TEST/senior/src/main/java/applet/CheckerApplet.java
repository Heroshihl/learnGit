package applet;


import java.applet.Applet;
import java.awt.*;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/31
 * @CLASSNAME
 * @description
 */
public class CheckerApplet extends Applet {
    int squareSize = 50;// 初始化默认大小
    @Override
    public void init () {
        String squareSizeParam = getParameter ("squareSize");
        parseSquareSize (squareSizeParam);
        String colorParam = getParameter ("color");
        Color fg = parseColor (colorParam);
        setBackground (Color.red);
        setForeground (fg);
    }
    private void parseSquareSize (String param) {
        if (param == null) {
            return;
        }
        try {
            squareSize = Integer.parseInt (param);
        }
        catch (Exception e) {
            // 保留默认值
        }
    }
    private Color parseColor (String param) {
        return null;
    }
    @Override
    public void paint (Graphics g) {}
}
