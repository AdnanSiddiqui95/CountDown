import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StopWatch
{
	JFrame frame=new JFrame("Stop-Watch");
	JLabel label=new JLabel("00:00:00");
	int h=0,m=0,s=0;
	public StopWatch()
	{
		frame.setSize(350,340);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,100,120));
		frame.add(label);
		label.setFont(new Font("Arial",Font.BOLD,30));
		label.setForeground(Color.MAGENTA);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new StopWatchThread().start();
		frame.setVisible(true);
	}
	class StopWatchThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				String time=(h<10?"0"+h:h)+":"+(m<10?"0"+m:m)+":"+(s<10?"0"+s:s);
				label.setText(time);
				try {
					Thread.sleep(1000);
				}catch(Exception ex) {}
				s++;
				if(s==60)
				{
					s=0;
					m++;
					if(m==60)
					{
						m=0;
					h++;
					}
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		new StopWatch();
	}

}
