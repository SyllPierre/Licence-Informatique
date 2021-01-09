package fil.coo.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Timer;

/**
 * 
**/

public class MyMainTimer{

	public static class MyDate implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.out.println(Calendar.getInstance().getTime());
		}
	}
	
	public static void main(String[] args) {
		Timer timer = new Timer(1000, new MyDate());
		timer.start();
		while(true);
	}
	
	
}
