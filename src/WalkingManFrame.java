/**
 * 
 * @author Daniel Han
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingManFrame extends JFrame implements ActionListener
{
	private static WalkingMan senor;
	//private ArrayList<Circle> shots = new ArrayList();
	private int x, y;
	
	public WalkingManFrame(int x,int y)
	{
		this.x = x;
		this.y = y;
		setLayout(null);
		setBounds(50,50,x,y);
		senor = new WalkingMan(0,0);
		add(senor);
		setName("Walking Man");
		this.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_S)
				{
					if(senor.getY() > getY() - 25)
					{
						senor.setDy(0);
					}
					else
					senor.setDy(3);
				}
				if(e.getKeyCode() == KeyEvent.VK_W)
				{
					if(senor.getY() <= 15)
					{
						senor.setDy(0);
					}
					else
						senor.setDy(-3);
				}
				if(e.getKeyCode() == KeyEvent.VK_A)
				{
					if(senor.getX() <= 5)
					{
						senor.setDx(0);
					}
					else
						senor.setDx(-3);
				}
				if(e.getKeyCode() == KeyEvent.VK_D)
				{
					if(senor.getX() > getX() - 25)
					{
						senor.setDx(0);
					}
					else
						senor.setDx(3);
				}
				
			}
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_S)
				{
					senor.setDy(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_W)
				{
					senor.setDy(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_A)
				{
					senor.setDx(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_D)
				{
					senor.setDx(0);
				}
			}
			public void keyTyped(KeyEvent e) {}
			});
		
		Timer t1 = new Timer(6,this);
		t1.start();
		
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	
	public static void main(String[] args)
	{
		new WalkingManFrame(600,800);
		
	}
	
	 public void actionPerformed(ActionEvent e)
	{
		senor.update();
		repaint();
	}


}