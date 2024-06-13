package guichat;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {

    int h = 100;
    int w = 100;

    int xStart = 0;
    int yStart = 0;

    int eyebrowAngle = 0;

    public void setXY(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setSize(int h, int w) {
        this.h = h;
        this.w = h;
    }

    public GUIAnimatinFaceLook() {

    }

    public void setEyebrowAngle(int angle) {
        this.eyebrowAngle = angle;
    }

    void makeFace(Graphics g) {
        makeEyes(g, w / 5);
        makeNose(g, h / 5);
        makeMouth(g, w / 2);
        makeEyebrows(g);
    }

    public void makeFace(Graphics g, String emotion) {
        if (emotion.equals("normal")) {
            makeEyes(g, w / 5);
            makeNose(g, h / 5);
            makeMouth(g, w / 2);
        } else if (emotion.equals("smile")) {
            makeSmileEyes(g, w / 5);
            makeNose(g, h / 5);
            makeSmileMouth(g, w / 2);
        } else if (emotion.equals("angly")) {
            makeanglyEyes(g, w / 5);
            makeNose(g, h / 5);
            makeanglyMouth(g, w / 2);
        }
        makeEyebrows(g);
    }

    void makeEyes(Graphics g, int eyeSize) {
        int r = eyeSize;
        g.setColor(Color.black);
        g.drawOval(xStart + w / 4 - r / 2 - 15 / 2, yStart + h / 3 - 15 / 2, r + 15, r + 15);
        g.drawOval(xStart + 3 * w / 4 - r / 2 - 15 / 2, yStart + h / 3 - 15 / 2, r + 15, r + 15);
        g.fillOval(xStart + w / 4 - r / 4, yStart + h / 3 + r / 4, r / 2 + r / 3, r / 2 + r / 3);
        g.fillOval(xStart + 3 * w / 4 - r / 4, yStart + h / 3 + r / 4, r / 2 + r / 3, r / 2 + r / 3);
    }

    void makeSmileEyes(Graphics g, int eyeSize) {
        g.setColor(Color.black);
        g.drawArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize / 2, 0, 180);
        g.drawArc(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize / 2, 0, 180);
    }

    void makeanglyEyes(Graphics g, int eyeSize) {
        int r = eyeSize;
        g.setColor(Color.black);
        g.drawOval(xStart + w / 4 - r / 2 - 15 / 2, yStart + h / 3 - 15 / 2, r + 15, r + 15);
        g.drawOval(xStart + 3 * w / 4 - r / 2 - 15 / 2, yStart + h / 3 - 15 / 2, r + 15, r + 15);
        g.fillOval(xStart + w / 4 - r / 4, yStart + h / 3 + r / 4, r / 2, r / 2);
        g.fillOval(xStart + 3 * w / 4 - r / 4, yStart + h / 3 + r / 4, r / 2, r / 2);
    }

    public void makeNose(Graphics g, int noseSize) {
        g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
    }

    public void makeMouth(Graphics g, int mouthSize) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawLine(xMiddle - mouthSize / 2, yMiddle, xMiddle + mouthSize / 2, yMiddle);
    }

    public void makeSmileMouth(Graphics g, int mouthSize) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawArc(xMiddle - mouthSize / 2, yMiddle - 20, mouthSize, 40, 0, -180);
    }

    public void makeanglyMouth(Graphics g, int mouthSize) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawArc(xMiddle - mouthSize / 2, yMiddle, mouthSize, 40, 0, 180);
    }

    void makeEyebrows(Graphics g) {
        int leftX = xStart + (h * 2 / 7);
        int leftY = yStart + (w * 1 / 4)-5;
        int rightX = xStart + (h * 5 / 7);
        int rightY = yStart + (w * 1 / 4)-5;
        int length = w / 5;

        g.setColor(Color.black);

        g.drawLine(leftX, leftY,
                   leftX + (int) (length * Math.cos(Math.toRadians(eyebrowAngle))),
                   leftY - (int) (length * Math.sin(Math.toRadians(eyebrowAngle))));

        g.drawLine(rightX, rightY,
                   rightX - (int) (length * Math.cos(Math.toRadians(eyebrowAngle))),
                   rightY - (int) (length * Math.sin(Math.toRadians(eyebrowAngle))));
    }
}
