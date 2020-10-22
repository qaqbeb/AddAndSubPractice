/*
 * 增量一内容
 * */
package AddAndSubPractice;

import java.util.TimerTask;

import javax.swing.JLabel;


public class TimeKeeper extends TimerTask{

	JLabel JL = null;
	private int count = 0;
	
	public TimeKeeper(JLabel JL){
		this.JL = JL;
	}
	
	public int getcount() {
		return count;
	}
	
	@Override
	public void run() {
		System.out.println(count);
		count++;
		String min;
		String sec;
		min = String.valueOf((count / 60) % 60);
		if(min.length() == 1)
			min = "0" + min;
		sec = String.valueOf(count % 60);
		if(sec.length() == 1)
			sec = "0" + sec;
		JL.setText(min + ":" + sec);
	}
	
}
