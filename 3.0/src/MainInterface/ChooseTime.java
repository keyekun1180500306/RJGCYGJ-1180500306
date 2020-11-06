package MainInterface;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JTextField;

import Implementation.TimeRefresh;
import Implementation.TimeTransform;

public class ChooseTime {
	private Thread thread;
	public ChooseTime(JTextField jTextField, String xString,JButton button) throws ParseException {
		if (xString.equals("5分钟")) {
			this.thread=new Thread(new TimeRefresh(jTextField, new TimeTransform().CreateTime(0, 5, 0),button));
		} else if (xString.equals("10分钟")) {
			this.thread=new Thread(new TimeRefresh(jTextField, new TimeTransform().CreateTime(0, 10, 0),button));
		} else if (xString.equals("20分钟")) {
			this.thread=new Thread(new TimeRefresh(jTextField, new TimeTransform().CreateTime(0, 20, 0),button));
		} else if (xString.equals("30分钟")) {
			this.thread=new Thread(new TimeRefresh(jTextField, new TimeTransform().CreateTime(0, 30, 0),button));
		} else if (xString.equals("40分钟")) {
			this.thread=new Thread(new TimeRefresh(jTextField, new TimeTransform().CreateTime(0, 40, 0),button));
		} else if (xString.equals("50分钟")) {
			this.thread=new Thread(new TimeRefresh(jTextField, new TimeTransform().CreateTime(0, 50, 0),button));
		} else if (xString.equals("1小时")) {
			this.thread=new Thread(new TimeRefresh(jTextField, new TimeTransform().CreateTime(1, 0, 0),button));
		} else {
			String string[] = xString.split("\\s");
			int hour = Integer.valueOf(string[0]);
			int minute = Integer.valueOf(string[1]);
			this.thread=new Thread(new TimeRefresh(jTextField, new TimeTransform().CreateTime(hour, minute, 0),button));
		}
		thread.start();
	}
	@SuppressWarnings("deprecation")
	public void endThread() {
		this.thread.stop();
	}
}
