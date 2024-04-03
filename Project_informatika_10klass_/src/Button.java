import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {
    int x, y, width, height, width_end, height_end, width_start, height_start;
    int x_start;
    int y_start;
    int x_end;
    int y_end;
    BufferedImage image;
    boolean button_used;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isFlag() {
        return flag;
    }


    boolean flag;

    public int getWidth_start() {
        return width_start;
    }

    public int getHeight_start() {
        return height_start;
    }

    public int getX_start() {
        return x_start;
    }

    public int getY_start() {
        return y_start;
    }

    public int getX_end() {
        return x_end;
    }

    public int getY_end() {
        return y_end;
    }

    public void setWidth_end(int width_end) {
        this.width_end = width_end;
    }

    public void setHeight_end(int height_end) {
        this.height_end = height_end;
    }

    public void setWidth_start(int width_start) {
        this.width_start = width_start;
    }

    public void setHeight_start(int height_start) {
        this.height_start = height_start;
    }

    public void setX_start(int x_start) {
        this.x_start = x_start;
    }

    public void setY_start(int y_start) {
        this.y_start = y_start;
    }

    public void setX_end(int x_end) {
        this.x_end = x_end;
    }

    public void setY_end(int y_end) {
        this.y_end = y_end;
    }

    public void setButton_used(boolean button_used) {
        this.button_used = button_used;
    }

    //    public Button(int x, int y, int x_start, int y_start, int x_end, int y_end, int width, int height, int width_start, int height_start, int width_end, int height_end, boolean flag) throws IOException {
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.image = ImageIO.read(new File("C:\\Users\\atroshkinia.25\\project_13.09\\project\\Button\\src\\Button_start.png"));;
//        this.flag = flag;
//        this.width_end = width_end;
//        this.height_end = height_end;
//        this.width_start = width_start;
//        this.height_start = height_start;
//        this.x_start = x_start;
//        this.x_end = x_end;
//        this.y_start = y_start;
//        this.y_end = y_end;
//    }
    ButtonAction action;

    public boolean isButton_used() {
        return button_used;
    }

    public Button(int x, int y, int height, int width, boolean flag, boolean button_used, BufferedImage image, ButtonAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.width_start = width;
        this.width_end = (int) Math.round(width_start * 1.5);
        this.height = height;
        this.height_start = height;
        this.height_end = (int) Math.round(height * 1.5);
        this.x_start = x;
        this.y_start = y;
        this.x_end = x - (width_end - width_start) / 2;
        this.y_end = y - (height_end - height_start) / 2;
        this.image = image;
        this.button_used = true;
        this.flag = false;
        this.action = action;
    }


    public int getWidth_end() {
        return width_end;
    }

    public int getHeight_end() {
        return height_end;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void onMouseHit(int x, int y) {
        action.button_start_onClick();
    }

    public void onMouseHit2(int x, int y) throws InterruptedException {
        action.button_restart_onClick();
    }
    public void onMouseHit3(int x, int y){
        action.button_player_first();
    }
    public void onMouseHit4(int x, int y){
        action.button_player_second();
    }
    public void onMouseHit5(int x, int y){
        action.button_speed();
    }
    public void onMouseHit6(int x, int y){
        action.button_ball();
    }

    public void paint(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.image, x, y, width, height, null);
    }
}
