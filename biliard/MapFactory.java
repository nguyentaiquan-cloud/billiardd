
package billiard;
import java.util.Arrays;
import java.awt.*;
import java.util.List;

public class MapFactory {

    public static Map createMap(int id) {
        switch (id) {
            case 1:
                return new Map(
                        "Map 1 - Cơ bản",
                        new Color(20, 120, 20),
                        new Point(400, 300),
                        Arrays.asList(
                                new Point(50, 50),
                                new Point(750, 550)
                        ),
                        Arrays.asList() // không có vật cản
                );

            case 2:
                return new Map(
                        "Map 2 - Có vật cản",
                        new Color(10, 100, 80),
                        new Point(100, 100),
                        Arrays.asList(
                                new Point(700, 500)
                        ),
                        Arrays.asList(
                                new Obstacle(300, 200, 150, 20),
                                new Obstacle(200, 400, 300, 20)
                        )
                );
            case 3:
                 return new Map(
                         "Map 3 -  địa ngục",
                         new Color(10, 50, 40),
                         new Point(100, 100),
                         Arrays.asList(
                                 new Point(700, 450)
                         ),
                         Arrays.asList(
                                 new Obstacle(500, 100, 250, 10),
                                 new Obstacle(200, 400,650, 10),
                                 new Obstacle(500, 200, 350, 10)
                         )
                 );

            case 4:
                return new Map(
                        "Map 4 - Thử thách",
                        new Color(60, 0, 80),
                        new Point(400, 100),
                        Arrays.asList(
                                new Point(400, 550),
                                new Point(700, 300)
                        ),
                        Arrays.asList(
                                new Obstacle(150, 250, 500, 20),
                                new Obstacle(300, 400, 200, 20),
                                new Obstacle(100, 500, 100, 20)
                        )
                );

            default:
                return createMap(1);
        }
    }
}

