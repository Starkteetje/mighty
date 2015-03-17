import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Basketball {
	private final int width = 400;
	private final int height = 400;
	private final int r=20;
	private int y = 2*r;
	private int x = width/2;
	private int vx=0;
	private int vy=0;
	private final int gravix=1;
	private final int graviy=1;
	private final int factor=1;
	private final int bottomline=300;
	private final int sideline=300;
	
	public static void main(String[] args) {
		final Basketball b = new Basketball();
		final Basketball b2=new Basketball();
		final Basketball b3=new Basketball();
		
		JPanel panel = new JPanel() {
			
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				//line color of edges
				g.setColor(Color.BLACK);
				g.draw3DRect(0, calcy(b), b.width, 0, false);
				g.draw3DRect(calcx(b), 0, 0, b.height, false);
				
				
				//first ball
				//stroke color of balls
				g.setColor(Color.BLUE);
				g.drawOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
				
				//fill color of outer ball
				g.setColor(Color.RED);
				g.fillOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
				
				//fill color of inner ball
				g.setColor(Color.GREEN);
				g.fillOval(b.x-b.r/2, b.y-b.r/2, b.r, b.r);
				
				
				//second ball
				//monochromatic orange
				g.setColor(Color.ORANGE);
				g.drawOval(b2.x-b2.r, b2.y-b2.r, 2*b2.r, 2*b2.r);
				g.fillOval(b2.x-b2.r, b2.y-b2.r, 2*b2.r, 2*b2.r);
				g.fillOval(b2.x-b2.r/2, b2.y-b2.r/2, b2.r, b2.r);
				
				
				//third ball
				//monochromatic orange
				Color c=new Color(20,102,25);
				g.setColor(c);
				g.drawOval(b3.x-b3.r, b3.y-b3.r, 2*b3.r, 2*b3.r);
				g.fillOval(b3.x-b3.r, b3.y-b3.r, 2*b3.r, 2*b3.r);
				g.fillOval(b3.x-b3.r/2, b3.y-b3.r/2, b3.r, b3.r);
			}
			
		};
		
		
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		panel.setSize(b.width, b.height);
		
		frame.setSize(b.width, b.height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		while (true) {
			b.simulatey();
			b.simulatex();
			b2.simulatex();
			b3.simulatey();
			panel.repaint();
			//System.out.println("hallo");
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Oops, we fucked up!");
				e.printStackTrace();
			}
		}
	}
	
	public void simulatey() {
		y = y + vy;
		vy = vy + graviy;
		if (y+r >= bottomline) {
			//System.out.println(y);
			vy = -(vy-graviy);
			vy =vy * factor;
		}
		
		
	}
	
	public void simulatex() {
		x = x + vx;
		vx = vx + gravix;
		if (x+r >= sideline) {
			//System.out.println(y);
			vx = -(vx-gravix);
			vx =vx * factor;
		}
		
		
	}
	
	
	/**calculates max altitude in y direction**/
	protected static int calcy(Basketball b){
		int y=b.y;
		int v=b.vy;
		int bottomline=b.bottomline;
		int r=b.r;
		while(true){
			y = y + v;
			v = v + b.graviy;
			if (y+r >= bottomline) {
				return y+r;
			}
		}
		
	}
	
	
	/**calculates max altitude in x direction**/
	protected static int calcx(Basketball b){
		int x=b.x;
		int v=b.vx;
		int sideline=b.sideline;
		int r=b.r;
		while(true){
			x = x + v;
			v = v + b.gravix;
			if (x+r >= sideline) {
				return x+r;
			}
		}
		
	}
	
	
	
}









