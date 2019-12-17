import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gameFrame extends JFrame implements KeyListener {
    private Container cp;
    private ImageIcon icon[] = new ImageIcon[3];
    private JLabel jlb[][] = new JLabel[15][15];
    private byte x, y;
    private byte map[][] = {{0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

    public gameFrame() {
        init();
    }

    public void init() {
        cp = this.getContentPane();
        this.setLayout(new GridLayout(15, 15, 1, 1));
        this.setBounds(50, 50, 800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        icon[0] = new ImageIcon("nrYl5aAsJY.jpg");
        Image img = icon[0].getImage();
        Image newImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icon[0] = new ImageIcon(newImg);
        icon[1] = new ImageIcon("pngtree-grey-round-natural-stone-image_1301483 (1)_burned.png");
        Image img1 = icon[1].getImage();
        Image newImg1 = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icon[1] = new ImageIcon(newImg1);
        icon[2] = new ImageIcon("dbd7820d440e41b40276febe4fa4a09b.png");
        Image img2 = icon[2].getImage();
        Image newImg2 = img2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        icon[2] = new ImageIcon(newImg2);

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                jlb[i][j] = new JLabel();
                jlb[0][0].setIcon(icon[2]);
                if (map[i][j] == 0) {
                    jlb[i][j].setIcon(icon[0]);
                } else {
                    jlb[i][j].setIcon(icon[1]);
                }
                cp.add(jlb[i][j]);
            }
        }



    }
    public void keyPressed(KeyEvent ke){
        switch (ke.getKeyCode()){
            case 37://le
                if(x-1>=0){
                    if(map[y][x-1]==0){
                        jlb[y][x].setIcon(icon[0]);
                        x--;
                        jlb[y][x].setIcon(icon[2]);
                    }
                }
                break;
            case 38://u
                if(y-1>=0){
                    if(map[y-1][x]==0){
                        jlb[y][x].setIcon(icon[0]);
                        y--;
                        jlb[y][x].setIcon(icon[2]);
                    }
                }
                break;
            case 39://r
                if(x+1<15){
                 if(map[y][x+1]==0){
                     jlb[y][x].setIcon(icon[0]);
                     x++;
                     jlb[y][x].setIcon(icon[2]);
                 }
                }
                break;
            case 40://d
                if(y+1<15){
                    if(map[y+1][x]==0){
                        jlb[y][x].setIcon(icon[0]);
                        y++;
                        jlb[y][x].setIcon(icon[2]);
                    }
                }
               if(y==15&&y==15){
                   System.out.println("Game Over");
               }
        }
    }
    public void keyReleased(KeyEvent ke){
        System.out.println(ke.getKeyCode());
    }
    public void keyTyped(KeyEvent ke){
        System.out.println(ke.getKeyCode());
    }
}
