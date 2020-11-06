package Implementation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;


public class TimeRefresh implements Runnable{
	private final JTextField jTextField;
	private Date data;
	private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	private final JButton button;
	public TimeRefresh(JTextField jTextField,Date date,JButton button) {
		super();
		this.jTextField=jTextField;
		this.data=date;
		this.button=button;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(data.getTime()!=-28800000) {
			this.jTextField.setText(format.format(data));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//–›√ﬂ1√Î
			this.data=new Date(data.getTime()-1000);
		}
		button.doClick();
	}
}
