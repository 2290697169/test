import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    static int s;

    int total = 0;

    Background bg = new Background();
    Line line = new Line(this);

    List<Father> objectList = new ArrayList<Father>();
    Image offScreenImage;
    Boolean isPlace;

    {
        Gold gold;
        Rock rock;
        for(int j = 0 ; j < 5;j++){
            gold = new Gold(35, 35, 30,40,Color.orange);
            j = panduan(gold,j);
        }
        for(int j = 0 ; j < 4;j++){
            gold = new Gold(52,46,60,90,Color.orange);
            j = panduan(gold,j);
        }
        for(int j = 0 ; j < 3;j++){
            gold = new Gold(124,112,120,200,Color.orange);
            j = panduan(gold,j);
        }
        for(int j = 0 ;j < 4 ;j++){
            rock = new Rock(76,70,70,10,Color.GRAY);
            j = panduan(rock,j);
        }
        total = objectList.size();
    }

    public static void main(String[] args) {
        MainFrame game = new MainFrame();
        game.launch();
    }

    public int panduan(Father gold, int j){
        isPlace = true;
        for(Father obj:objectList){
            if(gold.getRec().intersects(obj.getRec())){
                isPlace = false;
            }
        }
        if(isPlace){
            objectList.add(gold);
        } else {
            j--;
        }
        return j;
    }
    public void launch(){
        this.setVisible(true);
        this.setSize(960,570);
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工小游戏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(s){
                    case 0:
                        if(e.getButton() == 3){
                            s = 1;
                        }
                        break;
                    case 1:
                        if(e.getButton() == 1){
                            line.e=1;
                        }
                        break;
                }

            }
        });

        while(true) {
            repaint();
            nextLevel();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g){
        offScreenImage = this.createImage(960,570);
        Graphics gImage = offScreenImage.getGraphics();
        bg.paintSelf(gImage);

        switch (s){
            case 0:
                break;
            case 1:
                for (Father obj : objectList) {
                    obj.paintSelf(gImage);
                }
                line.paintSelf(gImage);
                if(total == 0 && Background.sum < bg.goal){
                    s = 2;
                }
                break;
            case 2:
                bg.paintSelf(gImage);
                break;
        }

        g.drawImage(offScreenImage, 0, 0, this);

    }

    public void nextLevel()  {
        if(s == 1) {
            if (Background.sum >= bg.goal) {
                Background.num++;
                dispose();
                MainFrame mainFrame = new MainFrame();
                mainFrame.launch();
            }
        }
    }

}
