package Implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTransform {
	private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	
	//返回一个hour小时，minute分钟 的Date
	public Date CreateTime(int hour,int minute,int seconds) throws ParseException {
		// TODO Auto-generated method stub
		String string=String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(seconds);
		Date date=format.parse(string);
		return date;
	}
}
