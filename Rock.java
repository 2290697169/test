
import java.awt.*;

public class Rock extends Father{
    public Rock(){
        }
    public Rock(int width, int height, int m, int count, Color color){
        super();
        this.x = (int)(Math.random()*700)+100;
        this.y = (int)(Math.random()*230)+250;
        this.width = width;
        this.height = height;
        this.m = m;
        this.count=count;
        this.flag = false;
        this.color = color;

    }
}
