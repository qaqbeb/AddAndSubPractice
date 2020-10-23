package Problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest {

	@Test
	void ProblemTest1() {
		Problem p = new Problem(1, 1, 0);
		assertEquals(1, p.getnum1());
		assertEquals(1, p.getnum2());
		assertEquals('+', p.getop());
		assertEquals("num1 = 1	num2 = 1	op = +", p.toString());
	}
	
	@Test
	void ProblemTest2() {
		Problem p1 = new Problem(1, 1, 0);
		assertEquals(2, p1.Calculate());
		Problem p2 = new Problem(11, 3, 1);
		assertEquals(8, p2.Calculate());
		Problem p3 = new Problem(12, 12, 2);
		assertEquals(144, p3.Calculate());
		Problem p4 = new Problem(56, 7, 3);
		assertEquals(8, p4.Calculate());
	}

}
