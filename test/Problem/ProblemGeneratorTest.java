package Problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemGeneratorTest {

	@Test
	void ProblemGeneratorTest1() {
		Problem p1 = ProblemGenerator.Generate();
		Problem p2 = ProblemGenerator.Generate();
		assertEquals(false, p1.equals(p2));
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}

}
