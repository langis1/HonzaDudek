import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Fractal2 {

    public static void mainDraw(Graphics graphics) {
        // draw four different size and color rectangles.
        // avoid code duplication.

//        drawOneHexagon(graphics,HEIGHT/2, WIDTH/2, 150);
//        drawOneHexagon(graphics,HEIGHT/2 - (int)(75*0.5), WIDTH/2 - (int)(75*0.86), 75);
//        drawOneHexagon(graphics,HEIGHT/2 + 75, WIDTH/2, 75);
//        drawOneHexagon(graphics,HEIGHT/2 -  (int)(75*0.5), WIDTH/2+ (int)(75*0.86), 75);

        drawFractal(graphics,HEIGHT/2, WIDTH/2, 150);

    }

//    public class Fractal2 {
//    }

    public static void drawFractal(Graphics graphics, int x, int y, int size) {
        drawOneHexagon(graphics,x, y, size);
        System.out.println(size);

        if (size > 10) {
            drawFractal(graphics,(int)(x - size/2 * 0.5), (int) (y - size/2 * 0.86), size/2);
            drawFractal(graphics,x + size/2, y , size/2);
            drawFractal(graphics,(int)(x - size/2 * 0.5), (int) (y + size/2 * 0.86), size/2);
        }
    }

    public static void drawOneHexagon(Graphics graphics, int x, int y, int size) {
        graphics.drawLine( (x - size / 2), (int) (y - size * 0.866), x + size / 2, (int) (y - size * 0.866));
        graphics.drawLine( (x + size / 2),(int)( y - size * 0.866),x + size,  y);
        graphics.drawLine( (x + size    ), y, x + size / 2,(int)( y + size * 0.866));
        graphics.drawLine( (x + size / 2),(int)( y + size * 0.866),x - size / 2, (int) (y + size * 0.866));
        graphics.drawLine( (x - size / 2),(int)( y + size * 0.866),x - size, y);
        graphics.drawLine( (x - size    ),y, x - size / 2,(int)( y - size * 0.866));
    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}

