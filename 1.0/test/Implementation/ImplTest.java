package Implementation;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ImplTest {
	@Test
	public void createRandomNumberTest() {
		Impl impl = new Impl();
		for(int i=0;i<50;i++) {
			int a = impl.createRandomNumber(100);
			assertTrue(a>=0&&a<=100);
		}
	}
}
