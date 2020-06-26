package com.kingshuk.junit5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(Lifecycle.PER_METHOD)
@DisplayName("All Tests:")
class MathUtilsTest {

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	public static void init() {
		System.out.println("Starting all tests...");
		
	}

	@BeforeEach
	public void initInstance(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Starting a test:"+testInfo.getDisplayName()+" with tags:"+testInfo.getTags());
		
	}

	@AfterEach
	public void destroyInstance() {
		System.out.println("Ending a test...");
	}

	@AfterAll
	public static void destroy() {
		System.out.println("Ending all tests...");
	}

	@Nested
	@DisplayName("Starting add tests:")
	@Tag("Math")
	class AddTest {
		@Test
		@DisplayName("Testing for positive numbers")
		void testAddPositive() {
			assertAll(() -> assertEquals(2, mathUtils.add(1, 1), ()->"This add method should add two positive numbers"),
					() -> assertEquals(5, mathUtils.add(2, 3), ()->"This add method should add two positive numbers"),
					() -> assertEquals(9, mathUtils.add(8, 1), ()->"This add method should add two positive numbers"));
		}

		@Test
		@DisplayName("Testing for negetive numbers")
		void testAddNegetive() {
			int expected = 2;
			int actual = mathUtils.add(1, 1);
			assertEquals(expected, actual, ()->"This add method should add two negetive numbers");
		}
	}

	@Test
	@DisplayName("Testing area calculation for circle")
	@Tag("Circle")
	void testCalculateCircleArea() {
		double expected = 314.159265358979323846;
		double actual = mathUtils.calculateCircleArea(10);
		assertEquals(expected, actual, ()->"The circle area doesn't match with the test result!!");
	}

	@Test
	@Disabled
	@Tag("Math")
	void testSubtraction() {
		boolean bool = false;
		assumeTrue(bool);
		fail("Not yet implemented");
	}

	@RepeatedTest(3)
	@Tag("Math")
	void testMultiply(RepetitionInfo repetitionInfo) {
		
		if(repetitionInfo.getCurrentRepetition()==1) {
			
			System.out.println("Repeating:1");
			assertEquals(0, mathUtils.multiply(0, 0), ()->"The zero product doesn't match with the test result!!");
		
		}else if(repetitionInfo.getCurrentRepetition()==2) {
			
			System.out.println("Repeating:2");
			assertEquals(1, mathUtils.multiply(1, 1), ()->"The one product doesn't match with the test result!!");
		
		}else if(repetitionInfo.getCurrentRepetition()==3) {
			
			System.out.println("Repeating:3");
			assertEquals(4, mathUtils.multiply(2, 2), ()->"The two product doesn't match with the test result!!");
		
		}
	}

	@Test
	@DisplayName("Testing divide method")
	@Tag("Math")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), ()->"SHOULD THROW EXCEPTION");
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	@Tag("Math")
	void testRem() {
		fail("Not yet implemented");
	}

}
