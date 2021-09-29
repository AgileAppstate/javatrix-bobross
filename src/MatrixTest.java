import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.Test;

public class MatrixTest {

	@Test
	public void testPrintMatrix1() {
		// Prep for test
		// Actual and expected outputs
		double[][] testInput1 = {{1.,2.,3.,4.}, {5.,6.,7.,8.}};
		int testInput2 = 3;
		int testInput3 = 1;
		String correctResult = "1.0 2.0 3.0 4.0 \n5.0 6.0 7.0 8.0 \n";
		String testOutput;
		String testFailed = null;

		// Save current System.out and set to new stream we can read.
		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		// Conduct test of print method
		try {
			//String[] args = new String[0];
			Matrix test = new Matrix(testInput1);
			test.print(testInput2, testInput3);
		}
		catch (Exception e) {
			testFailed = "Exception thrown unexpectedly";
		}

		// Cleanup
		// Get all the stuff the method wrote to System.out, and reset it.
		System.out.flush();
		testOutput = baos.toString();
		System.setOut(origOut);

		// Check results
		if (testOutput == null)
			if (testFailed ==  null)
				testFailed = "output to System.out expected";
			else
				testFailed += "; output to System.out expected";
		else if (testOutput.length() == 0)
			if (testFailed ==  null)
				testFailed = "output to System.out expected";
			else
				testFailed += "; output to System.out expected";
		else if (! correctResult.equals(testOutput)) {
			if (testFailed ==  null)
				testFailed = "Incorrect output generated.";
			else
				testFailed += "; incorrect output generated.";
			testFailed += "\nExpected output: \"" + correctResult;
			testFailed += "\nGenerated output: \"" + testOutput + "\n";
		}
		// Show results
		System.err.println("\nTest: \"java print matrix 1\" ");
		if (testFailed != null) {
			System.err.println("Result: ERROR");
			System.err.println("Feedback: " + testFailed);
		}
		else
			System.err.println("Result: PASSED\n");
		assertNull(testFailed, null);
	}

	@Test
	public void testPrintMatrix2() {
		// Prep for test
		// Actual and expected outputs
		double[][] testInput1 = {{1.,2.,3.,4.}, {5.,6.,7.,8.}, {1.,2.,3.,4.}, {5.,6.,7.,8.}};
		int testInput2 = 3;
		int testInput3 = 1;
		String correctResult = "1.0 2.0 3.0 4.0 \n5.0 6.0 7.0 8.0 \n1.0 2.0 3.0 4.0 \n5.0 6.0 7.0 8.0 \n";
		String testOutput;
		String testFailed = null;

		// Save current System.out and set to new stream we can read.
		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		// Conduct test of print method
		try {
			//String[] args = new String[0];
			Matrix test = new Matrix(testInput1);
			test.print(testInput2, testInput3);
		}
		catch (Exception e) {
			testFailed = "Exception thrown unexpectedly";
		}

		// Cleanup
		// Get all the stuff the method wrote to System.out, and reset it.
		System.out.flush();
		testOutput = baos.toString();
		System.setOut(origOut);

		// Check results
		if (testOutput == null)
			if (testFailed ==  null)
				testFailed = "output to System.out expected";
			else
				testFailed += "; output to System.out expected";
		else if (testOutput.length() == 0)
			if (testFailed ==  null)
				testFailed = "output to System.out expected";
			else
				testFailed += "; output to System.out expected";
		else if (! correctResult.equals(testOutput)) {
			if (testFailed ==  null)
				testFailed = "Incorrect output generated.";
			else
				testFailed += "; incorrect output generated.";
			testFailed += "\nExpected output: \"" + correctResult;
			testFailed += "\nGenerated output: \"" + testOutput + "\n";
		}
		// Show results
		System.err.println("\nTest: \"java print matrix 2\" ");
		if (testFailed != null) {
			System.err.println("Result: ERROR");
			System.err.println("Feedback: " + testFailed);
		}
		else
			System.err.println("Result: PASSED\n");
		assertNull(testFailed, null);
	}

	@Test
	public void testConstantMatrix1() {
		// Prep for test
		// Actual and expected outputs
		int testInput1 = 5;
		int testInput2 = 5;
		double testInput3 = 25.;

		double[][] correctResult = {{25.,25.,25.,25.,25.}, {25.,25.,25.,25.,25.}, {25.,25.,25.,25.,25.},
				{25.,25.,25.,25.,25.}, {25.,25.,25.,25.,25.}};
		double[][] testOutput = null;
		String testFailed = null;

		// Save current System.out and set to new stream we can read.
		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		// Conduct test of print method
		try {
			//String[] args = new String[0];
			Matrix test = new Matrix(testInput1, testInput2, testInput3);
			testOutput = test.matrix;
		}
		catch (Exception e) {
			testFailed = "Exception thrown unexpectedly";
		}

		// Cleanup
		// Get all the stuff the method wrote to System.out, and reset it.
		System.out.flush();
		System.setOut(origOut);

		// Check results
		if (testOutput == null)
			testFailed = "matrix not initialized";

		else if (!Arrays.deepEquals(correctResult, testOutput)) {
			if (testFailed ==  null)
				testFailed = "Incorrect output generated.";
			else
				testFailed += "; incorrect output generated.";
			testFailed += "\nExpected output: \"" + Arrays.deepToString(correctResult);
			testFailed += "\nGenerated output: \"" + Arrays.deepToString(testOutput) + "\n";
		}
		// Show results
		System.err.println("\nTest: \"java generate constant matrix\" ");
		if (testFailed != null) {
			System.err.println("Result: ERROR");
			System.err.println("Feedback: " + testFailed);
		}
		else
			System.err.println("Result: PASSED\n");
		assertNull(testFailed);
	}

	@Test
	public void testConstantMatrix2() {
		// Prep for test
		// Actual and expected outputs
		int testInput1 =3;
		int testInput2 = 2;
		double testInput3 = 6.3;

		double[][] correctResult = {{6.3,6.3}, {6.3,6.3}, {6.3,6.3}};
		double[][] testOutput = null;
		String testFailed = null;

		// Save current System.out and set to new stream we can read.
		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		// Conduct test of print method
		try {
			//String[] args = new String[0];
			Matrix test = new Matrix(testInput1, testInput2, testInput3);
			testOutput = test.matrix;
		}
		catch (Exception e) {
			testFailed = "Exception thrown unexpectedly";
		}

		// Cleanup
		// Get all the stuff the method wrote to System.out, and reset it.
		System.out.flush();
		System.setOut(origOut);

		// Check results
		if (testOutput == null)
			testFailed = "matrix not initialized";

		else if (!Arrays.deepEquals(correctResult, testOutput)) {
			if (testFailed ==  null)
				testFailed = "Incorrect output generated.";
			else
				testFailed += "; incorrect output generated.";
			testFailed += "\nExpected output: \"" + Arrays.deepToString(correctResult);
			testFailed += "\nGenerated output: \"" + Arrays.deepToString(testOutput) + "\n";
		}
		// Show results
		System.err.println("\nTest: \"java generate constant matrix\" ");
		if (testFailed != null) {
			System.err.println("Result: ERROR");
			System.err.println("Feedback: " + testFailed);
		}
		else
			System.err.println("Result: PASSED\n");
		assertNull(testFailed);
	}

	@Test
	public void testTimes1() {
		// Prep for test
		// Actual and expected outputs
		int testInput1 =3;
		int testInput2 = 3;
		double testInput3 = 2.;


		double[][] correctResult = {{12.,12., 12.}, {12.,12., 12.}, {12.,12., 12.}};
		Matrix testOutput = null;
		String testFailed = null;

		// Save current System.out and set to new stream we can read.
		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		// Conduct test of print method
		try {
			//String[] args = new String[0];
			Matrix test = new Matrix(testInput1, testInput2, testInput3);
			testOutput = test.times(new Matrix(testInput1, testInput2, testInput3));
		}
		catch (Exception e) {
			testFailed = "Exception thrown unexpectedly";
		}

		// Cleanup
		// Get all the stuff the method wrote to System.out, and reset it.
		System.out.flush();
		System.setOut(origOut);

		// Check results
		if (testOutput == null)
			testFailed = "matrix not initialized";

		else if (!Arrays.deepEquals(correctResult, testOutput.matrix)) {
			if (testFailed ==  null)
				testFailed = "Incorrect output generated.";
			else
				testFailed += "; incorrect output generated.";
			testFailed += "\nExpected output: \"" + Arrays.deepToString(correctResult);
			testFailed += "\nGenerated output: \"" + Arrays.deepToString(testOutput.matrix) + "\n";
		}
		// Show results
		System.err.println("\nTest: \"java generate constant matrix\" ");
		if (testFailed != null) {
			System.err.println("Result: ERROR");
			System.err.println("Feedback: " + testFailed);
		}
		else
			System.err.println("Result: PASSED\n");
		assertNull(testFailed);
	}


	@Test
	public void testTimes2() {
		// Prep for test
		// Actual and expected outputs
		int testInput1 =3;
		int testInput2 = 5;
		double testInput3 = 2.;

		int testInput4 =5;
		int testInput5 = 4;
		double testInput6 = 0.1;


		double[][] correctResult = {{1., 1., 1., 1.}, {1., 1., 1., 1.}, {1., 1., 1., 1.}};
		Matrix testOutput = null;
		String testFailed = null;

		// Save current System.out and set to new stream we can read.
		PrintStream origOut = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream newOut = new PrintStream(baos);
		System.setOut(newOut);

		// Conduct test of print method
		try {
			//String[] args = new String[0];
			Matrix test = new Matrix(testInput1, testInput2, testInput3);
			testOutput = test.times(new Matrix(testInput4, testInput5, testInput6));
		}
		catch (Exception e) {
			testFailed = "Exception thrown unexpectedly";
		}

		// Cleanup
		// Get all the stuff the method wrote to System.out, and reset it.
		System.out.flush();
		System.setOut(origOut);

		// Check results
		if (testOutput == null)
			testFailed = "matrix not initialized";

		else if (!Arrays.deepEquals(correctResult, testOutput.matrix)) {
			if (testFailed ==  null)
				testFailed = "Incorrect output generated.";
			else
				testFailed += "; incorrect output generated.";
			testFailed += "\nExpected output: \"" + Arrays.deepToString(correctResult);
			testFailed += "\nGenerated output: \"" + Arrays.deepToString(testOutput.matrix) + "\n";
		}
		// Show results
		System.err.println("\nTest: \"java generate constant matrix\" ");
		if (testFailed != null) {
			System.err.println("Result: ERROR");
			System.err.println("Feedback: " + testFailed);
		}
		else
			System.err.println("Result: PASSED\n");
		assertNull(testFailed);
	}
	@Test
	public void testConstructorZeroes(){
		int testInput1 = 4;
		int testInput2 = 4;
		double correctResults [][] = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}}; 
		Matrix matrix = new Matrix(testInput1, testInput2);
		assertEquals(correctResults, matrix.getArray());


}

