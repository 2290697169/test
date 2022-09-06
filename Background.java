
import java.awt.*;

public class Background {

    static int sum = 0;

    static int num = 1;

    int goal = num*(num-1)*100+100;

    public void paintSelf(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.blue);
        g.fillRect(0, 30, 960, 130);
        g.setColor(c);

        g.setColor(Color.green);
        g.fillRect(0, 160, 960, 420);
        g.setColor(c);


        switch (MainFrame.s){
            case 0 :
                drawWord(g,80,Color.red,"准备开始!",320,250);
                break;
            case 1 :
                g.setColor(Color.black);
                g.fillOval(465, 60, 30, 30);
                g.setColor(c);

                g.setColor(Color.black);
                g.fillRect(470, 80, 20, 50);
                g.setColor(c);

                drawWord(g,35,Color.YELLOW,"得分:"+sum,50,70);
                drawWord(g,35,Color.YELLOW,"关卡:"+num,820,115);
                drawWord(g,35,Color.YELLOW,"目标:"+goal,50,115);
                break;
            case 2:
                drawWord(g,80,Color.black,"游戏结束!",320,250);
                break;
        }

    }
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("华文行楷",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}
