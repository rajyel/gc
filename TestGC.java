import java.time.*;
import java.time.temporal.*;
public class TestGC {
 
 
	public static void main(String[] args) throws Exception {
		Instant previous, current,gap;
		previous = Instant.now();
	
		TestGC memoryTest = new TestGC();
		memoryTest.generateOOM();
			current = Instant.now();
			 long l  = ChronoUnit.MILLIS.between(previous,current);
			 System.out.println("time eplapsed is "+l);
	}
 
	public void generateOOM() throws Exception {
		int iteratorValue = 20;
		System.out.println("\n=================> OOM test started..\n");
		for (int outerIterator = 1; outerIterator < 60; outerIterator++) {
			System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory()+" iterator value "+iteratorValue);
			iteratorValue = (iteratorValue < 0 ? 20 : iteratorValue);
			int loop1 = 2;
			int[] memoryFillIntVar = new int[iteratorValue];
			// feel memoryFillIntVar array in loop..
			do {
				memoryFillIntVar[loop1] = 0;
				loop1--;
			} while (loop1 > 0);
			iteratorValue = iteratorValue * 5;
			System.out.println("\nRequired Memory for next loop: " + iteratorValue);
			Thread.sleep(1000);
		}
	}
 
}
