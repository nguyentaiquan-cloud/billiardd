package billiard;
import java.awt.*;

public class Obstacle {
    private Rectangle rect;

    public Obstacle(int x, int y, int w, int h) {
        rect = new Rectangle(x, y, w, h);
    }

    public Rectangle getRect() {
        return rect;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(100, 50, 0));
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}


