package billiard;

import java.awt.*;
import java.util.Random;

public class Ball {
    private double x, y;
    private double dx, dy;
    private int radius;
    private Color color;
    private int id;

    public Ball(int id, int x, int y, int radius) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        Random r = new Random();
        double angle = Math.toRadians(r.nextInt(360));
        dx = Math.cos(angle) * (2 + r.nextDouble() * 2);
        dy = Math.sin(angle) * (2 + r.nextDouble() * 2);
        color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void bounceX() { dx = -dx; }
    public void bounceY() { dy = -dy; }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)(x - radius), (int)(y - radius), radius * 2, radius * 2);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(id), (int)x - 4, (int)y + 4);
    }

    public int getId() { return id; }
    public double getX() { return x; }
    public double getY() { return y; }
    public int getRadius() { return radius; }
}

