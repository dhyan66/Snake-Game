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
        for(int i = 0; i< bodyparts;i++){
            if(i==0){
                g.setColor(Color.green);
                g.fillRect(x[i],y[i],unit_size,unit_size);
            }
            else {
                g.setColor(new Color(45,180,0));
                g.fillRect(x[i],y[i],unit_size,unit_size);
            }
        }

    }
    public void newApple(){
        appleX = random.nextInt((int)(screen_width/unit_size))*unit_size;
        appleY = random.nextInt((int)(screen_height/unit_size))*unit_size;

    }

    public void move() {
        for (int i = bodyparts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i-1];
        }
        switch (direction){
            case 'U':
                y[0] = y[0] - unit_size;
                break;
            case 'D':
                y[0] = y[0]+unit_size;
                break;
            case 'L':
                x[0] = x[0] - unit_size;
                break;
            case 'R':
                x[0] = x[0] + unit_size;
                break;


        }

    }

    public void checkApple(){

    }
    public  void checkCollisions(){
        for(int i = bodyparts; i>0;i--){
            if((x[0]==x[i])&&(y[0]==y[i])){
                running = false;
            }
            // check if head touches left border
            if(x[0]<0){
                running = false;
            }
            // check if head touches right border
            if(x[0]>screen_width){
                running = false;
            }

            // check if head touches top border
            if(y[0]>screen_width){
                running = false;
            }
            // check if head touches bottom border
            if(y[0]>0){
                running = false;
            }

            if (running = false){
                timer.stop();
            }

        }

    }

    public void gameOver(Graphics g){
        // Game over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());}
 public void actionPerformed(ActionEvent e){
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }


}

