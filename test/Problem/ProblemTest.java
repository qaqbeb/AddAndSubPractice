package Problem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProblemTest {

	@Test
	void ProblemTest1() {
		Problem p = new Problem(1, 1, 2);
		assertEquals(1, p.getnum1());
		assertEquals(1, p.getnum2());
		assertEquals('+', p.getop());
		assertEquals("num1 = 1	num2 = 1	op = +", p.toString());
	}

}
