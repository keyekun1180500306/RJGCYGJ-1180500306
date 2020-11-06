package Implementation;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TimeTransformTest {
	private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	@Test
	public void CreateTimeTest() {
		Date date =new Date();
		try {
			date = format.parse("02:03:04");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TimeTransform timeTransform = new TimeTransform();
		Date result=new Date();
		try {
			result = timeTransform.CreateTime(2, 3, 4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(result.equals(date));
		
	}
}
