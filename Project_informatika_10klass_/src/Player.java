import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    BufferedImage player;
    int radius;
    Color color;
    int x, y;
    int dx, dy;
    int dright, dleft, dup, ddown;

    public void setDright(int dright) {
        this.dright = dright;
    }

    public void setDleft(int dleft) {
        this.dleft = dleft;
    }

    public void setDup(int dup) {
        this.dup = dup;
    }

    public void setDdown(int ddown) {
        this.ddown = ddown;
    }

    public int getRadius() {
        return radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
    public void setPlayer(BufferedImage image){
        this.player = image;
    }

    public int getDright() {
        return dright;
    }

    public int getDleft() {
        return dleft;
    }

    public int getDup() {
        return dup;
    }

    public int getDdown() {
        return ddown;
    }



    public Player(Color color, int x, int y, int image) throws IOException {
        radius = 85;
//        if(image == 11){
//            this.player = ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img.png"));
//        }else if(image == 12){
//
//            this.player = ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/player_first.png"));
//        }
//        else if(image==21){
//            this.player = ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img_4.png"));
//
//        }else{
//
//            this.player = ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/player_second.png"));
//        }
        this.color = color;
        this.x = x;
        this.y = y;
    }

    void paint(Graphics g) {
        g.drawImage(player, this.x, this.y,  this.radius-5,  this.radius-5, null);
//        g.setColor(color);
//        g.fillOval(this.x, this.y, this.radius - 5, this.radius - 5);
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    void update(boolean up, boolean down, boolean left, boolean right) {
        if (up) {
            dup = -3;
        } else {
            dup = 0;
        }
        if (down) {
            ddown = 3;
        } else {
            ddown = 0;
        }
        if (left) {
            dleft = -3;
        } else {
            dleft = 0;
        }
        if (right) {
            dright = 3;
        } else {
            dright = 0;
        }

        dx = (dright + dleft);
        dy = (dup + ddown);
        this.x += dx;
        this.y += dy;
    }
}
