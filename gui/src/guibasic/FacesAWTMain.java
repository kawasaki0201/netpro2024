package guibasic;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    class FaceFrame extends Frame {
        private FaceObj[][] faceObjs;

        FaceFrame() {
            faceObjs = new FaceObj[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int setEmotion = i;
                    Color faceColor;
                    switch (i) {
                        case 0:
                            faceColor = Color.GREEN;
                            break;
                        case 1:
                            faceColor = Color.YELLOW;
                            break;
                        case 2:
                            faceColor = Color.RED;
                            break;
                        default:
                            faceColor = Color.WHITE;
                            break;
                    }
                    faceObjs[i][j] = new FaceObj(50 + j * 250, 50 + i * 250, setEmotion, faceColor);
                }
            }
        }
        

        public void paint(Graphics g) {
            super.paint(g);

            for (int i = 0; i < faceObjs.length; i++) {
                for (int j = 0; j < faceObjs[i].length; j++) {
                    faceObjs[i][j].drawFace(g);
                }
            }
        }
    }

    private class FaceObj {
        private int xStart;
        private int yStart;
        private int w = 150;
        private int h = 150;
        private int setEmotion;
        private Color faceColor;

        public FaceObj(int x, int y, int setEmotion, Color faceColor) {
            xStart = x;
            yStart = y;
            this.setEmotion = setEmotion;
            this.faceColor = faceColor;
        }

        public void drawFace(Graphics g) {
            g.setColor(faceColor);
            g.fillRect(xStart, yStart, w, h);
            g.setColor(Color.BLACK);
            drawRim(g);
            drawBrow(g);
            drawEye(g);
            drawNose(g);
            drawMouth(g);
        }

        private void drawRim(Graphics g) {
            g.drawRect(xStart, yStart, w, h);
        }

        private void drawBrow(Graphics g) {
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h / 4;
            int browWidth = w / 4;

            switch (setEmotion) {
                case 0:
                    g.fillRect(xMiddle - browWidth / 2 - 40, yMiddle, browWidth, 5);
                    g.fillRect(xMiddle - browWidth / 2 + 40, yMiddle, browWidth, 5);
                    break;
                case 1:
                    g.fillRect(xMiddle - browWidth / 2 - 40, yMiddle - 10, browWidth, 5);
                    g.fillRect(xMiddle - browWidth / 2 + 40, yMiddle - 10, browWidth, 5);
                    break;
                case 2:
                    g.fillRect(xMiddle - browWidth / 2 - 40, yMiddle + 10, browWidth, 5);
                    g.fillRect(xMiddle - browWidth / 2 + 40, yMiddle + 10, browWidth, 5);
                    break;
            }
        }

        private void drawEye(Graphics g) {
            int r = 20;
            g.drawOval(xStart + w / 4 - r / 2 - 15 / 2, yStart + h / 3 - 15 / 2, r + 15, r + 15);
            g.drawOval(xStart + 3 * w / 4 - r / 2 - 15 / 2, yStart + h / 3 - 15 / 2, r + 15, r + 15);
            g.fillOval(xStart + w / 4 - r / 4, yStart + h / 3 + r / 4, r / 2, r / 2);
            g.fillOval(xStart + 3 * w / 4 - r / 4, yStart + h / 3 + r / 4, r / 2, r / 2);
        }

        private void drawNose(Graphics g) {
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h / 2;
            int noseWidth = w / 20;
            int noseHeight = h / 6;
            g.fillRect(xMiddle - noseWidth / 2, yMiddle - noseHeight / 2, noseWidth, noseHeight);
        }

        private void drawMouth(Graphics g) {
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 30;

            switch (setEmotion) {
                case 0:
                    g.drawArc(xMiddle - 50, yMiddle - 20, 100, 40, 0, -180);
                    break;
                case 1:
                    g.drawOval(xMiddle - 25, yMiddle - 20, 50, 40);
                    break;
                case 2:
                    g.drawArc(xMiddle - 50, yMiddle, 100, 40, 0, 180);
                    break;
            }
        }
    }
}
