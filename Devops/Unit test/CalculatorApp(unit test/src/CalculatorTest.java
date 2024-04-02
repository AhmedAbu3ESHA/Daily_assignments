import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	static Calculator calculator;
	int a=2,b=5;
	
	@BeforeAll
	static void setupAll() {
		calculator=new Calculator();
		
	}

	
//	@BeforeEach
//	void setup() {
//		calculator=new Calculator();
//	}
//	
//	@AfterEach
//	void tearDown() {
//		calculator=null;
//	}

	@Test
	void testAdd() {
		
		//arrange
		int expected=7;
		
		//act
		int actual=calculator.add(2, 5);
		
		//assert
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testSubtract() {
		
		//arrange
		int expected=-3;
		
		//act
		int actual=calculator.Subtract(2, 5);
		
		//assert
		assertEquals(expected, actual);
	}
	
	@Test
	void testDivideCorrect() {
		
		//arrange
		int expected=2;
		
		//act
		int actual=calculator.divide(10, 5);
		
		//assert
		assertEquals(expected, actual);
	}
	
	@Test
	void testDivideByZero() {
		
		//arrange
//		int expected=2;
		
		//act
//		int actual=calculator.divide(10, 0);
		
		//assert
		Exception exception= assertThrows(IllegalArgumentException.class, ()->calculator.divide(10, 0));
		
		String expectedString="division by zero is illegal";
		
		String actualString=exception.getMessage();
		
		assertEquals(expectedString, actualString);
	}
	
	@Test
	void testDoWork() {
		assertTimeout(Duration.ofMillis(100), ()->calculator.doWork());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
