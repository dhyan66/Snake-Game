import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements ActionListener{
    static final int screen_width= 600;
    static final int screen_height = 600;
    static final int unit_size = 50;
    static final int game_units = (screen_width*screen_height)/unit_size;
    static final int delay =75;
    final int x[] = new int[game_units];
    final int y[] = new int[game_units];
    int bodyparts =6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(screen_width,screen_height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(delay,this);
        timer.start();

    }

    public void paintComponent(Graphics g){

    }
    public void draw (Graphics g){
        for (int i=0;i<screen_height/unit_size;i++){
            g.drawLine(i*unit_size,0,i*unit_size,screen_height);
        }
        g.setColor(Color.red);
        g.fillOval(appleX,appleY,unit_size,unit_size);

    }
    public void newApple(){
        appleX = random.nextInt((int)(screen_width/unit_size))*unit_size;
        appleY = random.nextInt((int)(screen_height/unit_size))*unit_size;

    }

    public void move(){

    }

    public void checkApple(){

    }
    public  void checkCollisions(){

    }

    public void gameOver(Graphics g){

    }
    public void actionPerformed(ActionEvent e){

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }


}

