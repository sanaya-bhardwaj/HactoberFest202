import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;

public class FlowerDrawingProgram {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Flower Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -4244032271733470446L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawFlower(g, getWidth() / 2, getHeight() / 2, 100, 50, 12);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void drawFlower(Graphics g, int x, int y, int radius, int petalLength, int numPetals) {
        Graphics2D g2d = (Graphics2D) g;

        Ellipse2D center = new Ellipse2D.Double(x - radius / 2, y - radius / 2, radius, radius);
        g2d.draw(center);

        double angleIncrement = 2 * Math.PI / numPetals;
        for (int i = 0; i < numPetals; i++) {
            double angle = i * angleIncrement;
            double xOffset = petalLength * Math.cos(angle);
            double yOffset = petalLength * Math.sin(angle);
            drawPetal(g2d, x, y, x + xOffset, y + yOffset);
        }
    }

    private static void drawPetal(Graphics2D g2d, double x1, double y1, double x2, double y2) {
        QuadCurve2D petal = new QuadCurve2D.Double(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
        g2d.draw(petal);
    }
}

