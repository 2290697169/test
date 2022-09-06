
import java.awt.*;

public class Gold extends Father {

    public Gold() {
    }
    public Gold(int width, int height, int m, int count, Color color){
        super();
        this.x = (int) (Math.random() * 700) + 100;
        this.y = (int) (Math.random() * 200) + 250;
        this.flag = false;
        this.width = width;
        this.height = height;
        this.m = m;
        this.count = count;
        this.color = color;
    }
}
