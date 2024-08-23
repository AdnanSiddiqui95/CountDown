import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RealTimeClock2 
{
	JFrame frame=new JFrame("Real-Time");
	JLabel label=new JLabel();
	public RealTimeClock2()
	{
		frame.setSize(350, 350);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,100,140));
		label.setFont(new Font("arial",Font.BOLD,30));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setForeground(Color.CYAN);
		frame.add(label);
		new NumberThread().start();
		frame.setVisible(true);
	}
	class NumberThread extends Thread
	{
		public void run()
		{
			String x="AM";
			while(true)
			{
				LocalTime time=LocalTime.now();
				int h=time.getHour();
				if(h>12)
				{
					h-=12;
					x="PM";
				}
				else {
					x="AM";}
				int m=time.getMinute();
				int s=time.getSecond();
				String str=h+":"+m+":"+s+" "+x;
				label.setText(str);
				try {
					Thread.sleep(1000);
				}catch (Exception ex) {}
			}
		}
	}
	public static void main(String[] args) 
	{
		new RealTimeClock2();
	}

}
