import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.NoninvertibleTransformException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MyFrame frame = new MyFrame();
        frame.addMouseListener(frame);
        frame.addMouseMotionListener(frame);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(frame);
        int speed = 3;
        int speed_ball = 3;
        while (true) {
            Thread.sleep(5);
            frame.repaint();
            if (frame.shoot()) {
                if (frame.getPlayer_first().getY() < frame.getPlayer_second().getY()) {
                    frame.getPlayer_first().setY(frame.getPlayer_first().getY() - speed);
                    frame.getPlayer_second().setY(frame.getPlayer_second().getY() + speed);
                } else {
                    frame.getPlayer_first().setY(frame.getPlayer_first().getY() + speed);
                    frame.getPlayer_second().setY(frame.getPlayer_second().getY() - speed);
                }
                if (frame.getPlayer_first().getX() < frame.getPlayer_second().getX()) {
                    frame.getPlayer_first().setX(frame.getPlayer_first().getX() - speed);
                    frame.getPlayer_second().setX(frame.getPlayer_second().getX() + speed);
                } else {
                    frame.getPlayer_first().setX(frame.getPlayer_first().getX() + speed);
                    frame.getPlayer_second().setX(frame.getPlayer_second().getX() - speed);
                }
            } else {
                frame.getPlayer_first().update(frame.isUp(), frame.isDown(), frame.isLeft(), frame.isRight());
                frame.getPlayer_second().update(frame.isW(), frame.isS(), frame.isA(), frame.isD());
            }
            if (frame.shoot_first_with_wool_right()) {
                frame.getPlayer_first().setX(frame.getPlayer_first().getX() - speed);
            }
            if (frame.shoot_first_with_wool_left()) {
                frame.getPlayer_first().setX(frame.getPlayer_first().getX() + speed);
            }
            if (frame.shoot_first_with_wool_up()) {
                frame.getPlayer_first().setY(frame.getPlayer_first().getY() + speed);
            }
            if (frame.shoot_first_with_wool_down()) {
                frame.getPlayer_first().setY(frame.getPlayer_first().getY() - speed);
            }
            if (frame.shoot_second_with_wool_right()) {
                frame.getPlayer_second().setX(frame.getPlayer_second().getX() - speed);
            }
            if (frame.shoot_second_with_wool_left()) {
                frame.getPlayer_second().setX(frame.getPlayer_second().getX() + speed);
            }
            if (frame.shoot_second_with_wool_up()) {
                frame.getPlayer_second().setY(frame.getPlayer_second().getY() + speed);
            }
            if (frame.shoot_second_with_wool_down()) {
                frame.getPlayer_second().setY(frame.getPlayer_second().getY() - speed);
            }
            if (frame.shoot_ball_with_wool_down()) {
                frame.getBall().setDy(-Math.abs(frame.getBall().getDy()));
            }
            if (frame.shoot_ball_with_wool_up()) {
                frame.getBall().setDy(Math.abs(frame.getBall().getDy()));
            }
            if (frame.shoot_ball_with_wool_left()) {
                frame.getBall().setDx(Math.abs(frame.getBall().getDx()));
            }
            if (frame.shoot_ball_with_wool_right() && !frame.shoot_first_with_ball()) {
                frame.getBall().setDx(-Math.abs(frame.getBall().getDx()));
            }
            if (frame.check_goal()) {
                frame.restart();
            }
            if(frame.shoot_first_with_ball() && frame.shoot_second_with_ball()){
                int x1 = frame.getPlayer_first().getX() + frame.getPlayer_first().getRadius() / 2;
                int y1 = frame.getPlayer_first().getY() + frame.getPlayer_first().getRadius() / 2;
                int x2 = frame.getPlayer_second().getX() + frame.getPlayer_second().getRadius() / 2;
                int y2 = frame.getPlayer_second().getY() + frame.getPlayer_second().getRadius() / 2;
                double x_ball = frame.getBall().getX() + frame.getBall().getRadius() / 2;
                double y_ball = frame.getBall().getY() + frame.getBall().getRadius() / 2;
                int Vy1 = frame.getPlayer_first().getDy();
                int Vx1 = frame.getPlayer_first().getDx();
                int Vy2 = frame.getPlayer_second().getDy();
                int Vx2 = frame.getPlayer_second().getDx();
                int radius1 = frame.getPlayer_first().getRadius()/2;
                double radius_ball = frame.getBall().getDx()/2;
                double kof =radius1/(radius1+radius_ball);
                if(Vy1*Vy2<=0 && Vx1 == Vx2 && Vx2==0){
                    if(Math.abs(x1-x2)<10){
                        if(x_ball<x1){
                            frame.getBall().setX(frame.getBall().getX()-10);
                        }else{
                            frame.getBall().setX(frame.getBall().getX()+10);
                        }
                    }
                    else if(x1<x2){
                        if(x_ball<x1){
                            frame.getBall().setX(frame.getBall().getX()-10);
                        }else if(x_ball>x2){
                            frame.getBall().setX(frame.getBall().getX()+10);
                        }else{
                            if(x_ball<(x1+x2)/2){
                                frame.getBall().setX(frame.getBall().getX()-10);
                            }else{
                                frame.getBall().setX(frame.getBall().getX()+10);
                            }
                        }
                    }else{
                        if(x_ball<x2){
                            frame.getBall().setX(frame.getBall().getX()-10);
                        }else if(x_ball>x1){
                            frame.getBall().setX(frame.getBall().getX()+10);
                        }else{
                            if(x_ball<(x1+x2)/2){
                                frame.getBall().setX(frame.getBall().getX()-10);
                            }else{
                                frame.getBall().setX(frame.getBall().getX()+10);
                            }
                        }
                    }
                }
                if(Vx2*Vx1<=0 && Vy1==Vy2 && Vy1==0){
                    if(Math.abs(y1-y2)<10){
                        if(y_ball>y1){
                            frame.getBall().setY(frame.getBall().getY()+10);
                        }else{
                            frame.getBall().setY(frame.getBall().getY()-10);
                        }
                    }else{
                        if(y_ball<(y2+y1)/2){
                            frame.getBall().setY(frame.getBall().getY()-10);
                        }else if(y_ball>=(y2+y1)/2){
                            frame.getBall().setY(frame.getBall().getY()+10);
                        }
                    }
                }
                if(x_ball<x1 && y_ball<y1){
                    double xC = x1 - kof*(x1-x_ball);
                    double yC = y1 - kof * (y1-y_ball);
                    double cos_a = Math.abs(y1-yC)/radius1;
                    double sin_a = Math.abs(x1-xC)/radius1;
                    double tan_a = sin_a/cos_a;
                    double x2_ = x1 - (y1 - y2)*tan_a;
                    if(x2_<x2){
                        frame.getBall().setX(frame.getBall().getX()-10*cos_a);
                        frame.getBall().setY(frame.getBall().getY()+10*sin_a);
                    }else{
                        frame.getBall().setX(frame.getBall().getX()+10*cos_a);
                        frame.getBall().setY(frame.getBall().getY()-10*sin_a);
                    }
                }
                else if(x_ball>x1 && y_ball<y1){
                    double xC = x1 + kof*Math.abs(x1-x_ball);
                    double yC = y1 - kof * Math.abs(y1-y_ball);
                    double cos_a = Math.abs(y1-yC)/radius1;
                    double sin_a = Math.abs(x1-xC)/radius1;
                    double tan_a = sin_a/cos_a;
                    double x2_ = x1 + (y1 - y2)*tan_a;
                    if(x2_<x2){
                        frame.getBall().setX(frame.getBall().getX()-10*cos_a);
                        frame.getBall().setY(frame.getBall().getY()-10*sin_a);
                    }else{
                        frame.getBall().setX(frame.getBall().getX()+10*cos_a);
                        frame.getBall().setY(frame.getBall().getY()+10*sin_a);
                    }
                }
                else if(x_ball<x1 && y_ball>y1){
                    double xC = x1 - kof*(x1-x_ball);
                    double yC = y1 + kof * (y1-y_ball);
                    double cos_a = Math.abs(y1-yC)/radius1;
                    double sin_a = Math.abs(x1-xC)/radius1;
                    double tan_a = sin_a/cos_a;
                    double x2_ = x1 - (y2 - y1)*tan_a;
                    if(x2_<x2){
                        frame.getBall().setX(frame.getBall().getX()-10*cos_a);
                        frame.getBall().setY(frame.getBall().getY()-10*sin_a);
                    }else{
                        frame.getBall().setX(frame.getBall().getX()+10*cos_a);
                        frame.getBall().setY(frame.getBall().getY()+10*sin_a);
                    }
                }else{
                    double xC = x1 + kof*(x1-x_ball);
                    double yC = y1 + kof * (y1-y_ball);
                    double cos_a = Math.abs(y1-yC)/radius1;
                    double sin_a = Math.abs(x1-xC)/radius1;
                    double tan_a = sin_a/cos_a;
                    double x2_ = x1 + (y2 - y1)*tan_a;
                    if(x2_<x2){
                        frame.getBall().setX(frame.getBall().getX()-10*cos_a);
                        frame.getBall().setY(frame.getBall().getY()+10*sin_a);
                    }else{
                        frame.getBall().setX(frame.getBall().getX()+10*cos_a);
                        frame.getBall().setY(frame.getBall().getY()-10*sin_a);
                    }
                }
            }
            else{
                frame.setFlag_shoot_first(false);
                boolean flag = frame.shoot_first_with_ball();
                if (flag) {
                    frame.getBall().setPlayer_shoot(1);
                    frame.shoot1();
                    double x1 = frame.getPlayer_first().getX() + frame.getPlayer_first().getRadius() / 2;
                    double x2 = frame.getBall().getX() + frame.getBall().getRadius() / 2;
                    double y1 = frame.getPlayer_first().getY() + frame.getPlayer_first().getRadius() / 2;
                    double y2 = frame.getBall().getY() + frame.getBall().getRadius() / 2;
                    double tg_shoot_x = 0;
                    double tg_shoot_y = 0;
                    try {
                        tg_shoot_x = Math.abs(((y2 - y1)) / (x2 - x1));
                    } catch (Exception e) {
                        tg_shoot_x = 0;
                    }
                    try {
                        tg_shoot_y = Math.abs((x2 - x1) / (y2 - y1));
                    } catch (Exception e) {
                        tg_shoot_y = 0;
                    }
                    if (Math.abs(frame.getBall().getDx()) <= 0.5 && Math.abs(frame.getBall().getDy()) <= 0.5) {
                        frame.shoot1();
                        if (frame.getPlayer_first().getDx() != 0 && frame.getPlayer_first().getDy() != 0) {
                            double V = 3 * Math.sqrt(2);
                            double dxb = Math.sqrt(9 * V * V / (1 + tg_shoot_y * tg_shoot_y));
                            double dyb = Math.sqrt(Math.abs(V * V - dxb * dxb));
                            if (x1 - x2 < 0 && y1 - y2 < 0) {
                                frame.getBall().setDx(dxb);
                                frame.getBall().setDy(dyb);
                            }
                            if (x1 - x2 < 0 && y1 - y2 > 0) {
                                frame.getBall().setDx(dxb);
                                frame.getBall().setDy(-dyb);
                            }
                            if (x1 - x2 > 0 && y1 - y2 < 0) {
                                frame.getBall().setDx(-dxb);
                                frame.getBall().setDy(dyb);
                            }
                            if (x1 - x2 > 0 && y1 - y2 > 0) {
                                frame.getBall().setDx(-dxb);
                                frame.getBall().setDy(-dyb);
                            }
                        } else {
                            frame.shoot1();
                            if (frame.getPlayer_first().getDx() != 0) {
                                if (y1 - y2 < 0 && frame.getPlayer_first().getDx() < 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(-frame.getPlayer_first().getDx() * tg_shoot_x / 3);
                                    }
                                }
                                if (y1 - y2 < 0 && frame.getPlayer_first().getDx() > 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(frame.getPlayer_first().getDx() * tg_shoot_x / 3);
                                    }
                                }
                                if (y1 - y2 > 0 && frame.getPlayer_first().getDx() < 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(frame.getPlayer_first().getDx() * tg_shoot_x / 3);
                                    }
                                }
                                if (y1 - y2 > 0 && frame.getPlayer_first().getDx() > 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(-frame.getPlayer_first().getDx() * tg_shoot_x / 3);
                                    }
                                }
                            } else {
                                frame.getBall().setDy(frame.getPlayer_first().getDy() * speed_ball);
                            }
                            if (frame.getPlayer_first().getDy() != 0) {
                                if (x1 - x2 > 0 && frame.getPlayer_first().getDy() > 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(-frame.getPlayer_first().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 > 0 && frame.getPlayer_first().getDy() < 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(frame.getPlayer_first().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 < 0 && frame.getPlayer_first().getDy() > 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(frame.getPlayer_first().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 < 0 && frame.getPlayer_first().getDy() < 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(-frame.getPlayer_first().getDy() * tg_shoot_y / 4);
                                    }
                                }
                            } else {
                                frame.getBall().setDx(frame.getPlayer_first().getDx() * speed_ball);
                            }
                        }
                    } else {
                        frame.shoot1();
                        if (frame.getPlayer_first().getDx() == 0 && frame.getPlayer_first().getDy() == 0) {
                            double dby = Math.sqrt(frame.pow(frame.getBall().getDx(), 2) / (1 + frame.pow(tg_shoot_x, 2)));
                            double dbx = (Math.sqrt(Math.abs(frame.pow(frame.getBall().getDx(), 2) - frame.pow(dby, 2))));
                            double a = 1.5;
                            if (dbx < a || dby < a) {
                                if (dbx < a) {
                                    if (frame.getBall().getDx() < 0.5 && frame.getBall().getDx() >= 0) {
                                        frame.getBall().setDx(frame.getBall().getDx() + 0.5);
                                    } else if (frame.getBall().getDx() > -0.5 && frame.getBall().getDx() < 0) {
                                        frame.getBall().setDx(frame.getBall().getDx() - 0.5);
                                    } else {
                                        frame.getBall().setDx(-frame.getBall().getDx());
                                    }
                                } else {
                                    frame.getBall().setDx(((frame.getBall().getDx()) / (Math.abs(frame.getBall().getDx()))) * dbx / 1.3);
                                }
                                if (dby < a) {
                                    if (frame.getBall().getDy() < 0.5 && frame.getBall().getDy() >= 0) {
                                        frame.getBall().setDy(-frame.getBall().getDy() - 0.5);
                                    } else if (frame.getBall().getDy() > -0.5 && frame.getBall().getDy() < 0) {
                                        frame.getBall().setDy(-frame.getBall().getDy() + 0.5);
                                    } else {
                                        frame.getBall().setDy(-frame.getBall().getDy());
                                    }
                                } else {
                                    frame.getBall().setDy(((frame.getBall().getDy()) / (Math.abs(frame.getBall().getDy()))) * dby / 1.3);
                                }
                            } else {
                                frame.getBall().setDx(((frame.getBall().getDx()) / (Math.abs(frame.getBall().getDx()))) * dbx / 1.3);
                                frame.getBall().setDy(((frame.getBall().getDy()) / (Math.abs(frame.getBall().getDy()))) * dby / 1.3);
                            }
                        } else {
                            if (frame.getPlayer_first().getDx() != 0) {
                                if (y1 - y2 < 0 && frame.getPlayer_first().getDx() < 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(-frame.getPlayer_first().getDx() * tg_shoot_x / 4);
                                    }
                                }
                                if (y1 - y2 < 0 && frame.getPlayer_first().getDx() > 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(frame.getPlayer_first().getDx() * tg_shoot_x / 4);
                                    }
                                }
                                if (y1 - y2 > 0 && frame.getPlayer_first().getDx() < 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(frame.getPlayer_first().getDx() * tg_shoot_x / 4);
                                    }
                                }
                                if (y1 - y2 > 0 && frame.getPlayer_first().getDx() > 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(-frame.getPlayer_first().getDx() * tg_shoot_x / 4);
                                    }
                                }
                            } else {
                                frame.getBall().setDy(frame.getPlayer_first().getDy() * speed_ball);
                            }
                            if (frame.getPlayer_first().getDy() != 0) {
                                if (x1 - x2 > 0 && frame.getPlayer_first().getDy() > 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(-frame.getPlayer_first().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 > 0 && frame.getPlayer_first().getDy() < 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(frame.getPlayer_first().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 < 0 && frame.getPlayer_first().getDy() > 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(frame.getPlayer_first().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 < 0 && frame.getPlayer_first().getDy() < 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(-frame.getPlayer_first().getDy() * tg_shoot_y / 4);
                                    }
                                }
                            } else {
                                frame.getBall().setDx(frame.getPlayer_first().getDx() * speed_ball);
                            }
                        }
                    }
                }
                if (frame.shoot_second_with_ball()) {
                    frame.getBall().setPlayer_shoot(2);
                    frame.shoot2();
                    double x1 = frame.getPlayer_second().getX() + frame.getPlayer_second().getRadius() / 2;
                    double x2 = frame.getBall().getX() + frame.getBall().getRadius() / 2;
                    double y1 = frame.getPlayer_second().getY() + frame.getPlayer_second().getRadius() / 2;
                    double y2 = frame.getBall().getY() + frame.getBall().getRadius() / 2;
                    double tg_shoot_x = 0;
                    double tg_shoot_y = 0;
                    try {
                        tg_shoot_x = Math.abs(((y2 - y1)) / (x2 - x1));
                    } catch (Exception e) {
                        tg_shoot_x = 0;
                    }
                    try {
                        tg_shoot_y = Math.abs((x2 - x1) / (y2 - y1));
                    } catch (Exception e) {
                        tg_shoot_y = 0;
                    }
                    if (Math.abs(frame.getBall().getDx()) <= 0.5 && Math.abs(frame.getBall().getDy()) <= 0.5) {
                        frame.shoot2();
                        if (frame.getPlayer_second().getDx() != 0 && frame.getPlayer_second().getDy() != 0) {
                            double V = 3 * Math.sqrt(2);
                            double dxb = Math.sqrt(9 * V * V / (1 + tg_shoot_y * tg_shoot_y));
                            double dyb = Math.sqrt(Math.abs(V * V - dxb * dxb));
                            if (x1 - x2 < 0 && y1 - y2 < 0) {
                                frame.getBall().setDx(dxb);
                                frame.getBall().setDy(dyb);
                            }
                            if (x1 - x2 < 0 && y1 - y2 > 0) {
                                frame.getBall().setDx(dxb);
                                frame.getBall().setDy(-dyb);
                            }
                            if (x1 - x2 > 0 && y1 - y2 < 0) {
                                frame.getBall().setDx(-dxb);
                                frame.getBall().setDy(dyb);
                            }
                            if (x1 - x2 > 0 && y1 - y2 > 0) {
                                frame.getBall().setDx(-dxb);
                                frame.getBall().setDy(-dyb);
                            }
                        } else {
                            frame.shoot2();
                            if (frame.getPlayer_second().getDx() != 0) {
                                if (y1 - y2 < 0 && frame.getPlayer_second().getDx() < 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(-frame.getPlayer_second().getDx() * tg_shoot_x / 3);
                                    }
                                }
                                if (y1 - y2 < 0 && frame.getPlayer_second().getDx() > 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(frame.getPlayer_second().getDx() * tg_shoot_x / 3);
                                    }
                                }
                                if (y1 - y2 > 0 && frame.getPlayer_second().getDx() < 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(frame.getPlayer_second().getDx() * tg_shoot_x / 3);
                                    }
                                }
                                if (y1 - y2 > 0 && frame.getPlayer_second().getDx() > 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(-frame.getPlayer_second().getDx() * tg_shoot_x / 3);
                                    }
                                }
                            } else {
                                frame.getBall().setDy(frame.getPlayer_second().getDy() * speed_ball);
                            }
                            if (frame.getPlayer_second().getDy() != 0) {
                                if (x1 - x2 > 0 && frame.getPlayer_second().getDy() > 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(-frame.getPlayer_second().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 > 0 && frame.getPlayer_second().getDy() < 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(frame.getPlayer_second().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 < 0 && frame.getPlayer_second().getDy() > 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(frame.getPlayer_second().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 < 0 && frame.getPlayer_second().getDy() < 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(-frame.getPlayer_second().getDy() * tg_shoot_y / 4);
                                    }
                                }
                            } else {
                                frame.getBall().setDx(frame.getPlayer_second().getDx() * speed_ball);
                            }
                        }
                    } else {
                        frame.shoot2();
                        if (frame.getPlayer_second().getDx() == 0 && frame.getPlayer_second().getDy() == 0) {
                            double dby = Math.sqrt(frame.pow(frame.getBall().getDx(), 2) / (1 + frame.pow(tg_shoot_x, 2)));
                            double dbx = (Math.sqrt(Math.abs(frame.pow(frame.getBall().getDx(), 2) - frame.pow(dby, 2))));
                            double a = 1.5;
                            if (dbx < a || dby < a) {
                                if (dbx < a) {
                                    if (frame.getBall().getDx() < 0.5 && frame.getBall().getDx() >= 0) {
                                        frame.getBall().setDx(frame.getBall().getDx() + 0.5);
                                    } else if (frame.getBall().getDx() > -0.5 && frame.getBall().getDx() < 0) {
                                        frame.getBall().setDx(frame.getBall().getDx() - 0.5);
                                    } else {
                                        frame.getBall().setDx(-frame.getBall().getDx());
                                    }
                                } else {
                                    frame.getBall().setDx(((frame.getBall().getDx()) / (Math.abs(frame.getBall().getDx()))) * dbx / 1.3);
                                }
                                if (dby < a) {
                                    if (frame.getBall().getDy() < 0.5 && frame.getBall().getDy() >= 0) {
                                        frame.getBall().setDy(-frame.getBall().getDy() - 0.5);
                                    } else if (frame.getBall().getDy() > -0.5 && frame.getBall().getDy() < 0) {
                                        frame.getBall().setDy(-frame.getBall().getDy() + 0.5);
                                    } else {
                                        frame.getBall().setDy(-frame.getBall().getDy());
                                    }
                                } else {
                                    frame.getBall().setDy(((frame.getBall().getDy()) / (Math.abs(frame.getBall().getDy()))) * dby / 1.3);
                                }
                            } else {
                                frame.getBall().setDx(((frame.getBall().getDx()) / (Math.abs(frame.getBall().getDx()))) * dbx / 1.3);
                                frame.getBall().setDy(((frame.getBall().getDy()) / (Math.abs(frame.getBall().getDy()))) * dby / 1.3);
                            }
                        } else {
                            if (frame.getPlayer_second().getDx() != 0) {
                                if (y1 - y2 < 0 && frame.getPlayer_second().getDx() < 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(-frame.getPlayer_second().getDx() * tg_shoot_x / 4);
                                    }
                                }
                                if (y1 - y2 < 0 && frame.getPlayer_second().getDx() > 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(frame.getPlayer_second().getDx() * tg_shoot_x / 4);
                                    }
                                }
                                if (y1 - y2 > 0 && frame.getPlayer_second().getDx() < 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(frame.getPlayer_second().getDx() * tg_shoot_x / 4);
                                    }
                                }
                                if (y1 - y2 > 0 && frame.getPlayer_second().getDx() > 0) {
                                    if (tg_shoot_x > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDy(-frame.getPlayer_second().getDx() * tg_shoot_x / 4);
                                    }
                                }
                            } else {
                                frame.getBall().setDy(frame.getPlayer_second().getDy() * speed_ball);
                            }
                            if (frame.getPlayer_second().getDy() != 0) {
                                if (x1 - x2 > 0 && frame.getPlayer_second().getDy() > 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(-frame.getPlayer_second().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 > 0 && frame.getPlayer_second().getDy() < 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(frame.getPlayer_second().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 < 0 && frame.getPlayer_second().getDy() > 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(frame.getPlayer_second().getDy() * tg_shoot_y / 4);
                                    }
                                }
                                if (x1 - x2 < 0 && frame.getPlayer_second().getDy() < 0) {
                                    if (tg_shoot_y > 20) {
                                        frame.getBall().setDy(0);
                                    } else {
                                        frame.getBall().setDx(-frame.getPlayer_second().getDy() * tg_shoot_y / 4);
                                    }
                                }
                            } else {
                                frame.getBall().setDx(frame.getPlayer_second().getDx() * speed_ball);
                            }
                        }
                    }
                }
            }


            if (frame.shoot_ball_with_kletka().size() > 0) {
                if (frame.shoot_ball_with_kletka().get(0) != 0) {
                    double k1 = 1.6;
                    double k2 = 0.6;
                    if (frame.shoot_ball_with_kletka().get(0) == 1) {
                        if (frame.shoot_ball_with_kletka().get(1) == frame.getBall().getPlayer_shoot()) {
                            if (frame.getBall().getDy() < 1 && frame.getBall().getDy() >= 0) {
                                frame.getBall().setDy(-k1 * Math.abs(frame.getBall().getDy() + 1));
                            } else if (frame.getBall().getDx() > -1 && frame.getBall().getDx() < 0) {
                                frame.getBall().setDy(-k1 * (frame.getBall().getDy() - 1));
                            } else {
                                frame.getBall().setDy(-k1 * Math.abs(frame.getBall().getDy()));
                            }
                        } else {
                            if (frame.getBall().getDy() < 1 && frame.getBall().getDy() >= 0) {
                                frame.getBall().setDy(-k2 * Math.abs(frame.getBall().getDy() + 1));
                            } else if (frame.getBall().getDx() > -1 && frame.getBall().getDx() < 0) {
                                frame.getBall().setDy(-k2 * (frame.getBall().getDy() - 1));
                            } else {
                                frame.getBall().setDy(-k2 * Math.abs(frame.getBall().getDy()));
                            }
                        }
                    } else if (frame.shoot_ball_with_kletka().get(0) == 2) {
                        if (frame.shoot_ball_with_kletka().get(1) == frame.getBall().getPlayer_shoot()) {
                            if (frame.getBall().getDx() < 1 && frame.getBall().getDx() >= 0) {
                                frame.getBall().setDx(k1 * Math.abs((frame.getBall().getDx() + 1)));
                            } else if (frame.getBall().getDx() > -1 && frame.getBall().getDx() < 0) {
                                frame.getBall().setDx(k1 * Math.abs(frame.getBall().getDx() - 1));
                            } else {
                                frame.getBall().setDx(k1 * Math.abs(frame.getBall().getDx()));
                            }
                        } else {
                            if (frame.getBall().getDx() < 1 && frame.getBall().getDx() >= 0) {
                                frame.getBall().setDx(k2 * Math.abs(frame.getBall().getDx() + 1));
                            } else if (frame.getBall().getDx() > -1 && frame.getBall().getDx() < 0) {
                                frame.getBall().setDx(k2 * Math.abs(frame.getBall().getDx() - 1));
                            } else {
                                frame.getBall().setDx(k2 * Math.abs(frame.getBall().getDx()));
                            }
                        }
                    } else if (frame.shoot_ball_with_kletka().get(0) == 3) {
                        if (frame.shoot_ball_with_kletka().get(1) == frame.getBall().getPlayer_shoot()) {
                            if (frame.getBall().getDy() < 1 && frame.getBall().getDy() >= 0) {
                                frame.getBall().setDy(k1 * Math.abs(frame.getBall().getDy() + 1));
                            } else if (frame.getBall().getDx() > -1 && frame.getBall().getDx() < 0) {
                                frame.getBall().setDy(k1 * Math.abs(frame.getBall().getDy() - 1));
                            } else {
                                frame.getBall().setDy(k1 * Math.abs(frame.getBall().getDy()));
                            }
                        } else {
                            if (frame.getBall().getDy() < 1 && frame.getBall().getDy() >= 0) {
                                frame.getBall().setDy(k2 * Math.abs(frame.getBall().getDy() + 1));
                            } else if (frame.getBall().getDx() > -1 && frame.getBall().getDx() < 0) {
                                frame.getBall().setDy(k2 * Math.abs(frame.getBall().getDy() - 1));
                            } else {
                                frame.getBall().setDy(k2 * Math.abs(frame.getBall().getDy()));
                            }
                        }
                    } else if (frame.shoot_ball_with_kletka().get(0) == 4) {
                        if (frame.shoot_ball_with_kletka().get(1) == frame.getBall().getPlayer_shoot()) {
                            if (frame.getBall().getDx() < 1 && frame.getBall().getDx() >= 0) {
                                frame.getBall().setDx(-k1 * Math.abs((frame.getBall().getDx() + 1)));
                            } else if (frame.getBall().getDx() > -1 && frame.getBall().getDx() < 0) {
                                frame.getBall().setDx(-k1 * Math.abs(frame.getBall().getDx() - 1));
                            } else {
                                frame.getBall().setDx(-k1 * Math.abs(frame.getBall().getDx()));
                            }
                        } else {
                            if (frame.getBall().getDx() < 1 && frame.getBall().getDx() >= 0) {
                                frame.getBall().setDx(-k2 * Math.abs(frame.getBall().getDx() + 1));
                            } else if (frame.getBall().getDx() > -1 && frame.getBall().getDx() < 0) {
                                frame.getBall().setDx(-k2 * Math.abs(frame.getBall().getDx() - 1));
                            } else {
                                frame.getBall().setDx(-k2 * Math.abs(frame.getBall().getDx()));
                            }
                        }
                    }
                }
            }

            if(frame.shoot_player_first_with_kletka()!=0){
                if(frame.shoot_player_first_with_kletka()==1){
                    frame.getPlayer_first().setY(frame.getPlayer_first().getY()-speed);
                }
                if(frame.shoot_player_first_with_kletka()==3){
                    frame.getPlayer_first().setY(frame.getPlayer_first().getY()+speed);
                }
                if(frame.shoot_player_first_with_kletka()==2){
                    frame.getPlayer_first().setX(frame.getPlayer_first().getX()+speed);
                }
                if(frame.shoot_player_first_with_kletka()==4){
                    frame.getPlayer_first().setX(frame.getPlayer_first().getX()-speed);
                }if(frame.shoot_player_first_with_kletka()==5){
                    if(frame.getPlayer_first().getDy()>0){
                        frame.getPlayer_first().setX(frame.getPlayer_first().getX()-5);
                    }if(frame.getPlayer_first().getDx()>0){
                        frame.getPlayer_first().setY(frame.getPlayer_first().getY()-5);
                    }
                }if(frame.shoot_player_first_with_kletka()==6){
                    if(frame.getPlayer_first().getDy()>0){
                        frame.getPlayer_first().setX(frame.getPlayer_first().getX()+5);
                    }if(frame.getPlayer_first().getDx()<0){
                        frame.getPlayer_first().setY(frame.getPlayer_first().getY()-5);
                    }
                }if(frame.shoot_player_first_with_kletka()==7){
                    if(frame.getPlayer_first().getDy()<0){
                        frame.getPlayer_first().setX(frame.getPlayer_first().getX()+5);
                    }if(frame.getPlayer_first().getDx()<0){
                        frame.getPlayer_first().setY(frame.getPlayer_first().getY()+5);
                    }
                }if(frame.shoot_player_first_with_kletka()==8){
                    if(frame.getPlayer_first().getDy()<0){
                        frame.getPlayer_first().setX(frame.getPlayer_first().getX()-5);
                    }if(frame.getPlayer_first().getDx()>0){
                        frame.getPlayer_first().setY(frame.getPlayer_first().getY()+5);
                    }
                }
            }

            if(frame.shoot_player_second_with_kletka()!=0){
                if(frame.shoot_player_second_with_kletka()==1){
                    frame.getPlayer_second().setY(frame.getPlayer_second().getY()-speed);
                }
                if(frame.shoot_player_second_with_kletka()==3){
                    frame.getPlayer_second().setY(frame.getPlayer_second().getY()+speed);
                }
                if(frame.shoot_player_second_with_kletka()==2){
                    frame.getPlayer_second().setX(frame.getPlayer_second().getX()+speed);
                }
                if(frame.shoot_player_second_with_kletka()==4){
                    frame.getPlayer_second().setX(frame.getPlayer_second().getX()-speed);
                }if(frame.shoot_player_second_with_kletka()==5){
                    if(frame.getPlayer_second().getDy()>0){
                        frame.getPlayer_second().setX(frame.getPlayer_second().getX()-5);
                    }if(frame.getPlayer_second().getDx()>0){
                        frame.getPlayer_second().setY(frame.getPlayer_second().getY()-5);
                    }
                }if(frame.shoot_player_second_with_kletka()==6){
                    if(frame.getPlayer_second().getDy()>0){
                        frame.getPlayer_second().setX(frame.getPlayer_second().getX()+5);
                    }if(frame.getPlayer_second().getDx()<0){
                        frame.getPlayer_second().setY(frame.getPlayer_second().getY()-5);
                    }
                }if(frame.shoot_player_second_with_kletka()==7){
                    if(frame.getPlayer_second().getDy()<0){
                        frame.getPlayer_second().setX(frame.getPlayer_second().getX()+5);
                    }if(frame.getPlayer_second().getDx()<0){
                        frame.getPlayer_second().setY(frame.getPlayer_second().getY()+5);
                    }
                }if(frame.shoot_player_second_with_kletka()==8){
                    if(frame.getPlayer_second().getDy()<0){
                        frame.getPlayer_second().setX(frame.getPlayer_second().getX()-5);
                    }if(frame.getPlayer_second().getDx()>0){
                        frame.getPlayer_second().setY(frame.getPlayer_second().getY()+5);
                    }
                }
            }
        }
    }
}