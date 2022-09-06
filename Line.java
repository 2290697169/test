import javax.swing.*;
import java.awt.*;

public class Line extends JPanel{

    int x=485;
    int y=130;

    int endx=500;
    int endy=200;

    double length = 40;
    double n = 0;

    int dir = 1;

    int e=0;

    Background bg = new Background();
    MainFrame frame ;
    public Line(MainFrame frame){
        this.frame = frame;
    }

    public void paintSelf(Graphics g){
        logic();
        switch(e){
            case 0:
                length = 80;
                if(n < 0.05){
                    dir = 1;
                } else if(n > 0.95){
                    dir = -1;
                }
                n = n+0.005*dir;
                lines(g);
                break;
            case 1:
                if(length < 500) {
                    length = length + 4;
                    lines(g);
                } else {
                    e = 2;
                }
                break;
            case 2 :
                if(length > 30) {
                    length = length - 4;
                    lines(g);
                }else{
                    e = 0;
                }
                break;
            case 3 :
                int m = 1;
                if(length > 30) {
                    length = length - 4;
                    lines(g);
                    for(Father obj:this.frame.objectList) {
                        if(obj.flag){
                            m = obj.m;
                            obj.x = endx - obj.width/2;
                            obj.y = endy;
                            if(length <= 30){
                                obj.x = -150;
                                obj.y = -150;

                                frame.total--;

                                e = 0;
                                obj.flag = false;
                                bg.sum += obj.count;
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

        }

    }

    public void logic(){
        for(Father obj:this.frame.objectList){
            if(endx >= obj.x&&endx <= obj.x+obj.width && endy >= obj.y && endy <= obj.y + obj.height){
                e =3;
                obj.flag = true;
            }
        }
    }

    public void lines(Graphics g){
        endx = x + (int) (length * Math.cos(n * Math.PI));
        endy = y + (int) (length * Math.sin(n * Math.PI));
        g.setColor(Color.red);
        g.drawLine(x, y, endx, endy);
    }
}
