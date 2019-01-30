import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGameNeww extends JFrame {

    static char dir = '0';
    public static int[] map = new int[]{50, 16};
    public static int[] tailX, tailY;
    public static int[] snakeHead = new int[2];
    public static int[] food = new int[2];
    public static int snakeLength = 0;
    public static boolean gameOver = false;

    public static void main(String[] args) {
        new SnakeGameNeww();
        snakeHead = new int[]{25, 8};
        tailX = new int[map[0] * map[1]];
        tailY = new int[map[0] * map[1]];

        int random = (int) Math.random();
        food[0] = (int) (Math.random() * map[0] + 1);
        food[1] = (int) (Math.random() * map[1]);

        movement(dir);
        drawEverything(map, snakeHead, food);
    }

    public static void movement(char dir) {
        if (snakeLength > 1) {
            for (int i = snakeLength - 1; i >= 1; i--) {
                tailX[i] = tailX[i - 1];
                tailY[i] = tailY[i - 1];
            }
        }
        tailX[0] = snakeHead[0];
        tailY[0] = snakeHead[1];

        switch (dir) {
            case 'w':
                snakeHead[1] -= 1;
                break;
            case 'a':
                snakeHead[0] -= 1;
                break;
            case 's':
                snakeHead[1] += 1;
                break;
            case 'd':
                snakeHead[0] += 1;
                break;
        }

        if (snakeHead[0] == food[0] && snakeHead[1] == food[1]) {
            eatFood();
        }

        if (snakeHead[0] > map[0] || snakeHead[0] < 0 || snakeHead[1] > map[1] || snakeHead[1] < 0) {
            gameOver = true;
        }

        for (int i = 0; i < snakeLength; i++) {
            if ((snakeHead[0] == tailX[i]) && (snakeHead[1] == tailY[i])) {
                gameOver = true;
            }
        }
    }

    public static void drawEverything(int[] map, int[] snakeHead, int[] food) {

        int width = map[0];
        int height = map[1];

        System.out.println(" ");
        for (int i = 0; i <= width + 1; i++) {
            System.out.print("#");

        }

        System.out.println(" ");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= width + 1; j++) {
                if (j == 0) {
                    System.out.print("#");
                } else if (j == width + 1) {
                    System.out.print("#");
                } else if (j == snakeHead[0] && i == snakeHead[1]) {
                    System.out.print("Q");
                } else if (j == food[0] && i == food[1]) {
                    System.out.print("F");
                } else if (snakeLength > 0) {
                    boolean isTail = false;

                    for (int k = 0; k < snakeLength; k++) {
                        if (j == tailX[k] && i == tailY[k]) {
                            isTail = true;
                            System.out.print("O");
                            break;
                        }
                    }
                    if (isTail == false) {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }

        for (int i = 0; i <= width + 1; i++) {
            System.out.print("#");

        }

    }

    public static void eatFood() {
        food[0] = (int) (Math.random() * map[0] + 1);
        food[1] = (int) (Math.random() * map[1]);
        snakeLength++;
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
