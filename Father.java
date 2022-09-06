import javax.swing.*;
import java.awt.*;

public class Father extends JPanel{

    public int x ;
    public int y;

    public int width;
    public int height;

    Color color = Color.black;
    boolean flag = false;

    int m;

    int count;

    public  void paintSelf(Graphics g){
        Color c = g.getColor();
        g.setColor(color);
        g.fillOval(x, y, width, height);
        g.setColor(c);
    }

    public int getWidth(){
        return width;
    }

    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }

}
