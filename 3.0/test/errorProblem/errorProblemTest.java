package errorProblem;

import static org.junit.Assert.assertEquals;


import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class errorProblemTest {
	@Test
	public void createAnswerTest() {
		List<String> t = Arrays.asList("4+5","55+45","74-74","14-25");
		List<String> s = Arrays.asList("9","100","0","-11");
		errorProblem ep = new errorProblem();
		List<String> resultList = ep.createAnswer(t);
		assertEquals(s, resultList);
	}
	
}
