
package pkg2dsnakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

class GamePlay  extends JPanel implements KeyListener,ActionListener{
    
    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];
    private int scores=0;
    
    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    
    private ImageIcon rightmouth;
    private ImageIcon upmouth;  
    private ImageIcon downmouth;  
    private ImageIcon leftmouth;
    
    private int lengthofsnake = 3;
    
    private Timer timer;
    private int delay=100;
    private ImageIcon snakeImage;
    
    
    private int[] enemyxpos={25,50,75,100,125,150,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    
    private int[] enemyypos={75,100,125,150,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
    
    private ImageIcon enemyImage;
    
    private Random random = new Random();
    
    private int xpos=random.nextInt(34);
   
    private int ypos=random.nextInt(23);  
    
    private int moves=0;
    
    private ImageIcon titleImage;
    
    
    public GamePlay()
    {
     addKeyListener(this);
     setFocusable(true);
     setFocusTraversalKeysEnabled(false);
     
     timer = new Timer(delay,this);
     timer.start();
    }
    
    public void paint(Graphics g)
    {
       
        
        if(moves==0)
        {
          snakexlength[2]=50;
          snakexlength[1]=75;
          snakexlength[0]=100;
          
          snakeylength[2]=100;
          snakeylength[1]=100;
          snakeylength[0]=100;


        }


      //draw title image border
        
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        
        //draw the title image
        titleImage = new ImageIcon("C:\\Users\\Sisters\\Documents\\NetBeansProjects\\2DSnakeGame\\src\\pkg2dsnakegame\\snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);
        
        //draw border for gameplay
        g.setColor(Color.white);
        g.drawRect(24,74,851,577);
        
        //draw background for the gameplay
        
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("Scores: " +scores,780, 30);
     
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("Length: " +lengthofsnake,780, 50);
        
        
        
        rightmouth = new ImageIcon("C:\\Users\\Sisters\\Documents\\NetBeansProjects\\2DSnakeGame\\src\\pkg2dsnakegame\\rightmouth.png");
        rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
        
for(int a=0;a<lengthofsnake;a++)
        {
if(a==0 && right)
            {
                
        rightmouth = new ImageIcon("C:\\Users\\Sisters\\Documents\\NetBeansProjects\\2DSnakeGame\\src\\pkg2dsnakegame\\rightmouth.png");
        rightmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        
            }
            
if(a==0 && left)
            {
                
        leftmouth = new ImageIcon("C:\\Users\\Sisters\\Documents\\NetBeansProjects\\2DSnakeGame\\src\\pkg2dsnakegame\\leftmouth.png");
        leftmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        
            }
               
if(a==0 && up)
            {
                
        upmouth = new ImageIcon("C:\\Users\\Sisters\\Documents\\NetBeansProjects\\2DSnakeGame\\src\\pkg2dsnakegame\\upmouth.png");
        upmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        
            }
                    
if(a==0 && down)
            {
                
        downmouth = new ImageIcon("C:\\Users\\Sisters\\Documents\\NetBeansProjects\\2DSnakeGame\\src\\pkg2dsnakegame\\downmouth.png");
        downmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        
            }
if(a!=0)
            {
                
        snakeImage = new ImageIcon("C:\\Users\\Sisters\\Documents\\NetBeansProjects\\2DSnakeGame\\src\\pkg2dsnakegame\\snakeimage.png");
        snakeImage.paintIcon(this,g,snakexlength[a],snakeylength[a]);
        
            }
        }
        
enemyImage = new ImageIcon("C:\\Users\\Sisters\\Documents\\NetBeansProjects\\2DSnakeGame\\src\\pkg2dsnakegame\\enemy.png");


if((enemyxpos[xpos]==snakexlength[0] && enemyypos[ypos]== snakeylength[0]))
{
    
    scores++;
    lengthofsnake++;
    xpos=random.nextInt(34);
    ypos=random.nextInt(23);
}

enemyImage.paintIcon(this,g,enemyxpos[xpos],enemyypos[ypos]);

//snake hit itself and game over
       
for(int b=1;b<lengthofsnake;b++)
{
    if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0])
    {
        right=false;
        left=false;
        up=false;
        down=false;
        
        
        g.setColor(Color.white);
        g.setFont(new Font ("arial",Font.BOLD, 50));
        g.drawString("Game Over", 300, 300);
      
        
          g.setFont(new Font ("arial",Font.BOLD, 20));
        g.drawString("Space to RESTART", 350, 340);
    }
}

g.dispose();
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if(ke.getKeyCode() == KeyEvent.VK_SPACE)
        {
            moves=0;
            scores=0;
            lengthofsnake=3;
            repaint();
        }
        
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
        {
         moves++;
         right=true;
         
         if(!left)
         {
             right=true;
         }
         else
         {
             right=false;
             left=true;
         }
 
         up=false;
         down=false;
        }
        
           if(ke.getKeyCode() == KeyEvent.VK_LEFT)
        {
         moves++;
         left=true;
         
         if(!right)
         {
             left=true;
         }
         else
         {
             left=false;
             right=true;
         }
 
         up=false;
         down=false;
        }
        
           
     if(ke.getKeyCode() == KeyEvent.VK_UP)
        {
         moves++;
         up=true;
         
         if(!down)
         {
             up=true;
         }
         else
         {
             up=false;
             down=true;
         }
 
         left=false;
         right=false;
        }
     
        if(ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
         moves++;
         down=true;
         
         if(!up)
         {
             down=true;
         }
         else
         {
             down=false;
             up=true;
         }
 
         left=false;
         right=false;
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        
        if(right)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakeylength[r+1] = snakeylength[r];
            }
             for(int r=lengthofsnake-1;r>=0;r--)
            {
                if(r==0)
                {
                    snakexlength[r]=snakexlength[r]+25;
                }
                
                else
                {
                  snakexlength[r]=snakexlength[r-1]; 
                }
                if(snakexlength[r]>850)
                {
                    snakexlength[r]=25;
                }
                repaint();
            }
            
        }
        
  if(left)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakeylength[r+1] = snakeylength[r];
            }
             for(int r=lengthofsnake-1;r>=0;r--)
            {
                if(r==0)
                {
                    snakexlength[r]=snakexlength[r]-25;
                }
                
                else
                {
                  snakexlength[r]=snakexlength[r-1]; 
                }
                if(snakexlength[r]<25)
                {
                    snakexlength[r]=850;
                }
                repaint();
            }
            
        }
        
        
         if(down)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakexlength[r+1] = snakexlength[r];
            }
             for(int r=lengthofsnake-1;r>=0;r--)
            {
                if(r==0)
                {
                    snakeylength[r]=snakeylength[r]+25;
                }
                
                else
                {
                  snakeylength[r]=snakeylength[r-1]; 
                }
                if(snakeylength[r]>625)
                {
                    snakeylength[r]=75;
                }
                repaint();
            }
            
        }
         
         
           if(up)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakexlength[r+1] = snakexlength[r];
            }
             for(int r=lengthofsnake-1;r>=0;r--)
            {
                if(r==0)
                {
                    snakeylength[r]=snakeylength[r]-25;
                }
                
                else
                {
                  snakeylength[r]=snakeylength[r-1]; 
                }
                if(snakeylength[r]<75)
                {
                    snakeylength[r]=625;
                }
                repaint();
            }
            
        }
         
         
  
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
