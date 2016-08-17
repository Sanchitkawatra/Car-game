import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.ImageIcon;

class myNewPanel extends JPanel
{
	ImageIcon img;
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		img=new ImageIcon("E:\\java\\FirstProject\\cars icon\\runway.jpg");
		Image i=img.getImage();
		g.drawImage(i,0,0,600,700,null);
	}
}

public class myFirstGame implements KeyListener,Runnable {
		int xMainCar,yMainCar,flag=0,count=0,temp=0,negCount=80,score=0;;
		JFrame frame;
		myNewPanel panel;
		JPanel topPanel,bottomPanel,centerPanel;
		JLabel mainCar,car1,car2,car3,car4,scoreLabel,collideLabel;
		BorderLayout bl;
		Font f;
		Thread t1, t2,t3,t4;
	public myFirstGame() throws InterruptedException {
		t1=new Thread(this);
		t2=new Thread(new SecondCar());

		t3=new Thread(new ThirdCar());

	//	t4=new Thread(new FourthCar());

		f=new Font("Engravers MT", Font.BOLD, 45);
		frame=new JFrame("");
		panel=new myNewPanel();
		topPanel=new JPanel();
		bottomPanel=new JPanel();
		centerPanel=new JPanel();
		
		bl=new BorderLayout();
		panel.setLayout(bl);
		
		System.out.println("Hi1");
		
		frame.add(panel);
		
		panel.add(topPanel,BorderLayout.NORTH);
	//	panel.add(bottomPanel,BorderLayout.SOUTH);
		panel.add(centerPanel,BorderLayout.CENTER);
	
		System.out.println("Hi2");
		centerPanel.setOpaque(false);  //makes frame transparent.
	//	bottomPanel.setOpaque(false);
		topPanel.setOpaque(false);
				//bottomPanel.setLayout(null);
		centerPanel.setLayout(null);
		
		ImageIcon in=new ImageIcon("E:\\java\\FirstProject\\cars icon\\carcropped.jpg");
		ImageIcon in1=new ImageIcon("E:\\java\\FirstProject\\cars icon\\car3cropped.png");		
		ImageIcon in2=new ImageIcon("E:\\java\\FirstProject\\cars icon\\car4cropped.png");
		ImageIcon in3=new ImageIcon("E:\\java\\FirstProject\\cars icon\\car5cropped.png");
		ImageIcon in4=new ImageIcon("E:\\java\\FirstProject\\cars icon\\car6cropped.png");
		ImageIcon boom=new ImageIcon("E:\\java\\FirstProject\\cars icon\\boom.png");
		
		scoreLabel=new JLabel("Score : 00");
		scoreLabel.setFont(f);
		scoreLabel.setForeground(Color.white);
		
		car1= new JLabel(in1);
		car1.setIcon(in1);
		//car1.setOpaque(0.85f);


		car2= new JLabel(in2);
		car2.setIcon(in2);
		
		car3= new JLabel(in3);
		car3.setIcon(in3);

		car4= new JLabel(in4);
		car4.setIcon(in4);
		
		collideLabel=new JLabel(boom);
		collideLabel.setIcon(boom);
		
		mainCar = new JLabel(in);
	    mainCar.setIcon(in);	
	    	mainCar.setBounds(400, 540, 100, 100);
	    
	    	
	 
	    	
	   int xMainCar=mainCar.getX();
	   int yMainCar=mainCar.getY();
	   System.out.println(xMainCar+","+yMainCar);
	 
	    t1.start();
	   
	    t2.start();
	    t3.start();
	//    t4.start();
		//car1.setBounds(300, 300, 62,120);
	 
	    topPanel.add(scoreLabel);
		centerPanel.add(collideLabel);
	    centerPanel.add(car2);
	    centerPanel.add(car1);
	    centerPanel.add(car3);
	    centerPanel.add(car4);
		    
		centerPanel.add(mainCar);
		//collideLabel.setVisible(false);
		frame.addKeyListener(this);
		
		frame.setUndecorated(true);
		frame.setLocation(300,0);
		frame.setSize(600,700);
		frame.setVisible(true);		
		
		
	}

	public static void main(String[] args) throws InterruptedException {
			new myFirstGame();
		
	}

	public void keyPressed(KeyEvent event)
	{
		int keyCode=event.getKeyCode();
		
		if(event.getKeyCode()==37)				
		{
			if(mainCar.getX()>=11)
			{
		
				mainCar.setBounds(mainCar.getX()-30,mainCar.getY(), 100, 100);
			}
		}
	
		else if(event.getKeyCode()==39)  
		{
		
			if(mainCar.getX()<=481)
			{
				mainCar.setBounds(mainCar.getX()+30, mainCar.getY(), 100, 100);
			}
		}
	
		else if(event.getKeyCode()==38)  
		{
			if(mainCar.getY()>=150)
			{
				mainCar.setBounds(mainCar.getX(), mainCar.getY()-30, 100, 100);
			}
		}
		else if(event.getKeyCode()==40)  
		{
			if(mainCar.getY()<=530)
			{
				mainCar.setBounds(mainCar.getX(), mainCar.getY()+30, 100, 100);
			}
		}
	}

      

	

	public void keyReleased(KeyEvent event) {
		
		
	}

	public void keyTyped(KeyEvent event) {
	

		
		
	}
	class ThirdCar implements Runnable
	{
		public void run()
		{
		
			try
			{
							Random rand=new Random();
								int l=rand.nextInt(180)+360;

								System.out.println(l);
								for(int z=-500;z<=700;z=z+10)
								{
									if((car3.getX()>=mainCar.getX() && car3.getX()<=mainCar.getX()+100)||(car3.getX()+65>=mainCar.getX() && car3.getX()+65<=mainCar.getX()+100))
									{
										if((car3.getY()>=mainCar.getY() && car3.getY()<=mainCar.getY()+84)||(car3.getY()+118>=mainCar.getY() && car3.getY()+118<=mainCar.getY()+84))
										{
											flag=1;
											collideLabel.setBounds(mainCar.getX()+40, mainCar.getY(), 60, 53);
										}
					
										else
										{
											
											car3.setBounds(l,z, 62, 121);					
												Thread.sleep(negCount);	
										}
									}
		
									
									else
									{
										car3.setBounds(l,z, 62, 121);
										Thread.sleep(negCount);
									}
									

								}

								 
			
					
			
			}
			catch(Exception ee)
			{}
		   
		}
	}
	
	class SecondCar implements Runnable
	{
		public void run()
		{
		
			try
			{
					while(flag==0)
					{
						
							Random rand=new Random();
								int m=rand.nextInt(210)+160;
								System.out.println(m);
								for(int z=0;z<=700;z=z+10)
								{
									if((car2.getX()>=mainCar.getX() && car2.getX()<=mainCar.getX()+100)||(car2.getX()+65>=mainCar.getX() && car2.getX()+65<=mainCar.getX()+100))
									{
										if((car2.getY()>=mainCar.getY() && car2.getY()<=mainCar.getY()+84)||(car2.getY()+118>=mainCar.getY() && car2.getY()+118<=mainCar.getY()+84))
										{
											flag=1;
											collideLabel.setBounds(mainCar.getX()+40, mainCar.getY(), 60, 53);
										}
					
										else
										{
											//	car1.setBounds(n,y, 62,121);
											car2.setBounds(m,z, 62, 121);
											
								
												Thread.sleep(negCount);
												//	temp++;
										
											
										}
									}
		
									
									else
									{
										//	car1.setBounds(n,y, 62,121);
										car2.setBounds(m,z, 62, 121);
										Thread.sleep(negCount);
										}
									

									

								 
			
					}
			}
			}
			catch(Exception ee)
			{}
		   
		}
	}
	public void run()
		{ 
			try
			{	
				while(flag==0)
				{	
						Random rand=new Random();
						int n=rand.nextInt(150)+10;
					
						for(int y=-300;y<=700;y=y+10)
						{
							if((car1.getX()>=mainCar.getX() && car1.getX()<=mainCar.getX()+100)||(car1.getX()+65>=mainCar.getX() && car1.getX()+65<=mainCar.getX()+100))
							{
								if((car1.getY()>=mainCar.getY() && car1.getY()<=mainCar.getY()+84)||(car1.getY()+118>=mainCar.getY() && car1.getY()+118<=mainCar.getY()+84))
								{
									flag=1;
									collideLabel.setBounds(mainCar.getX()+40, mainCar.getY(), 60, 53);
								
								}
								
								else
								{
									car1.setBounds(n,y, 62,121);
								//	car2.setBounds(m,y, 62, 121);
									
									Thread.sleep(negCount);
									}
								
							}
							
					
							else
							{
								car1.setBounds(n,y, 62,121);
							//	car2.setBounds(m,y, 62, 121);
								Thread.sleep(negCount);
							}
						
			count++;
			if(count%10==0)
			{score=count/10;
			scoreLabel.setText("Score :"+score);
			}
			}
			}
		}
			catch(Exception ee)
			{
			}
		
			
		}

/*
	class FourthCar implements Runnable
	{
		public void run()
		{
		
			try
			{
					while(flag==0)
					{
						
						{
							Random rand=new Random();
								int k=rand.nextInt(530);

								for(int z=-3000;z<=700;z=z+25)
								{
									if((car4.getX()>=mainCar.getX() && car4.getX()<=mainCar.getX()+100)||(car4.getX()+65>=mainCar.getX() && car4.getX()+65<=mainCar.getX()+100))
									{
										if((car4.getY()>=mainCar.getY() && car4.getY()<=mainCar.getY()+84)||(car4.getY()+118>=mainCar.getY() && car4.getY()+118<=mainCar.getY()+84))
										{
											flag=1;
											collideLabel.setBounds(mainCar.getX()+40, mainCar.getY(), 60, 53);
										}
					
										else
										{
											
											car3.setBounds(k,z, 62, 121);					
												Thread.sleep(negCount);	
										}
									}
		
									
									else
									{
										car3.setBounds(k,z, 62, 121);
										Thread.sleep(negCount);
									}
									

								}

								 
			
					}
			}
			}
			catch(Exception ee)
			{}
		   
		}
	}
	
*/
}

	