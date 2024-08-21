import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownApp 
{
	JFrame frame=new JFrame("Count-Down");
	JLabel label=new JLabel("10");
	public CountDownApp()
	{
		frame.setSize(350, 350);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,100,140));
		label.setFont(new Font("arial",Font.BOLD,30));
		label.setForeground(Color.red);
		frame.add(label);
		new NumberThread().start();
		frame.setVisible(true);
	}
	class NumberThread extends Thread
	{
		public void run()
		{
			for(int num=10;num>=1;num--)
			{
				
				label.setText(String.valueOf(num));
				try {
					Thread.sleep(1000);
				}catch(Exception ex) {}
				if(num>4)
					label.setForeground(Color.red);
				else
					label.setForeground(Color.green);
			}
			label.setText("Let's Begin");
			label.setForeground(Color.blue);
			try {
				Thread.sleep(2000);
			}catch(Exception ex) {}
		}
	}
	public static void main(String[] args) 
	{
		new CountDownApp();
	}

}
