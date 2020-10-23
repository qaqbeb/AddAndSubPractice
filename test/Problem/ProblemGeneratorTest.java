package Problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemGeneratorTest {

	@Test
	void ProblemGeneratorTest1() {
		Problem p1 = ProblemGenerator.Generate(0);
		Problem p2 = ProblemGenerator.Generate(0);
		assertEquals(false, p1.equals(p2));
	}
	
	@Test
	void ProblemGeneratorTest2() {
		Problem p0 = ProblemGenerator.Generate(0);
		Problem p1 = ProblemGenerator.Generate(1);
		Problem p2 = ProblemGenerator.Generate(2);
		Problem p3 = ProblemGenerator.Generate(3);
		Problem p4 = ProblemGenerator.Generate(4);
		Problem p5 = ProblemGenerator.Generate(5);
		Problem p6 = ProblemGenerator.Generate(6);
		assertEquals(true, p0.getop() == '+' || p0.getop() == '-');
		assertEquals(true, p1.getop() == '*' || p1.getop() == '/');
		assertEquals(true, p2.getop() == '+');
		assertEquals(true, p3.getop() == '-');
		assertEquals(true, p4.getop() == '*');
		assertEquals(true, p5.getop() == '/');
		assertEquals(true, p6.getop() == '+' || p6.getop() == '-' || p6.getop() == '*' || p6.getop() == '/');
	}

}
