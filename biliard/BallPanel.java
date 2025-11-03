package billiard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BallPanel extends JPanel implements Runnable {
    private Map currentMap;
    private List<Ball> balls = new ArrayList<>();
    private boolean started = false;
    private int predictedBall = -1;

    public void loadMap(int mapId, int numBalls) {
        currentMap = MapFactory.createMap(mapId);
        setBackground(currentMap.getBackground());
        balls.clear();

        int radius = Math.max(10, 40 - numBalls); // càng nhiều bóng càng nhỏ
        Point start = currentMap.getStartPoint();

        for (int i = 0; i < numBalls; i++) {
            balls.add(new Ball(i + 1, start.x, start.y, radius));
        }

        predictedBall = 1 + (int)(Math.random() * numBalls);
        repaint();
    }

    public void startGame() {
        if (currentMap == null || balls.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy chọn map và số lượng bóng trước!");
            return;
        }
        started = true;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (started) {
            for (Ball ball : balls) {
                ball.move();
                handleCollisions(ball);
                if (checkHole(ball)) {
                    started = false;
                    JOptionPane.showMessageDialog(this,
                            "🎯 Quả bóng số " + ball.getId() + " đã rơi vào lỗ!\n"
                            + (ball.getId() == predictedBall ? "Dự đoán chính xác!" : "Sai, bóng " + predictedBall + " mới là dự đoán."));
                    break;
                }
            }
            repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {}
        }
    }

    private void handleCollisions(Ball ball) {
        if (ball.getX() < ball.getRadius() || ball.getX() > getWidth() - ball.getRadius())
            ball.bounceX();
        if (ball.getY() < ball.getRadius() || ball.getY() > getHeight() - ball.getRadius())
            ball.bounceY();

        // va chạm vật cản
        for (Obstacle obs : currentMap.getObstacles()) {
            Rectangle r = obs.getRect();
            double bx = ball.getX();
            double by = ball.getY();
            if (r.contains(bx, by)) {
                ball.bounceY();
                ball.bounceX();
            }
        }
    }

    private boolean checkHole(Ball ball) {
        for (Point hole : currentMap.getHoles()) {
            double dx = ball.getX() - hole.x;
            double dy = ball.getY() - hole.y;
            if (Math.sqrt(dx * dx + dy * dy) < ball.getRadius() + 10)
                return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentMap == null) return;

        // vẽ lỗ
        g.setColor(Color.BLACK);
        for (Point hole : currentMap.getHoles()) {
            g.fillOval(hole.x - 10, hole.y - 10, 20, 20);
        }

        // vẽ vật cản
        for (Obstacle obs : currentMap.getObstacles()) {
            obs.draw(g);
        }

        // vẽ bóng
        if (started) {
            for (Ball ball : balls) {
                ball.draw(g);
            }
        }

        // hiện dự đoán
        g.setColor(Color.WHITE);
        g.drawString("Dự đoán: Bóng " + predictedBall + " sẽ vào lỗ đầu tiên", 20, 20);
    }
}
