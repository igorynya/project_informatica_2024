import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class MyFrame extends JFrame implements MouseListener, MouseMotionListener, KeyEventDispatcher {
    BufferedImage image, image_button, prep1, prep2;
    int h;
    int cnt = 0;
    boolean ball_flag = false;
    boolean prep_flag = false, player_first_flag = false, player_second_flag = false;
    int cnt_kletok = 8, image_player_first, image_player_second;
    int kletka, kletka_player_first, kletka_player_second;
    public ArrayList<Button> buttons_list = new ArrayList<Button>();
    boolean gameStart, button_start_flag;
    Player player_first, player_second;
    public ArrayList<ArrayList<Integer>> list_kletka = new ArrayList<ArrayList<Integer>>();
    boolean setka_flag = true, speed_flag = false;

    Ball ball;
    double dx = 0.01, dy = 0.01;
    boolean goal_flag;
    boolean up, down, right, left;
    boolean w, s, a, d;
    boolean flag_right;
    int goal_first, goal_second, speed;

    public Player getPlayer_first() {
        return player_first;
    }

    public boolean isW() {
        return w;
    }

    public boolean isSetka_flag() {
        return setka_flag;
    }

    void setSetka_flag(boolean setka_flag) {
        this.setka_flag = setka_flag;
    }

    public boolean isS() {
        return s;
    }

    public boolean isA() {
        return a;
    }

    public boolean isD() {
        return d;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isRight() {
        return right;
    }

    boolean flag_shoot_first;

    boolean flag_shoot_second;

    public boolean isLeft() {
        return left;
    }

    public Player getPlayer_second() {
        return player_second;
    }

    public Ball getBall() {
        return ball;
    }

    public void restart() throws InterruptedException {
        player_first.setX(675);
        player_first.setY(40);
        player_first.setDx(0);
        player_first.setDy(0);
        player_second.setX(675);
        player_second.setY(780);
        player_second.setDy(0);
        player_second.setDx(0);
        ball.setX(800);
        ball.setY(20);
        ball.setDx(0);
        ball.setDy(0);
        goal_flag = true;
    }

    public MyFrame() throws HeadlessException, IOException {
        boolean flag_right = false;
        this.flag_shoot_first = false;
        this.flag_shoot_second = false;

        int h = 0;
        this.setSize(1440, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Game");
        this.gameStart = false;
        this.button_start_flag = false;
        this.image = ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/Place.png"));
        this.prep1 = ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/prep1.png"));
        this.prep2 = ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/IMG_0737 (1).png"));
        buttons_list.add(new Button(375, 275, 20 * 4, 15 * 4, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/six.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {
                if(!prep_flag){
                    cnt_kletok = 6;
                }
                prep_flag=true;
                buttons_list.get(0).setButton_used(false);
                buttons_list.get(1).setButton_used(false);
                buttons_list.get(2).setButton_used(false);
            }

            @Override
            public void button_restart_onClick() {
            }
            public void button_player_first(){

            }
            public void button_player_second(){
            }
            public void button_speed(){}
            public void button_ball(){}

        }));
        buttons_list.add(new Button(500, 275, 20 * 4, 15 * 4, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/eight.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {
                if(!prep_flag){
                    cnt_kletok = 8;
                }
                prep_flag=true;
                buttons_list.get(0).setButton_used(false);
                buttons_list.get(1).setButton_used(false);
                buttons_list.get(2).setButton_used(false);

            }

            @Override
            public void button_restart_onClick() {
            }
            public void button_player_first(){

            }
            public void button_player_second(){

            }
            public void button_speed(){}
            public void button_ball(){}

        }));
        buttons_list.add(new Button(625, 275, 20 * 4, 15 * 4, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/ten.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {
                if(!prep_flag){
                    cnt_kletok = 10;
                }
                prep_flag=true;
                buttons_list.get(0).setButton_used(false);
                buttons_list.get(1).setButton_used(false);
                buttons_list.get(2).setButton_used(false);


            }

            @Override
            public void button_restart_onClick() {
            }
            public void button_player_first(){

            }
            public void button_player_second(){

            }
            public void button_speed(){}
            public void button_ball(){}

        }));
        buttons_list.add(new Button(575, 40, 35 * 2, 35 * 2, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {
            }

            @Override
            public void button_restart_onClick() throws InterruptedException {

            }
            public void button_player_first(){
                if(!player_first_flag){
                    try {
                        player_first.setPlayer(ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img.png")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                buttons_list.get(4).setButton_used(false);
                buttons_list.get(3).setButton_used(false);
                player_first_flag = true;
            }
            public void button_player_second(){

            }
            public void button_speed(){}
            public void button_ball(){}

        }));

        buttons_list.add(new Button(775, 40, 35 * 2, 35 * 2, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/player_first.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {
            }

            @Override
            public void button_restart_onClick() throws InterruptedException {
            }
            public void button_player_first(){
                if(!player_first_flag){
                    try {
                        player_first.setPlayer(ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/player_first.png")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                buttons_list.get(4).setButton_used(false);
                buttons_list.get(3).setButton_used(false);
                player_first_flag = true;
            }
            public void button_player_second(){

            }
            public void button_speed(){}
            public void button_ball(){}

        }));
        buttons_list.add(new Button(575, 780, 35 * 2, 35 * 2, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img_4.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {
            }

            @Override
            public void button_restart_onClick() throws InterruptedException {
            }
            public void button_player_first(){

            }
            public void button_player_second(){
                if(!player_second_flag){
                    try {
                        player_second.setPlayer(ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img_4.png")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                buttons_list.get(6).setButton_used(false);
                buttons_list.get(5).setButton_used(false);
                player_second_flag = true;
            }
            public void button_speed(){}
            public void button_ball(){}

        }));
        buttons_list.add(new Button(775, 780, 35 * 2, 35 * 2, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/player_second.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {
            }

            @Override
            public void button_restart_onClick() throws InterruptedException {

            }
            public void button_player_first(){

            }
            public void button_player_second(){
                if(!player_second_flag){
                    try {
                        player_second.setPlayer(ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/player_second.png")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                buttons_list.get(6).setButton_used(false);
                buttons_list.get(5).setButton_used(false);
                player_second_flag = true;
            }
            public void button_speed(){}
            public void button_ball(){}

        }));
        buttons_list.add(new Button(50, 100, 35 * 2, 75 * 2, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/button_RST.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {
            }

            @Override
            public void button_restart_onClick() throws InterruptedException {
                restart();
                goal_first = 0;
                goal_second = 0;
            }
            public void button_player_first(){

            }
            public void button_player_second(){

            }
            public void button_speed(){}
            public void button_ball(){}

        }));
        buttons_list.add(new Button(775, 275, 20 * 4, 15 * 4, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/ten.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {

            }

            @Override
            public void button_restart_onClick() {
            }
            public void button_player_first(){

            }
            public void button_player_second(){

            }
            public void button_speed(){
                if(!speed_flag){
                    ball.setSpeed(10);
                }
                speed_flag = true;
                buttons_list.get(8).setButton_used(false);
                buttons_list.get(9).setButton_used(false);
                buttons_list.get(10).setButton_used(false);
            }
            public void button_ball(){}

        }));
        buttons_list.add(new Button(900, 275, 20 * 4, 15 * 4, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/twenty.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {

            }

            @Override
            public void button_restart_onClick() {
            }
            public void button_player_first(){

            }
            public void button_player_second(){

            }
            public void button_speed(){
                if(!speed_flag){
                    ball.setSpeed(20);
                }
                speed_flag = true;
                buttons_list.get(8).setButton_used(false);
                buttons_list.get(9).setButton_used(false);
                buttons_list.get(10).setButton_used(false);
            }
            public void button_ball(){}

        }));
        buttons_list.add(new Button(1025, 275, 20 * 4, 15 * 4, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/forte.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {

            }

            @Override
            public void button_restart_onClick() {
            }
            public void button_player_first(){

            }
            public void button_player_second(){

            }
            public void button_speed(){
                if(!speed_flag){
                    ball.setSpeed(40);
                }
                speed_flag = true;
                buttons_list.get(8).setButton_used(false);
                buttons_list.get(9).setButton_used(false);
                buttons_list.get(10).setButton_used(false);
            }
            public void button_ball(){}

        }));
        buttons_list.add(new Button(575, 575, 10 * 4, 10 * 4, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/shaiba3.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {

            }

            @Override
            public void button_restart_onClick() {
            }
            public void button_player_first(){

            }
            public void button_player_second(){

            }
            public void button_speed(){

            }
            public void button_ball(){
                if(!ball_flag){
                    try {
                        ball.setImage(ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/shaiba3.png")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                ball_flag = true;
                buttons_list.get(11).setButton_used(false);
                buttons_list.get(12).setButton_used(false);

            }

        }));
        buttons_list.add(new Button(775, 575, 10 * 4, 10 * 4, false, true, ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img_2.png")), new ButtonAction() {
            @Override
            public void button_start_onClick() {

            }

            @Override
            public void button_restart_onClick() {
            }
            public void button_player_first(){

            }
            public void button_player_second(){

            }
            public void button_speed(){

            }
            public void button_ball(){
                if(!ball_flag){
                    try {
                        ball.setImage(ImageIO.read(new File("/Users/admin/IdeaProjects/untitled/Project_informatika_10klass_/data/img_2.png")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                ball_flag = true;
                buttons_list.get(11).setButton_used(false);
                buttons_list.get(12).setButton_used(false);

            }

        }));

        player_first = new Player(new Color(255, 100, 100), 675, 40, image_player_first);
        player_second = new Player(new Color(255, 255, 100), 675, 780, image_player_second);
        ball = new Ball(800, 60, 36, new Color(255, 255, 0), 20);
        goal_first = 0;
        goal_second = 0;
        goal_flag = true;
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int j = 0; j < 9; j++) {
                a.add(0);
                a.add(0);
            }
            list_kletka.add(a);
        }
        int kletka = 0;
        int kletka_player_first = 0;
        int kletka_player_second = 0;
        this.speed = 2;
    }

    @Override
    public void paint(Graphics g) {
        BufferStrategy bufferStrategy = getBufferStrategy();        // Обращаемся к стратегии буферизации
        if (bufferStrategy == null) {                               // Если она еще не создана
            createBufferStrategy(2);                                // то создаем ее
            bufferStrategy = getBufferStrategy();                   // и опять обращаемся к уже наверняка созданной стратегии
        }
        g = bufferStrategy.getDrawGraphics();                       // Достаем текущую графику (текущий буфер)
        g.clearRect(0, 0, getWidth(), getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));
        g.drawImage(image, 270, 0, 900, 900, null);

        if (list_kletka.size() > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (list_kletka.get(i).get(2 * j) == 1) {
                        if (list_kletka.get(i).get(2 * j + 1) == 1) {
//                            g.setColor(new Color(248, 50, 7));
//                            g.fillRect(i * 70 + 405, j * 70 + 135, 70, 70);
                            g.drawImage(prep1, i*70+405, j*70+135, 70, 70, null);
                        } else {
//                            g.setColor(new Color(1, 225, 151));
//                            g.fillRect(i * 70 + 405, j * 70 + 135, 70, 70);
                            g.drawImage(prep2, i*70+405, j*70+135, 70, 70,  null);
                        }
                    }
                }
            }
        }
        g.setColor(new Color(0, 0, 0));
        Font f = new Font("Monospaced", Font.ITALIC, 48);
        g.setFont(f);
        Integer goal1 = goal_first;
        Integer goal2 = goal_second;
        g.drawString(goal1.toString(), 1300, 100);
        g.drawString(goal2.toString(), 100, 800);
        if(buttons_list.size()>0){
            for (Button button : buttons_list) {
                if (button != null) {
                    if (button.isButton_used()) {
                        if(button.getY() == 275 && button.getX() == 1025){
                            g.setColor(new Color(0, 0, 0));
                            g.setFont(new Font("Monospaced", Font.ITALIC, 13));
                            g.drawString("Выберите максимальную скорость полета шайбы", 780, 250);
                        }
                        if(button.getY()==275 && button.getX() == 625){
                            g.setColor(new Color(0, 0, 0));
                            g.setFont(new Font("Monospaced", Font.ITALIC, 13));
                            g.drawString("Выберите обшее количество препятствий", 380, 250);
                        }
                        if (button.isFlag()) {
                            button.paint(g, button.getX_end(), button.getY_end(), button.getWidth_end(), button.getHeight_end());
                        } else {
                            button.paint(g, button.getX_start(), button.getY_start(), button.getWidth_start(), button.getHeight_start());
                        }
                    }
                }
            }
        }

        if (buttons_list.size() > 0) {
            if (prep_flag && player_first_flag && player_second_flag && speed_flag && ball_flag) {
                if (setka_flag) {
                    for (int i = 0; i < 10; i++) {
                        g.drawLine(405, 135 + i * 70, 405 + 630, 135 + i * 70);
                    }
                    for (int j = 0; j < 10; j++) {
                        g.drawLine(405 + j * 70, 135, 405 + j * 70, 135 + 630);
                    }
                }
                player_first.paint(g);
                player_second.paint(g);
                ball.paint(g);


            }
        }
        g.dispose();
        bufferStrategy.show();
    }

    public ArrayList<Integer> shoot_ball_with_kletka() {
        double x = ball.getX();
        double y = ball.getY();
        int d = ball.getRadius();
        double x_k1 = x + d / 2;
        double y_k1 = y + d;
        double x_k2 = x;
        double y_k2 = y + d / 2;
        double x_k3 = x + d / 2;
        double y_k3 = y;
        double x_k4 = x + d;
        double y_k4 = y + d / 2;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (list_kletka.get(i).get(2 * j) == 1) {
                    int x_kletka = 405 + 70 * i;
                    int y_kletka = 135 + 70 * j;
                    int q = 10;
                    if ((y_k1 >= y_kletka && y_k1 <= y_kletka + 70) && x_k1 >= x_kletka - q && x_k1 <= x_kletka + 70 + q && ball.getDy() > 0) {
                        kletka = 1;
                        ArrayList<Integer> a = new ArrayList<Integer>();
                        a.add(1);
                        a.add(list_kletka.get(i).get(2 * j + 1));
                        return a;
                    }
                    if (x_k2 >= x_kletka && x_k2 <= x_kletka + 70 && y_k2 >= y_kletka - q && y_k2 <= y_kletka + 70 + q && ball.getDx() < 0) {
                        kletka = 2;
                        ArrayList<Integer> a = new ArrayList<Integer>();
                        a.add(2);
                        a.add(list_kletka.get(i).get(2 * j + 1));
                        return a;
                    }
                    if ((y_k3 >= y_kletka && y_k3 <= y_kletka + 70) && x_k3 >= x_kletka - q && x_k3 <= x_kletka + 70 + q && ball.getDy() < 0) {
                        kletka = 3;
                        ArrayList<Integer> a = new ArrayList<Integer>();
                        a.add(3);
                        a.add(list_kletka.get(i).get(2 * j + 1));
                        return a;
                    }
                    if (x_k4 >= x_kletka && x_k4 <= x_kletka + 70 && y_k4 >= y_kletka - q && y_k4 <= y_kletka + 70 + q && ball.getDx() > 0) {
                        kletka = 4;
                        ArrayList<Integer> a = new ArrayList<Integer>();
                        a.add(4);
                        a.add(list_kletka.get(i).get(2 * j + 1));
                        return a;
                    }
                }
            }
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(0);
        return a;
    }
    public int shoot_player_second_with_kletka() {
        double x = player_second.getX();
        double y = player_second.getY();
        int d = player_second.getRadius();
        double x_k1 = x + d / 2;
        double y_k1 = y + d;
        double x_k2 = x;
        double y_k2 = y + d / 2;
        double x_k3 = x + d / 2;
        double y_k3 = y;
        double x_k4 = x + d;
        double y_k4 = y + d / 2;
        double x_center = x + d / 2;
        double y_center = y + d / 2;


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (list_kletka.get(i).get(2 * j) == 1) {
                    int x_kletka = 405 + 70 * i;
                    int y_kletka = 135 + 70 * j;
                    double len1 = Math.sqrt(pow(Math.abs((x_center - x_kletka)), 2) + pow(Math.abs((y_center - y_kletka)), 2));
                    double len2 = Math.sqrt(pow(Math.abs((x_center - x_kletka-70)), 2) + pow(Math.abs((y_center - y_kletka)), 2));;
                    double len3 = Math.sqrt(pow(Math.abs((x_center - x_kletka-70)), 2) + pow(Math.abs((y_center - y_kletka-70)), 2));;
                    double len4 = Math.sqrt(pow(Math.abs((x_center - x_kletka)), 2) + pow(Math.abs((y_center - y_kletka-70)), 2));;
                    int q = 0;
                    if(len1<=d/2){
                        if(i>=2){
                            if(list_kletka.get(i-2).get(2 * j) == 1){
                                kletka_player_second = 1;
                                return kletka_player_second;
                            }
                        }

                        kletka_player_second = 5;
                        return kletka_player_second;
                    }
                    if(len2<=d/2){
                        if(i<=6){
                            if(list_kletka.get(i+2).get(2 * j) == 1){
                                kletka_player_second = 1;
                                return kletka_player_second;
                            }
                        }
                        kletka_player_second = 6;
                        return kletka_player_second;
                    }if(len3<=d/2){
                        if(j<=6){
                            if(list_kletka.get(i).get(2 * (j+2)) == 1){
                                kletka_player_second = 2;
                                return kletka_player_second;
                            }
                        }if(i<=6){
                            if(list_kletka.get((i+2)).get(2 * j) == 1){
                                kletka_player_second = 3;
                                return kletka_player_second;
                            }
                        }
                        kletka_player_second = 7;
                        return kletka_player_second;
                    }if(len4<=d/2){
                        if(j<=6){
                            if(list_kletka.get(i).get(2 * (j+2)) == 1){
                                kletka_player_second = 4;
                                return kletka_player_second;
                            }
                        }
                        kletka_player_second = 8;
                        return kletka_player_second;
                    }
                    if ((y_k1 >= y_kletka && y_k1 <= y_kletka + 70) && x_k1 >= x_kletka - q && x_k1 <= x_kletka + 70 + q) {
                        kletka_player_second = 1;
                        return kletka_player_second;
                    }
                    if (x_k2 >= x_kletka && x_k2 <= x_kletka + 70 && y_k2 >= y_kletka - q && y_k2 <= y_kletka + 70 + q) {
                        kletka_player_second = 2;
                        return kletka_player_second;
                    }
                    if ((y_k3 >= y_kletka && y_k3 <= y_kletka + 70) && x_k3 >= x_kletka - q && x_k3 <= x_kletka + 70 + q) {
                        kletka_player_second = 3;
                        return kletka_player_second;
                    }
                    if (x_k4 >= x_kletka && x_k4 <= x_kletka + 70 && y_k4 >= y_kletka - q && y_k4 <= y_kletka + 70 + q) {
                        kletka_player_second = 4;
                        return kletka_player_second;
                    }

                    kletka_player_second = 0;
                }
            }
        }
        return kletka_player_second;
    }
    public int shoot_player_first_with_kletka() {
        double x = player_first.getX();
        double y = player_first.getY();
        int d = player_first.getRadius();
        double x_k1 = x + d / 2;
        double y_k1 = y + d;
        double x_k2 = x;
        double y_k2 = y + d / 2;
        double x_k3 = x + d / 2;
        double y_k3 = y;
        double x_k4 = x + d;
        double y_k4 = y + d / 2;
        double x_center = x + d / 2;
        double y_center = y + d / 2;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (list_kletka.get(i).get(2 * j) == 1) {
                    int x_kletka = 405 + 70 * i;
                    int y_kletka = 135 + 70 * j;
                    double len1 = Math.sqrt(pow(Math.abs((x_center - x_kletka)), 2) + pow(Math.abs((y_center - y_kletka)), 2));
                    double len2 = Math.sqrt(pow(Math.abs((x_center - x_kletka-70)), 2) + pow(Math.abs((y_center - y_kletka)), 2));;
                    double len3 = Math.sqrt(pow(Math.abs((x_center - x_kletka-70)), 2) + pow(Math.abs((y_center - y_kletka-70)), 2));;
                    double len4 = Math.sqrt(pow(Math.abs((x_center - x_kletka)), 2) + pow(Math.abs((y_center - y_kletka-70)), 2));;
                    int q = 0;
                    if(len1<=d/2){
                        if(i>=2){
                            if(list_kletka.get(i-2).get(2 * j) == 1){
                                kletka_player_first = 1;
                                return kletka_player_first;
                            }
                        }

                        kletka_player_first = 5;
                        return kletka_player_first;
                    }
                    if(len2<=d/2){
                        if(i<=6){
                            if(list_kletka.get(i+2).get(2 * j) == 1){
                                kletka_player_first = 1;
                                return kletka_player_first;
                            }
                        }
                        kletka_player_first = 6;
                        return kletka_player_first;
                    }if(len3<=d/2){
                        if(j<=6){
                            if(list_kletka.get(i).get(2 * (j+2)) == 1){
                                kletka_player_first = 2;
                                return kletka_player_first;
                            }
                        }if(i<=6){
                            if(list_kletka.get((i+2)).get(2 * j) == 1){
                                kletka_player_first = 3;
                                return kletka_player_first;
                            }
                        }
                        kletka_player_first = 7;
                        return kletka_player_first;
                    }if(len4<=d/2){
                        if(j<=6){
                            if(list_kletka.get(i).get(2 * (j+2)) == 1){
                                kletka_player_first = 4;
                                return kletka_player_first;
                            }
                        }
                        kletka_player_first = 8;
                        return kletka_player_first;
                    }
                    if ((y_k1 >= y_kletka && y_k1 <= y_kletka + 70) && x_k1 >= x_kletka - q && x_k1 <= x_kletka + 70 + q) {
                        kletka_player_first = 1;
                        return kletka_player_first;
                    }
                    if (x_k2 >= x_kletka && x_k2 <= x_kletka + 70 && y_k2 >= y_kletka - q && y_k2 <= y_kletka + 70 + q) {
                        kletka_player_first = 2;
                        return kletka_player_first;
                    }
                    if ((y_k3 >= y_kletka && y_k3 <= y_kletka + 70) && x_k3 >= x_kletka - q && x_k3 <= x_kletka + 70 + q) {
                        kletka_player_first = 3;
                        return kletka_player_first;
                    }
                    if (x_k4 >= x_kletka && x_k4 <= x_kletka + 70 && y_k4 >= y_kletka - q && y_k4 <= y_kletka + 70 + q) {
                        kletka_player_first = 4;
                        return kletka_player_first;
                    }

                    kletka_player_first = 0;
                }
            }
        }
        return kletka_player_first;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        int x = e.getX(), y = e.getY();
        Button button = buttons_list.get(0);
        Button button1 = buttons_list.get(1);
        if (x >= button.getX_start() && x <= button.getX_start() + button.getWidth_start() && y >= button.getY_start() && y <= (button.getY_start() + button.getHeight_start()) && button.isButton_used()) {
            button.onMouseHit(x, y);
            return;
        }
        if (x <= 405 + 630 && x >= 405 && y >= 135 && y <= 135 + 630 && prep_flag && player_first_flag && player_second_flag && speed_flag && ball_flag && cnt < cnt_kletok) {

            if (cnt == cnt_kletok-1) {
                setka_flag = false;
            }
            int i = (y - 135) / 70;
            int j = (x - 405) / 70;
            if (list_kletka.get(j).get(2 * i) == 0) {
                list_kletka.get(j).set(2 * i, 1);
                list_kletka.get(j).set(2 * i + 1, cnt % 2 + 1);
                cnt += 1;
            }

        }
        for(int i = 0; i<buttons_list.size(); i++){
            if(i>=0 && i<=2){
                if(x>=375 && x<=375+15*4 && y>=275 && y<=275+20*4){

                    buttons_list.get(0).onMouseHit(x, y);
                }
                if(x>=500 && x<=500+15*4 && y>=275 && y<=275+20*4){

                    buttons_list.get(1).onMouseHit(x, y);
                }
                if(x>=625 && x<=625+15*4 && y>=275 && y<=275+20*4){

                    buttons_list.get(2).onMouseHit(x, y);
                }
            }
            if(i>=8 && i<=10){
                if(x>=775 && x<=775+15*4 && y>=275 && y<=275+20*4){
                    buttons_list.get(8).onMouseHit5(x, y);
                }
                if(x>=900 && x<=900+15*4 && y>=275 && y<=275+20*4){
                    buttons_list.get(9).onMouseHit5(x, y);
                }
                if(x>=1025 && x<=1025+15*4 && y>=275 && y<=275+20*4){
                    buttons_list.get(10).onMouseHit5(x, y);
                }
            }
            if(i>=3 && i<=4){
                if(x>=575 && x<=575+70 && y>=40 && y<=110){
                    buttons_list.get(3).onMouseHit3(x, y);
                }
                if(x>=775 && x<=775+70 && y>=40 && y<=110){
                    buttons_list.get(4).onMouseHit3(x, y);
                }
            }
            if(i>=5 && i<=6){
                if(x>=575 && x<=575+70 && y>=780 && y<=850){
                    buttons_list.get(5).onMouseHit4(x, y);
                }
                if(x>=775 && x<=775+70 && y>=780 && y<=850){
                    buttons_list.get(6).onMouseHit4(x, y);
                }
            }
            if(i>=11 && i<=12){
                if(x>=575 && x<=575+10*4 && y>=575 && y<=575+4*10){
                    buttons_list.get(11).onMouseHit6(x, y);
                }
                if(x>=775 && x<= 775+4*10 && y>=575 && y <= 575 + 4 * 10){
                    buttons_list.get(12).onMouseHit6(x, y);
                }
            }
        }
        if (x >= button1.getX_start() && x <= button1.getX_start() + button1.getWidth_start() && y >= button1.getY_start() && y <= (button1.getY_start() + button1.getHeight_start())) {
            try {
                button1.onMouseHit2(x, y);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX(), y = e.getY();
        for (Button button : buttons_list) {
            if (x >= button.getX_start() && x <= button.getX_start() + button.getWidth_start() && y >= button.getY_start() && y <= (button.getY_start() + button.getHeight_start())) {
                button.setFlag(true);
            } else {
                button.setFlag(false);
            }
        }

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (!buttons_list.get(0).isButton_used()) {
            if (e.getKeyCode() == KeyEvent.VK_UP && e.getID() == KeyEvent.KEY_PRESSED) {
                up = true;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && e.getID() == KeyEvent.KEY_PRESSED) {
                down = true;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && e.getID() == KeyEvent.KEY_PRESSED) {
                left = true;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && e.getID() == KeyEvent.KEY_PRESSED) {
                right = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP && e.getID() == KeyEvent.KEY_RELEASED) {
                up = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && e.getID() == KeyEvent.KEY_RELEASED) {
                down = false;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && e.getID() == KeyEvent.KEY_RELEASED) {
                left = false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && e.getID() == KeyEvent.KEY_RELEASED) {
                right = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_W && e.getID() == KeyEvent.KEY_PRESSED) {
                w = true;
            } else if (e.getKeyCode() == KeyEvent.VK_S && e.getID() == KeyEvent.KEY_PRESSED) {
                s = true;
            } else if (e.getKeyCode() == KeyEvent.VK_A && e.getID() == KeyEvent.KEY_PRESSED) {
                a = true;
            } else if (e.getKeyCode() == KeyEvent.VK_D && e.getID() == KeyEvent.KEY_PRESSED) {
                d = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_W && e.getID() == KeyEvent.KEY_RELEASED) {
                w = false;
            } else if (e.getKeyCode() == KeyEvent.VK_S && e.getID() == KeyEvent.KEY_RELEASED) {
                s = false;
            } else if (e.getKeyCode() == KeyEvent.VK_A && e.getID() == KeyEvent.KEY_RELEASED) {
                a = false;
            } else if (e.getKeyCode() == KeyEvent.VK_D && e.getID() == KeyEvent.KEY_RELEASED) {
                d = false;
            }
        }


        return false;
    }

    public boolean shoot() {
        int x1 = player_first.getX();
        int y1 = player_first.getY();
        int x2 = player_second.getX();
        int y2 = player_second.getY();
        double len = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        if (len<=player_first.getRadius()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_first_with_wool_right() {
        int x1 = 837;
        int y1 = 25;
        double x = player_first.getX();
        double y = player_first.getY();
        double len = Math.sqrt(pow(Math.abs(x+player_first.getRadius()/2-x1), 2) + pow(Math.abs(y+player_first.getRadius()/2-y1), 2));
        if(len<=player_first.getRadius()/2){
            return true;
        }
        if (x + player_first.getRadius() >= 1135 || (y+player_first.getRadius()/2<=30 && x + player_first.getRadius() >= 837)) {
            flag_right = true;
            return true;
        } else {
            flag_right = false;
            return false;
        }
    }

    public boolean shoot_first_with_wool_left() {
        int x = player_first.getX();
        int y = player_first.getY();
        int x1 = 603;
        int y1 = 25;
        double len = Math.sqrt(pow(Math.abs(x+player_first.getRadius()/2-x1), 2) + pow(Math.abs(y+player_first.getRadius()/2-y1), 2));
        if(len<=player_first.getRadius()/2){
            return true;
        }
        if (x <= 300 || (y+player_first.getRadius()/2<=30 && x<=603)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_first_with_wool_up() {
        double x = player_first.getX();
        double y = player_first.getY();
        if(y<=0){
            return true;
        }
        if(y<30 && x>=630-player_first.getRadius()/2 && x+player_first.getRadius()<=837+player_first.getRadius()/2){
            return false;
        }

        if (y <= 30) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_first_with_wool_down() {
        int x1 = player_first.getX();
        int y1 = player_first.getY();
        if (y1 + player_first.getRadius() >= 470) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_second_with_wool_right() {
        int x2 = player_second.getX();
        int y2 = player_second.getY();
        if (x2 + player_second.getRadius() >= 1140) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_second_with_wool_left() {
        int x2 = player_second.getX();
        int y2 = player_second.getY();
        if (x2 <= 300) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_second_with_wool_up() {
        int x2 = player_second.getX();
        int y2 = player_second.getY();
        if (y2 <= 435) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_second_with_wool_down() {
        int x2 = player_second.getX();
        int y2 = player_second.getY();
        if (y2 + player_second.getRadius() >= 870) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_ball_with_wool_right() {
        int x1 = 837;
        int y1 = 25;
        double x_ball = ball.getX();
        double y_ball = ball.getY();
        double len = Math.sqrt(pow(Math.abs(x_ball+ball.getRadius()/2-x1), 2) + pow(Math.abs(y_ball+ball.getRadius()/2-y1), 2));
        if(len<=ball.getRadius()/2){
            return true;
        }
        if (x_ball + ball.getRadius() >= 1135 || (y_ball+ball.getRadius()/2<=30 && x_ball + ball.getRadius() >= 837)) {
            flag_right = true;
            return true;
        } else {
            flag_right = false;
            return false;
        }
    }

    public boolean shoot_ball_with_wool_left() {
        double x_ball = ball.getX();
        double y_ball = ball.getY();
        int x1 = 603;
        int y1 = 25;
        double len = Math.sqrt(pow(Math.abs(x_ball+ball.getRadius()/2-x1), 2) + pow(Math.abs(y_ball+ball.getRadius()/2-y1), 2));
        if(len<=ball.getRadius()/2){
            return true;
        }
        if (x_ball <= 300 || (y_ball+ball.getRadius()/2<=25 && x_ball <= 603)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_ball_with_wool_up() {
        double x_ball = ball.getX();
        double y_ball = ball.getY();
        if(y_ball<30 && x_ball>=630-ball.getRadius()/2 && x_ball+ball.getRadius()<=837+ball.getRadius()/2){
            return false;
        }
        if (y_ball > 30) {
            return false;
        } else {
            if (x_ball >= 590 && x_ball + ball.getRadius() <= 845 && y_ball <= 30 && goal_flag) {
                goal_flag = false;
                goal_second += 1;
                return false;
            }
            return true;
        }
    }

    public boolean shoot_ball_with_wool_down() {
        double x_ball = ball.getX();
        double y_ball = ball.getY();
        if (y_ball + ball.getRadius() < 870) {
            return false;
        } else {
            if (x_ball >= 600 && x_ball + ball.getRadius() <= 835 && y_ball + ball.getRadius() >= 870 && goal_flag) {
                goal_flag = false;
                goal_first += 1;
                return false;
            }
            return true;
        }

    }


    public void setGoal_flag(boolean goal_flag) {
        this.goal_flag = goal_flag;
    }

    public boolean check_goal() {
        double y_ball = ball.getY();
        double x_ball = ball.getX();
        if (x_ball >= 603 && x_ball + ball.getRadius() <= 837 && (y_ball <= 0 || y_ball + ball.getRadius() >= 870)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shoot_first_with_ball() {
        double x1 = player_first.getX() + player_first.getRadius() / 2;
        double y1 = player_first.getY() + player_first.getRadius() / 2;
        double x_ball = ball.getX() + ball.getRadius() / 2;
        double y_ball = ball.getY() + ball.getRadius() / 2;
        double len = Math.sqrt((x1 - x_ball) * (x1 - x_ball) + (y1 - y_ball) * (y1 - y_ball));
        if (len > (player_first.getRadius() / 2 + ball.getRadius() / 2)) {
            flag_shoot_first = false;
            return false;
        }
        else if ((len <= (player_first.getRadius() / 2 + ball.getRadius() / 2)) && (!flag_shoot_first)) {
            flag_shoot_first = true;
            return true;
        }
        else{
            return false;
        }
    }
    public void setFlag_shoot_first(boolean flag){
        this.flag_shoot_first = flag;
    }
    public boolean shoot_second_with_ball() {
        int x2 = player_second.getX() + player_second.getRadius() / 2;
        int y2 = player_second.getY() + player_second.getRadius() / 2;
        double x_ball = ball.getX() + ball.getRadius() / 2;
        double y_ball = ball.getY() + ball.getRadius() / 2;

        double len = Math.sqrt((x2 - x_ball) * (x2 - x_ball) + (y2 - y_ball) * (y2 - y_ball));
        if (len > (player_first.getRadius() / 2 + ball.getRadius() / 2)) {
            flag_shoot_second = false;
        }
        if ((len <= (player_first.getRadius() / 2 + ball.getRadius() / 2)) && (!flag_shoot_second)) {
            flag_shoot_second = true;
            return true;
        } else {

            return false;
        }
    }

    public void shoot1() {
        int u = 8;
        if (ball.getX() + ball.getRadius() >= 1100) {
            if (ball.getY() >= player_first.getY()) {
                ball.setY(ball.getY() + u);
                ball.setDx(-10);
            } else {
                ball.setY(ball.getY() - u);
                ball.setDx(-10);
            }
        }
        if (ball.getX() <= 340) {
            if (ball.getY() >= player_first.getY()) {
                ball.setY(ball.getY() + u);
                ball.setDx(10);
            } else {
                ball.setY(ball.getY() - u);
                ball.setDx(10);
            }
        }
        if (ball.getY() + ball.getRadius() >= 840) {
            if (ball.getX() >= player_first.getX()) {
                ball.setX(ball.getX() + u);
                ball.setDy(-10);
            } else {
                ball.setX(ball.getX() - u);
                ball.setDy(-10);
            }
        }
        if (ball.getX() <= 60) {
            if (ball.getX() >= player_first.getX()) {
                ball.setX(ball.getX() + u);
                ball.setDx(10);
            } else {
                ball.setX(ball.getX() - u);
                ball.setDx(10);
            }
        }
    }

    public void shoot2() {
        int u = 8;
        if (ball.getX() + ball.getRadius() >= 1100) {
            if (ball.getY() >= player_second.getY()) {
                ball.setY(ball.getY() + u);
                ball.setDx(-10);
            } else {
                ball.setY(ball.getY() - u);
                ball.setDx(-10);
            }
        }
        if (ball.getX() <= 340) {
            if (ball.getY() >= player_second.getY()) {
                ball.setY(ball.getY() + u);
                ball.setDx(10);
            } else {
                ball.setY(ball.getY() - u);
                ball.setDx(10);
            }
        }
        if (ball.getY() + ball.getRadius() >= 840) {
            if (ball.getX() >= player_second.getX()) {
                ball.setX(ball.getX() + u);
                ball.setDy(-10);
            } else {
                ball.setX(ball.getX() - u);
                ball.setDy(-10);
            }
        }
        if (ball.getX() <= 60) {
            if (ball.getX() >= player_second.getX()) {
                ball.setX(ball.getX() + u);
                ball.setDx(10);
            } else {
                ball.setX(ball.getX() - u);
                ball.setDx(10);
            }
        }
    }

    public double pow(double a, int b) {
        if (b == 1) {
            return a;
        }
        if (b % 2 == 0) {
            return pow(a * a, b / 2);
        } else {
            return a * pow(a, b - 1);
        }
    }
}
