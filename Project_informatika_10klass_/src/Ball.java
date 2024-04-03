import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ball {
    Color color;
    double x, y;
    int radius;
    double dx = 0, dy = 0;
    int ddown = 0, dright = 0, dleft = 0, dup = 0;
    double speed_ball = 20;
    int player_shoot;
    BufferedImage ball;
    public Ball(int x, int y, int radius, Color color, int speed) throws IOException {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radius = radius;
        player_shoot = 0;
        this.ball = ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img_2.png"));


    }
    public void setSpeed(int speed){
        this.speed_ball = speed;
    }
    public double getDx() {
        return dx;
    }

    public int getPlayer_shoot() {
        return player_shoot;
    }

    public void setPlayer_shoot(int player_shoot) {
        this.player_shoot = player_shoot;
    }

    public double getDy() {
        return dy;
    }

    public void setImage(BufferedImage image){
        this.ball = image;
    }
    void paint(Graphics g) {
//        g.setColor(color);
        this.x += dx;
        this.y += dy;
        dx *= 0.99;
        dy *= 0.99;
        g.drawImage(ball, (int) this.x, (int) this.y, this.radius, this.radius, null);
//        g.fillOval((int) (this.x), (int) (this.y), this.radius, this.radius);
    }

    public int getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public void setDx(double dx) {

        if (Math.abs(dx) > 1.5*speed_ball) {
            if (dx < 0) {
                this.dx = -1.5*speed_ball;
            } else {
                this.dx = 1.5*speed_ball;
            }
        } else {
            this.dx = dx;
        }
    }

    public void setDy(double dy) {


        if (Math.abs(dy) > 1.5*speed_ball) {
            if (dy < 0) {
                this.dy = -1.5*speed_ball;
            } else {
                this.dy = 1.5*speed_ball;
            }
        } else {
            this.dy = dy;
        }
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    void update(boolean up, boolean down, boolean left, boolean right) {
        if (up) {
            dup = (int) -speed_ball;
        }
        if (down) {
            ddown = (int) speed_ball;
        }
        if (left) {
            dleft = (int) -speed_ball;
        }
        if (right) {
            dright = (int) speed_ball;
        }
        dx = dleft + dright;
        dy = dup + ddown;

    }
}
