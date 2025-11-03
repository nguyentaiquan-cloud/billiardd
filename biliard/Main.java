
package billiard;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("🎱 Lập trình song song - Bài toán bi-a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);

        BallPanel panel = new BallPanel();
        JComboBox<String> mapSelector = new JComboBox<>(new String[]{"Map 1", "Map 2", "Map 3", "Map 4"});
        JTextField ballCountField = new JTextField("10", 5);
        JButton loadButton = new JButton("Tạo Map");
        JButton startButton = new JButton("Bắt đầu");

        loadButton.addActionListener(e -> {
            int mapId = mapSelector.getSelectedIndex() + 1;
            int count;
            try {
                count = Integer.parseInt(ballCountField.getText());
            } catch (NumberFormatException ex) {
                count = 10;
            }
            panel.loadMap(mapId, count);
        });

        startButton.addActionListener(e -> panel.startGame());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Chọn Map:"));
        topPanel.add(mapSelector);
        topPanel.add(new JLabel("Số bóng:"));
        topPanel.add(ballCountField);
        topPanel.add(loadButton);
        topPanel.add(startButton);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
