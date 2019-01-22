import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGameNeww extends JFrame {

    static char dir = '•';
    public static int[] map = new int[] {50, 16};
    public static int[] tailX, tailY;
    public static int[] snakeHead = new int[2];
    public static int[] food = new int[2];
    public static int snakeLength = 0;
    public static boolean gameOver = false;

    public static void main(String[] args) {
        new SnakeGameNeww();
        snakeHead = new int[] {25, 8};
        tailX = new int[map[0] * map[1]];
        tailY = new int[map[0] * map[1]];

        food[0] = (int) (Math.random() * map[0] + 1);
        food[1] = (int) (Math.random() * map[1]);
    }

    public SnakeGameNeww() {

        this.setSize(250, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Snake");
        this.setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                dir = e.getKeyChar();
            }
        });

    }
}
