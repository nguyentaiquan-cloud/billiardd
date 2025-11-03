package billiard;
import java.awt.*;
import java.util.List;

public class Map {
    private String name;
    private Color background;
    private Point startPoint;
    private List<Point> holes;
    private List<Obstacle> obstacles;

    public Map(String name, Color background, Point startPoint, List<Point> holes, List<Obstacle> obstacles) {
        this.name = name;
        this.background = background;
        this.startPoint = startPoint;
        this.holes = holes;
        this.obstacles = obstacles;
    }

    public String getName() { return name; }
    public Color getBackground() { return background; }
    public Point getStartPoint() { return startPoint; }
    public List<Point> getHoles() { return holes; }
    public List<Obstacle> getObstacles() { return obstacles; }
}


