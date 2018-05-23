package project1;

import org.junit.Test;

//import com.sun.tools.javac.util.Assert;

import static org.junit.Assert.*;

import org.junit.Assert;

public class TestStopWatch {

/**********************************************************************
 *
 * The following are JUnit test cases for the StopWatch.java class 
 *
 *********************************************************************/	

	// default constructor test
	@Test
	public void testMinutes() {
		StopWatch s = new StopWatch();
		s.setMinutes(99);
		assertTrue(s.getMinutes() == 99);
	} //KH and IB
	
	@Test
	public void testZeroMinutes() {
		StopWatch s = new StopWatch();
		s.setMinutes(0);
		assertTrue(s.getMinutes() == 0);
	} //KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testUnderMinutes() {
		StopWatch s = new StopWatch();
		s.setMinutes(-99);
	}//KH and IB
	
	@Test
	public void testSeconds() {
		StopWatch s = new StopWatch();
		s.setSeconds(59);
		assertTrue(s.getSeconds() == 59);
	}//KH and IB
	
	@Test
	public void testZeroSeconds() {
		StopWatch s = new StopWatch();
		s.setSeconds(0);
		assertTrue(s.getSeconds() == 0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testUnderSeconds() {
		StopWatch s = new StopWatch();
		s.setSeconds(-1);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testOverSeconds() {
		StopWatch s = new StopWatch();
		s.setSeconds(60);
	}//KH and IB
	
	@Test
	public void testMilliseconds() {
		StopWatch s = new StopWatch();
		s.setMilliseconds(999);
		assertTrue(s.getMilliseconds() == 999);
	}//KH and IB
	
	@Test
	public void testZeroMilliseconds() {
		StopWatch s = new StopWatch();
		s.setMilliseconds(0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testOverMilliseconds() {
		StopWatch s = new StopWatch();
		s.setMilliseconds(1000);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testUnderMilliseconds() {
		StopWatch s = new StopWatch();
		s.setMilliseconds(-1);
	}//KH and IB
	
	@Test
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test
	public void testConstructor3Parameters() 
	{
		StopWatch s = new StopWatch(2,3,4);
		assertTrue(s.getMinutes() == 2);
		assertTrue(s.getSeconds() == 3);
		assertTrue(s.getMilliseconds() == 4);
	}//KH and IB
	
	@Test
	public void testConstructor3Parameters2() 
	{
		StopWatch s = new StopWatch(0,0,0);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersOverSeconds() {
		StopWatch s = new StopWatch(12,61,14);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersOverMilliseconds() {
		StopWatch s = new StopWatch(0,0,1000);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersUnderMinutes() {
		StopWatch s = new StopWatch(-1,0,0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersUnderSeconds() {
		StopWatch s = new StopWatch(0,-1,0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersUnderMilliseconds() {
		StopWatch s = new StopWatch(12,67,-1);
	}//KH and IB

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersUnderAll() {
		StopWatch s = new StopWatch(-1,-5,-2);
	}//KH and IB
	
	@Test
	public void testConstructor2Parameters() {
		StopWatch s = new StopWatch(2,2);
		assertTrue(s.getSeconds() == 2);
		assertTrue(s.getMilliseconds() == 2);
	}//KH and IB
	
	@Test
	public void testConstructor2ParametersZero() {
		StopWatch s = new StopWatch(0,0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2ParametersNegativeSeconds() {
		StopWatch s = new StopWatch(-2,2);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2ParametersNegativeMilliseconds() {
		StopWatch s = new StopWatch(0,-1);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2ParametersOverMilliseconds() {
		StopWatch s = new StopWatch(0,1000);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor2ParametersOverSeconds() {
		StopWatch s = new StopWatch(60,2);
	}//KH and IB
	
	@Test
	public void testConstructor1Parameter() {
		StopWatch s = new StopWatch(2);
		assertTrue(s.getMilliseconds() == 2);
	}//KH and IB
	
	@Test
	public void testConstructor1Parameter300() {
		StopWatch s = new StopWatch(300);
		assertTrue(s.getMilliseconds() == 300);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor1ParameterOverMilliseconds() {
		StopWatch s = new StopWatch(1000);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor1ParameterUnderMilliseconds() {
		StopWatch s = new StopWatch(-1);
	}	
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegSingleInput2() {
		new StopWatch(-2);
	}//KH and IB
	
	@Test
	public void testConstructorStringOneNumber() {
		StopWatch s = new StopWatch("444");
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 444);
	}//KH and IB
	
	@Test
	public void testConstructorStringTwoNumbers() {
		StopWatch s = new StopWatch("4:4");
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 4);
		assertTrue(s.getMilliseconds() == 4);
	}//KH and IB
	
	@Test
	public void testConstructorStringThreeNumbers() {
		StopWatch s = new StopWatch("4:4:4");
		assertTrue(s.getMinutes() == 4);
		assertTrue(s.getSeconds() == 4);
		assertTrue(s.getMilliseconds() == 4);
	}//KH and IB
	
	@Test
	public void testConstructorStringThreeNumbers2() {
		StopWatch s = new StopWatch("11:11:111");
		assertTrue(s.getMinutes() == 11);
		assertTrue(s.getSeconds() == 11);
		assertTrue(s.getMilliseconds() == 111);
	}//KH and IB
	
	@Test
	public void testConstructorStringZero() {
		StopWatch s = new StopWatch("00:00:000");
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringThreeLetters() {
		StopWatch s = new StopWatch("aaa");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringMillisecondsAndColon() {
		StopWatch s = new StopWatch(":44");
	}//KH and IB
	
	@Test (expected = NumberFormatException.class)
	public void testConstructorStringMillisecondsAndColon2() {
		StopWatch s = new StopWatch("33:");
	}//KH and IB
	
	@Test
	public void testConstructorAndToString() {
		StopWatch s = new StopWatch (5,10,300);
		assertEquals(s.toString(),"5:10:300");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble1Input() {
		new StopWatch("-59:-23");
	}//KH and IB

	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble2aInput() {
		new StopWatch("2:-2");
	}//KH and IB

	@Test (expected = IllegalArgumentException.class)
	public void testAInput() {
		new StopWatch("a");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringOverSeconds() {
		new StopWatch("00:60:000");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringOverMilliseconds() {
		new StopWatch("1000");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringOverSecondsTwoParamters() {
		new StopWatch("60:000");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringUnderMillisecondsTwoParameters1() {
		new StopWatch("-1:000");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringUnderMillisecondsOneParameter() {
		new StopWatch("-1");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringUnderMillisecondsTwoParameters() {
		new StopWatch("0:-1");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringUnderMillisecondsThreeParameters() {
		new StopWatch("0:00:-1");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringUnderSecondsTwoParameters() {
		new StopWatch("-1:00");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringUnderMinutesThreeParameters2() {
		new StopWatch("0:-1:00");
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorStringUnderMinutesThreeParameters() {
		new StopWatch("-1:00:00");
	}//KH and IB
	
	@Test (expected = NumberFormatException.class)
	public void testConstructorStringThreeLettersWithColons() {
		new StopWatch("a:a:a");
	}//KH and IB
	
	@Test (expected = NumberFormatException.class)
	public void testConstructorStringTwoLettersWithColons() {
		new StopWatch("b:z");
	}//KH and IB
	
	@Test (expected = NumberFormatException.class)
	public void testConstructorStringCharacters() {
		new StopWatch("///");
	}//KH and IB
	
	@Test (expected = NumberFormatException.class)
	public void testConstructorStringCharacters2() {
		new StopWatch("%%%");
	}//KH and IB
	
	@Test (expected = NumberFormatException.class)
	public void testConstructorStringCharactersWithThreeColons() {
		new StopWatch("%:00:00");
	}//KH and IB
	
	@Test (expected = NumberFormatException.class)
	public void testConstructorStringCharactersWithTwoColons() {
		new StopWatch("&:00");
	}//KH and IB
	
	@Test
	public void someExtraToStringTests(){
	
	StopWatch s;
	
	s = new StopWatch("20:10:8");
	assertEquals(s.toString(),"20:10:008");
	
	s = new StopWatch("20:8");
	assertEquals(s.toString(),"0:20:008");
	
	s = new StopWatch("8");
	assertEquals(s.toString(),"0:00:008");
}//KH and IB

	
	@Test 
	public void testEqual() {
		StopWatch s1 = new StopWatch (5,59,300);
		StopWatch s2 = new StopWatch (6,01,200);
		StopWatch s3 = new StopWatch (5,50,200);
		StopWatch s4 = new StopWatch (5,59,300);

		assertFalse(s1.equals(s2));
		assertTrue (s1.equals(s4));
		
		assertTrue (s2.compareTo(s1) > 0);
		assertTrue (s3.compareTo(s1) < 0);
		assertTrue (s1.compareTo(s4) == 0);
	}//KH and IB
	
	@Test
	public void testEqualsStopWatchParameter() {
		StopWatch s1 = new StopWatch(0,0,000);
		StopWatch s2 = new StopWatch(0,0,000);
		
		assertTrue(s1.equals(s2));
	}//KH and IB
	
	@Test
	public void testEqualsStopWatchParameterOneMillisecond() {
		StopWatch s1 = new StopWatch(0,0,001);
		StopWatch s2 = new StopWatch(0,0,000);
		
		assertFalse(s1.equals(s2));
	}//KH and IB
	
	@Test
	public void testEqualsStopWatchParameterOneSecond() {
		StopWatch s1 = new StopWatch(0,1,000);
		StopWatch s2 = new StopWatch(0,0,000);
		
		assertFalse(s1.equals(s2));
	}//KH and IB
	
	@Test
	public void testEqualsStopWatchParameterOneMinute() {
		StopWatch s1 = new StopWatch(1,0,000);
		StopWatch s2 = new StopWatch(0,0,000);
		
		assertFalse(s1.equals(s2)); //QUESTION: WHAT IS THIS? 
	}//KH and IB
	
	@Test 
	public void equalsTest() {
		StopWatch s1 = new StopWatch (5,59,300);
		StopWatch s2 = new StopWatch (5,59,300);
		assertEquals(s1, s2);
	}//KH and IB

	@Test
		public void testEqualsStopWatch2Parameter() {
			StopWatch s = new StopWatch();

			StopWatch s1 = new StopWatch(0, 00, 000);
			StopWatch s2 = new StopWatch(0, 00, 000);

			assertTrue(s.equals(s1, s2));
		}//KH and IB

		@Test
		public void testEqualsStopWatch2ParameterMilliseconds() {
			StopWatch s = new StopWatch();

			StopWatch s1 = new StopWatch(0, 00, 001);
			StopWatch s2 = new StopWatch(0, 00, 000);

			assertFalse(s.equals(s1, s2));
		}//KH and IB

		@Test
		public void testEqualsStopWatch2ParameterSeconds() {
			StopWatch s = new StopWatch();

			StopWatch s1 = new StopWatch(0, 01, 000);
			StopWatch s2 = new StopWatch(0, 00, 000);

			assertFalse(s.equals(s1, s2));
		}//KH and IB

		@Test
		public void testEqualsStopWatch2ParameterMinutes() {
			StopWatch s = new StopWatch();

			StopWatch s1 = new StopWatch(1, 00, 000);
			StopWatch s2 = new StopWatch(0, 00, 000);

			assertFalse(s.equals(s1, s2));
		}//KH and IB

		@Test(expected = IllegalArgumentException.class)
		public void testEqualsStopWatch2ParameterNegMin() {
			StopWatch s = new StopWatch();

			StopWatch s1 = new StopWatch(-1, 00, 000);
			StopWatch s2 = new StopWatch(0, 00, 000);

			assertFalse(s.equals(s1, s2));
		}//KH and IB

		@Test(expected = IllegalArgumentException.class)
		public void testEqualsStopWatch2ParameterNegSec() {
			StopWatch s = new StopWatch();

			StopWatch s1 = new StopWatch(0, -1, 000);
			StopWatch s2 = new StopWatch(0, 00, 000);

			assertFalse(s.equals(s1, s2));
		}//KH and IB

		@Test(expected = IllegalArgumentException.class)
		public void testEqualsStopWatch2ParameterNegMilliSeconds() {
			StopWatch s = new StopWatch();

			StopWatch s1 = new StopWatch(0, 00, -1);
			StopWatch s2 = new StopWatch(0, 00, -1);

			assertFalse(s.equals(s1, s2));
		}//KH and IB
	
	@Test 
	public void testCompareToAbove() {
		StopWatch s1 = new StopWatch (5,59,999);
		StopWatch s2 = new StopWatch (6,00,000);
		
		assertTrue (s2.compareTo(s1) > 0);
	}//KH and IB
	
	@Test 
	public void testCompareToSame() {
		StopWatch s1 = new StopWatch (0,00,00);
		StopWatch s2 = new StopWatch (0,00,00);
		
		assertTrue (s2.compareTo(s1) == 0);
	}//KH and IB
	
	@Test 
	public void testCompareToSame2() {
		StopWatch s1 = new StopWatch (5,59,999);
		StopWatch s2 = new StopWatch (5,59,999);
		
		assertTrue (s2.compareTo(s1) == 0);
	}//KH and IB
	
	@Test 
	public void testCompareToBelow() {
		StopWatch s1 = new StopWatch (0,00,001);
		StopWatch s2 = new StopWatch (0,00,000);
		
		assertTrue (s2.compareTo(s1) < 0);
	}//KH and IB
	
	@Test 
	public void testCompareToBelow2() {
		StopWatch s1 = new StopWatch (9,59,999);
		StopWatch s2 = new StopWatch (9,59,998);
		
		assertTrue (s2.compareTo(s1) < 0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testCompareToNegativeMilliseconds() {
		StopWatch s1 = new StopWatch (0,00,-1);
		StopWatch s2 = new StopWatch (0,00,000);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testCompareToNegativeSeconds() {
		StopWatch s1 = new StopWatch (0,-1,000);
		StopWatch s2 = new StopWatch (0,00,000);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testCompareToNegativeMinutes() {
		StopWatch s1 = new StopWatch (-1,0,000);
		StopWatch s2 = new StopWatch (0,00,000);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testCompareToOverSeconds() {
		StopWatch s1 = new StopWatch (0,60,000);
	}//KH and IB
	
	@Test
	public void testAddMethod() {
		StopWatch s1 = new StopWatch (5,59,300);
		s1.add(2000);
		assertEquals (s1.toString(),"6:01:300");
		
		s1 = new StopWatch (5,59,300);
		StopWatch s2 = new StopWatch (2,2,300);
		s1.add(s2);
		System.out.println (s1);
		assertEquals (s1.toString(),"8:01:600");
	
		for (int i = 0; i < 15000; i++)
			s1.inc();
		System.out.println (s1);
		assertEquals (s1.toString(),"8:16:600");
	}//KH and IB

	//test add methods

	@Test
		public void testAddMethodOther() {
			StopWatch s1 = new StopWatch(5, 59, 300);
			s1.add(2000);
			assertEquals(s1.toString(), "6:01:300");

			s1 = new StopWatch(5, 59, 300);
			StopWatch s2 = new StopWatch(2, 2, 300);
			s1.add(s2);
			System.out.println(s1);
			assertEquals(s1.toString(), "8:01:600");

			for (int i = 0; i < 15000; i++)
				s1.inc();
			System.out.println(s1);
			assertEquals(s1.toString(), "8:16:600");
		} //KH and IB

		@Test
		public void testAddMethodIntParam() {
			StopWatch s1 = new StopWatch(0, 0, 000);
			s1.add(000);
			assertEquals(s1.toString(), "0:00:000");
		} //KH and IB

		@Test
		public void testAddMethodIntParamSeconds() {
			StopWatch s1 = new StopWatch(0, 0, 000);
			s1.add(1000);
			assertEquals(s1.toString(), "0:01:000");
		}//KH and IB

		@Test
		public void testAddMethodIntParamMinutes() {
			StopWatch s1 = new StopWatch(0, 0, 000);
			s1.add(60000);
			assertEquals(s1.toString(), "1:00:000");
		}//KH and IB

		@Test(expected = IllegalArgumentException.class)
		public void testAddMethodIntParamNegMilliseconds() {
			StopWatch s1 = new StopWatch(0, 0, 000);
			s1.add(-1);
		}//KH and IB

		@Test(expected = IllegalArgumentException.class)
		public void testAddMethodIntParamAnotherNegMilliseconds() {
			StopWatch s1 = new StopWatch(0, 0, 000);
			s1.add(-1000);
		}//KH and IB

	@Test
	public void testAddMethodStopWatchOther() { 
		StopWatch s1 = new StopWatch(0,00,000);
		StopWatch s2 = new StopWatch(0,0,1);
		s1.add(s2);
		
		assertEquals(s1.toString(),"0:00:001");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherSecond() { 
		StopWatch s1 = new StopWatch(0,00,000);
		StopWatch s2 = new StopWatch(0,01,001);
		s1.add(s2);
		
		assertEquals(s1.toString(),"0:01:001");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherMinute() { 
		StopWatch s1 = new StopWatch(0,00,000);
		StopWatch s2 = new StopWatch(10,01,001);
		s1.add(s2);
		
		assertEquals(s1.toString(),"10:01:001");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherAll() { 
		StopWatch s1 = new StopWatch(0,00,998);
		StopWatch s2 = new StopWatch(0,00,1);
		s1.add(s2);
		
		assertEquals(s1.toString(),"0:00:999");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherOverMilliseconds() { 
		StopWatch s1 = new StopWatch(0,00,999);
		StopWatch s2 = new StopWatch(0,00,1);
		s1.add(s2);
		
		assertEquals(s1.toString(),"0:01:000");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherOverSeconds() { 
		StopWatch s1 = new StopWatch(0,59,999);
		StopWatch s2 = new StopWatch(0,00,01);
		s1.add(s2);
		
		assertEquals(s1.toString(),"1:00:000");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherOverMinute() { 
		StopWatch s1 = new StopWatch(10,59,999);
		StopWatch s2 = new StopWatch(0,00,01);
		s1.add(s2);
		
		assertEquals(s1.toString(),"11:00:000");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherMilliseconds() { 
		StopWatch s1 = new StopWatch(0,00,10);
		StopWatch s2 = new StopWatch(0,00,10);
		s1.add(s2);
		
		assertEquals(s1.toString(),"0:00:020");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherMilliseconds2() { 
		StopWatch s1 = new StopWatch(0,00,400);
		StopWatch s2 = new StopWatch(0,00,9);
		s1.add(s2);
		
		assertEquals(s1.toString(),"0:00:409");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherSeconds() { 
		StopWatch s1 = new StopWatch(0,20,10);
		StopWatch s2 = new StopWatch(0,10,10);
		s1.add(s2);
		
		assertEquals(s1.toString(),"0:30:020");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherMinutesBorder() { 
		StopWatch s1 = new StopWatch(2,59,000);
		StopWatch s2 = new StopWatch(0,01,000);
		s1.add(s2);
		
		assertEquals(s1.toString(),"3:00:000");
	}//KH and IB
	
	@Test
	public void testAddMethodStopWatchOtherMinutes() { 
		StopWatch s1 = new StopWatch(2,59,000);
		StopWatch s2 = new StopWatch(5,01,000);
		s1.add(s2);
		
		assertEquals(s1.toString(),"8:00:000");
	}//KH and IB

	@Test
		public void testIncMilli() {
			StopWatch s1 = new StopWatch(0, 00, 000);
			s1.inc();
			assertEquals(s1.toString(), "0:00:001");
		}//KH and IB

		@Test
		public void testIncSec() {
			StopWatch s1 = new StopWatch(0, 00, 999);
			s1.inc();
			assertEquals(s1.toString(), "0:01:000");
		}//KH and IB

		@Test
		public void testIncMin() {
			StopWatch s1 = new StopWatch(0, 59, 999);
			s1.inc();
			assertEquals(s1.toString(), "1:00:000");
		}//KH and IB

		@Test
		public void testSubParamOtherMilli() {

			StopWatch s1 = new StopWatch(0, 00, 100);
			StopWatch s2 = new StopWatch(0, 00, 001);

			s1.sub(s2);
			assertEquals(s1.toString(), "0:00:099");

		}//KH and IB
	
	@Test 
	public void testSubMilliseconds() {
		StopWatch s = new StopWatch(0,00,1);
		s.sub(1);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test
	public void testSubMillisecondsSecond() {
		StopWatch s = new StopWatch(0,1,0);
		s.sub(1);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 999);
	}//KH and IB
	
	@Test 
	public void testSubMillisecondsMinute() {
		StopWatch s = new StopWatch(1,00,0);
		s.sub(1);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 59);
		assertTrue(s.getMilliseconds() == 999);
	}//KH and IB
	
	@Test 
	public void testSubMillisecondsMinute2() {
		StopWatch s = new StopWatch(10,00,0);
		s.sub(1);
		assertTrue(s.getMinutes() == 9);
		assertTrue(s.getSeconds() == 59);
		assertTrue(s.getMilliseconds() == 999);
	}//KH and IB
	
	@Test 
	public void testSubMillisecondsMillisecondsNormal() {
		StopWatch s = new StopWatch(0,00,400);
		s.sub(100);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 300);
	}//KH and IB
	
	@Test 
	public void testSubMillisecondsMillisecondsToZero() {
		StopWatch s = new StopWatch(0,00,400);
		s.sub(400);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test 
	public void testSubMillisecondsSecondsToZero() {
		StopWatch s = new StopWatch(0,2,000);
		s.sub(2000);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test 
	public void testSubMillisecondsMinutesToZero() {
		StopWatch s = new StopWatch(1,0,0);
		s.sub(60000);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubMillisecondsMinutesOverZero() {
		StopWatch s = new StopWatch(1,0,0);
		s.sub(60001);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubMillisecondsFail() {
		StopWatch s1 = new StopWatch(0,00,000);
		s1.sub(1);
	}//KH and IB

	@Test
		public void testSubParamOtherSec() {

			StopWatch s1 = new StopWatch(0, 10, 000);
			StopWatch s2 = new StopWatch(0, 00, 999);

			s1.sub(s2);
			assertEquals(s1.toString(), "0:09:001");
		}//KH and IB

		@Test
		public void testSubParamOtherMin() {

			StopWatch s1 = new StopWatch(10, 00, 000);
			StopWatch s2 = new StopWatch(0, 00, 001);

			s1.sub(s2);
			assertEquals(s1.toString(), "9:59:999");
		}//KH and IB

		@Test(expected = IllegalArgumentException.class)
		public void testSubParamOtherNegMin() {

			StopWatch s1 = new StopWatch(10, 00, 000);
			StopWatch s2 = new StopWatch(0, 00, -001);

			s1.sub(s2);
			assertEquals(s1.toString(), "9:59:999");
		}//KH and IB

		@Test(expected = IllegalArgumentException.class)
		public void testSubParamOtherNegMilli() {

			StopWatch s1 = new StopWatch(0, 00, 100);
			StopWatch s2 = new StopWatch(0, 00, -001);

			s1.sub(s2);
			assertEquals(s1.toString(), "0:00:099");
		}//KH and IB

		@Test(expected = IllegalArgumentException.class)
		public void testSubParamOtherNegSec() {

			StopWatch s1 = new StopWatch(0, 10, 000);
			StopWatch s2 = new StopWatch(0, 00, -999);

			s1.sub(s2);
			assertEquals(s1.toString(), "0:09:001");
		}//KH and IB

	@Test
	public void testDecNormal() {
		StopWatch s = new StopWatch(0,0,1);
		s.dec();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}//KH and IB
	
	@Test
	public void testDecNormal2() {
		StopWatch s = new StopWatch(0,0,10);
		s.dec();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 9);
	}//KH and IB
	
	@Test
	public void testDecSeconds() {
		StopWatch s = new StopWatch(0,1,0);
		s.dec();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 999);
	}//KH and IB
	
	@Test
	public void testDecMinutes() {
		StopWatch s = new StopWatch(1,0,0);
		s.dec();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 59);
		assertTrue(s.getMilliseconds() == 999);
	}//KH and IB
	

	@Test
	public void testDecMinutes2() {
		StopWatch s = new StopWatch(11,0,0);
		s.dec();
		assertTrue(s.getMinutes() == 10);
		assertTrue(s.getSeconds() == 59);
		assertTrue(s.getMilliseconds() == 999);
	}//KH and IB
	
	@Test
	public void testDecThreeTimes() {
		StopWatch s = new StopWatch(0,0,4);
		s.dec();
		s.dec();
		s.dec();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 1);
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testDecMillisecondsFail() {
		StopWatch s = new StopWatch(0,0,0);
		s.dec();
	}//KH and IB
	
	@Test (expected = IllegalArgumentException.class)
	public void testDecMillisecondsFail2() {
		StopWatch s = new StopWatch(0,0,2);
		s.dec();
		s.dec();
		s.dec();
	}//KH and IB
	
	@Test
	public void testToStringBasic() {
			StopWatch s = new StopWatch(0, 00, 000);
			assertTrue(s.toString().equals("0:00:000"));
		}//KH and IB
	
	@Test
	public void testToStringBasic1() {
		StopWatch s = new StopWatch(0, 00, 001);

		assertTrue(s.toString().equals("0:00:001"));
	}//KH and IB
	
	@Test
	public void testToStringBasic2() {
		StopWatch s = new StopWatch(0, 00,10);

		assertTrue(s.toString().equals("0:00:010"));
	}//KH and IB

	
	@Test
	public void testToStringBasic3() {
		StopWatch s = new StopWatch(0, 00, 100);

		assertTrue(s.toString().equals("0:00:100"));
	}//KH and IB

	@Test
	public void testToStringBasic4() {
		StopWatch s = new StopWatch(0, 01,000);

		assertTrue(s.toString().equals("0:01:000"));
	}//KH and IB
	
	@Test
	public void testToStringBasic5() {
		StopWatch s = new StopWatch(0, 10, 00);

		assertTrue(s.toString().equals("0:10:000"));
	}//KH and IB
	
	@Test
	public void testToStringBasic6() {
		StopWatch s = new StopWatch(1, 00, 00);

		assertTrue(s.toString().equals("1:00:000"));
	}//KH and IB
	
		@Test
		public void testToStringSecondsOneDigit() {
			StopWatch s = new StopWatch(0, 9, 000);

			assertTrue(s.toString().equals("0:09:000"));
		}//KH and IB

		@Test
		public void testToStringSecondsTwoDigits() {
			StopWatch s = new StopWatch(0, 19, 000);

			assertTrue(s.toString().equals("0:19:000"));
		}//KH and IB

		@Test
		public void testToStringMillisecondsTwoDigits() {
			StopWatch s = new StopWatch(0, 19, 90);

			assertTrue(s.toString().equals("0:19:090"));
		}//KH and IB

		@Test
		public void testToStringMillisecondsThreeDigits() {
			StopWatch s = new StopWatch(0, 19, 999);

			assertTrue(s.toString().equals("0:19:999"));
		}//KH and IB
		
		@Test
		public void testToStringAllChange() {
			StopWatch s = new StopWatch(2, 19, 999);

			assertTrue(s.toString().equals("2:19:999"));
		}//KH and IB

		@Test
		public void testToStringBigMin() {
			StopWatch s = new StopWatch(25, 19, 999);

			assertTrue(s.toString().equals("25:19:999"));
		}//KH and IB
	
	
	@Test 
	public void testCompareTo() {
		StopWatch s1 = new StopWatch (5,59,300);
		StopWatch s2 = new StopWatch (6,01,200);
		StopWatch s3 = new StopWatch (5,50,200);
		StopWatch s4 = new StopWatch (5,59,300);

		assertFalse(s1.equals(s2));
		assertTrue (s1.equals(s4));
		
		assertTrue (s2.compareTo(s1) > 0);
		assertTrue (s3.compareTo(s1) < 0);
		assertTrue (s1.compareTo(s4) == 0);
	}//KH and IB
		
	@Test 
	public void testLoadSave () {
		StopWatch s1 = new StopWatch (5,59,300);
		StopWatch s2 = new StopWatch (5,59,300);

		s1.save("file1");
		s1 = new StopWatch ();  

		s1.load("file1");
		assertTrue (s1.equals(s2));
	}//KH and IB

	
	//MAX and MAZEN TESTS

	@Test
	public void testConstructor1() {

	   StopWatch s1 = new StopWatch( 1 ,7 ,222);

	   assertEquals(1 ,s1.getMinutes());
	   assertEquals(7 ,s1.getSeconds());
	   assertEquals(222 ,s1.getMilliseconds());
	}

	@Test
	public void testConstructor2() {

	   StopWatch s2 = new StopWatch(42, 22);

	   assertEquals(0 ,s2.getMinutes());
	   assertEquals(42 ,s2.getSeconds());
	   assertEquals(22 ,s2.getMilliseconds());
	}

	@Test
	public void testConstructor3() {

	   StopWatch s2 = new StopWatch(3);

	   assertEquals(0 ,s2.getMinutes());
	   assertEquals(0 ,s2.getSeconds());
	   assertEquals(3 ,s2.getMilliseconds());
	}

	@Test
	public void testConstructor4() {

	   StopWatch s2 = new StopWatch();

	   assertEquals(0 ,s2.getMinutes());
	   assertEquals(0 ,s2.getSeconds());
	   assertEquals(0 ,s2.getMilliseconds());
	}

	@Test
	public void testConstructor5() {

	   StopWatch s2 = new StopWatch("3");

	   assertEquals(0 ,s2.getMinutes());
	   assertEquals(0 ,s2.getSeconds());
	   assertEquals(3 ,s2.getMilliseconds());
	}

	@Test
	public void testConstructor6() {

	   StopWatch s2 = new StopWatch("4:3");

	   assertEquals(0 ,s2.getMinutes());
	   assertEquals(4 ,s2.getSeconds());
	   assertEquals(3 ,s2.getMilliseconds());
	}

	@Test
	public void testConstructor7() {

	   StopWatch s2 = new StopWatch("5:4:3");

	   assertEquals(5 ,s2.getMinutes());
	   assertEquals(4 ,s2.getSeconds());
	   assertEquals(3 ,s2.getMilliseconds());

	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError1() {
	   StopWatch s1 = new StopWatch(-100);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError2() {
	   StopWatch s1 = new StopWatch(1001);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError3() {
	   StopWatch s1 = new StopWatch(-100, 1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError4() {
	   StopWatch s1 = new StopWatch(1, -10);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError5() {
	   StopWatch s1 = new StopWatch(100, 100);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError6() {
	   StopWatch s1 = new StopWatch(10, 1003);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError7() {
	   StopWatch s1 = new StopWatch(-10, 3, 100);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError8() {
	   StopWatch s1 = new StopWatch(10, -3, 100);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError9() {
	   StopWatch s1 = new StopWatch(1,10, -100);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError10() {
	   StopWatch s1 = new StopWatch(1, 100, 100);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorError11() {
	   StopWatch s1 = new StopWatch(1, 10, 10000);
	}

	@Test
	public void testInc1() {

	   StopWatch s2 = new StopWatch(999);

	   s2.inc();
	   assertEquals(1 ,s2.getSeconds());
	   assertEquals(0 ,s2.getMilliseconds());
	}

	@Test
	public void testInc2() {

	   StopWatch s2 = new StopWatch(2,4);

	   s2.inc();
	   s2.inc();
	   s2.inc();
	   assertEquals(2 ,s2.getSeconds());
	   assertEquals(7 ,s2.getMilliseconds());
	}

	@Test
	public void testDec1() {

	   StopWatch s2 = new StopWatch(2,4,1);

	   s2.dec();
	   s2.dec();
	   assertEquals(2 ,s2.getMinutes());
	   assertEquals(3 ,s2.getSeconds());
	   assertEquals(999 ,s2.getMilliseconds());
	}

	@Test
	public void testDec2() {

	   StopWatch s2 = new StopWatch(1,23);

	   s2.dec();
	   s2.dec();
	   s2.dec();
	   s2.dec();
	   s2.dec();
	   s2.dec();
	   assertEquals(1 ,s2.getSeconds());
	   assertEquals(17 ,s2.getMilliseconds());
	}

	@Test
	public void testAdd1() {

	   StopWatch s2 = new StopWatch(1,23);

	   s2.add(100);
	   assertEquals(123 ,s2.getMilliseconds());
	}

	@Test
	public void testAdd2() {

	   StopWatch s2 = new StopWatch(1,900);
	   s2.add(100);
	   assertEquals(2 ,s2.getSeconds());
	   assertEquals(0 ,s2.getMilliseconds());
	}

	@Test
	public void testAdd3() {

	   StopWatch s2 = new StopWatch();

	   s2.add(1000000);
	   assertEquals(16 ,s2.getMinutes());
	   assertEquals(40 ,s2.getSeconds());
	   assertEquals(0 ,s2.getMilliseconds());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddError1(){
	   StopWatch s1 = new StopWatch(1);
	   s1.add(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddError2(){
	   StopWatch s1 = new StopWatch(1);
	   s1.add(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddError3(){
	   StopWatch s1 = new StopWatch(-1, 100);
	   StopWatch s2 = new StopWatch(10, 10);
	   s2.add(s1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddError4(){
	   StopWatch s1 = new StopWatch(-1,1, 100);
	   StopWatch s2 = new StopWatch(10, 10, 10);
	   s2.add(s1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubError1(){
	   StopWatch s1 = new StopWatch();
	   s1.sub(0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubError2(){
	   StopWatch s1 = new StopWatch();
	   s1.sub(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubError3(){
	   StopWatch s1 = new StopWatch(-1,1, 100);
	   StopWatch s2 = new StopWatch(10, 10, 10);
	   s2.sub(s1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSubError4(){
	   StopWatch s1 = new StopWatch(-1, 100);
	   StopWatch s2 = new StopWatch(10, 10);
	   s2.sub(s1);
	}

	@Test
	public void subtractTest1() {

	   StopWatch s2 = new StopWatch(100);

	   s2.sub(100);

	   assertEquals(0 ,s2.getMinutes());
	   assertEquals(0 ,s2.getSeconds());
	   assertEquals(0 ,s2.getMilliseconds());
	}

	@Test
	public void subtractTest2() {

	   StopWatch s2 = new StopWatch(800);

	   s2.sub(500);
	   s2.sub(200);
	   assertEquals(0 ,s2.getMinutes());
	   assertEquals(0 ,s2.getSeconds());
	   assertEquals(100 ,s2.getMilliseconds());
	}

	@Test
	public void subtractTest3() {

	   StopWatch s2 = new StopWatch(1, 100);

	   s2.sub(600);
	   assertEquals(0 ,s2.getMinutes());
	   assertEquals(0 ,s2.getSeconds());
	   assertEquals(500 ,s2.getMilliseconds());
	}

	@Test
	public void testEqualsStopWatch() {

	   StopWatch s3 = new StopWatch(2,3,4);
	   StopWatch s2 = new StopWatch(2,3,4);

	   Assert.assertTrue(s2.equals(s3));
	}

	@Test
	public void testNotEqualsStopWatch() {

	   StopWatch s3 = new StopWatch(2,3,4);
	   StopWatch s2 = new StopWatch(5,2,4);

	   Assert.assertFalse(s2.equals(s3));
	}

	@Test
	public void testStaticEqualsStopWatch() {

	   StopWatch s3 = new StopWatch(2,3,4);
	   StopWatch s2 = new StopWatch(2,3,4);

	   Assert.assertTrue(StopWatch.equals(s2,s3));
	}

	@Test
	public void testStaticNotEqualsStopWatch() {

	   StopWatch s3 = new StopWatch(2,3,4);
	   StopWatch s2 = new StopWatch(5,2,4);

	   Assert.assertFalse(StopWatch.equals(s2,s3));
	}

	@Test
	public void testCompareto1() {
	   StopWatch s3 = new StopWatch(2,3,4);
	   StopWatch s2 = new StopWatch(2,3,5);

	   assertEquals(-1 ,s3.compareTo(s2));
	   assertEquals(1 ,s2.compareTo(s3));
	}

	@Test
	public void testCompareto2() {
	   StopWatch s3 = new StopWatch(2,3,4);
	   StopWatch s2 = new StopWatch(2,3,4);

	   assertEquals(0 ,s3.compareTo(s2));
	   assertEquals(0 ,s2.compareTo(s3));
	}

	@Test
	public void testToString1() {
	   StopWatch s1 = new StopWatch(2,32,404);
	   assertEquals("2:32:404" , s1.toString());
	}

	@Test
	public void testToString2() {

	   StopWatch s1 = new StopWatch(2,3,4);
	   assertEquals("2:03:004" , s1.toString());
	}

	@Test
	public void testToString3() {
	   StopWatch s1 = new StopWatch(2,32,4);
	   assertEquals("2:32:004" , s1.toString());
	}

	@Test
	public void testToString4() {
	   StopWatch s1 = new StopWatch(2,32,42);
	   assertEquals("2:32:042" , s1.toString());
	}

	@Test
	public void testToString5() {
	   StopWatch s1 = new StopWatch(2,2,421);
	   assertEquals("2:02:421" , s1.toString());
	}

	@Test
	public void testToString6() {
	   StopWatch s1 = new StopWatch(2,2,21);
	   assertEquals("2:02:021" , s1.toString());
	}

	@Test
	public void testToSaveAndLoad(){

	   StopWatch s1 = new StopWatch(2,5,7);
	   s1.save("StopWatchFile");
	   s1 = new StopWatch(0,1,0);
	   s1.load("StopWatchFile");
	   Assert.assertEquals(2, s1.getMinutes());
	   Assert.assertEquals(5, s1.getSeconds());
	   Assert.assertEquals(7, s1.getMilliseconds());
	   System.out.println((s1.getMinutes() + ":" + s1.getSeconds() + ":" + s1.getMilliseconds()));

	   s1 = new StopWatch();
	   s1.setMinutes(1);
	   s1.setSeconds(2);
	   s1.setMilliseconds(3);
	   s1.save("StopWatchFile");
	   s1 = new StopWatch();
	   s1.load("StopWatchFile");
	   Assert.assertEquals(1, s1.getMinutes());
	   Assert.assertEquals(2, s1.getSeconds());
	   Assert.assertEquals(3, s1.getMilliseconds());
	   System.out.println((s1.getMinutes() + ":" + s1.getSeconds() + ":" + s1.getMilliseconds()));
	}

	@Test
	public void testToSuspend() {

		StopWatch s2 = new StopWatch();
		StopWatch.suspend(true);

		s2.inc();
		s2.inc();

		Assert.assertEquals(0, s2.getMilliseconds());
		StopWatch.suspend(false);
	}

	@Test 
	public void testMutate () {
		StopWatch s1 = new StopWatch (5,59,300);
		StopWatch s2 = new StopWatch (5,59,300);
		
		StopWatch.suspend(true);
		s1.add(1000);
		assertTrue (s1.equals(s2));	
		StopWatch.suspend(false);
	}
	
	@Test
	public void testSuspendGetSuspended() {
		StopWatch s2 = new StopWatch();
		s2.suspend(true);
		assertTrue(s2.getSuspended() == true);
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testSuspendGetMinutes() {
		StopWatch s2 = new StopWatch(1,0,0);
		s2.suspend(true);
		
		assertTrue(s2.getMinutes() == 1);
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testSuspendSetMinutes() {
		StopWatch s2 = new StopWatch();
		s2.suspend(true);
		
		s2.setMinutes(12);
		
		assertTrue(s2.getMinutes() == 0);
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testSuspendGetSeconds() {
		StopWatch s2 = new StopWatch(1,11,0);
		s2.suspend(true);
		
		assertTrue(s2.getSeconds() == 11);
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testSuspendSetSeconds() {
		StopWatch s2 = new StopWatch(1,11,0);
		s2.suspend(true);
		
		s2.setSeconds(0);
		
		assertTrue(s2.getSeconds() == 11);
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testSuspendGetMilliseconds() {
		StopWatch s2 = new StopWatch(11,229);
		s2.suspend(true);
		
		assertTrue(s2.getMilliseconds() == 229);
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testSuspendSetMilliseconds() {
		StopWatch s2 = new StopWatch(1,11,229);
		s2.suspend(true);
		
		s2.setMilliseconds(0);
		
		assertTrue(s2.getMilliseconds() == 229);
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testToSuspendAddMillisecondParam() {

		StopWatch s2 = new StopWatch();
		StopWatch.suspend(true);

		s2.add(200);

		Assert.assertEquals(0, s2.getMilliseconds());
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testToSuspendAddOtherParam() {
		StopWatch s1 = new StopWatch(1,1,1);
		StopWatch s2 = new StopWatch();
		s2.suspend(true);

		s2.add(s1);

		Assert.assertEquals(0, s2.getMilliseconds());
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testToSuspendSubMillisecondParam() {

		StopWatch s2 = new StopWatch(200);
		StopWatch.suspend(true);

		s2.sub(200);

		Assert.assertEquals(200, s2.getMilliseconds());
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testToSuspendSubOtherParam() {
		StopWatch s1 = new StopWatch(1,1,1);
		StopWatch s2 = new StopWatch(10,10,10);
		s2.suspend(true);

		s2.sub(s1);

		Assert.assertEquals(10, s2.getSeconds());
		Assert.assertEquals(10, s2.getMinutes());
		Assert.assertEquals(10, s2.getMilliseconds());
		StopWatch.suspend(false);
	}//KH and IB
	
	@Test
	public void testSuspendDec() {

		StopWatch s2 = new StopWatch();
		StopWatch.suspend(true);

		s2.dec();
		s2.dec();

		Assert.assertEquals(0, s2.getMilliseconds());
		StopWatch.suspend(false);
	}//KH and IB
	
}
	


