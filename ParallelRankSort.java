import java.util.*;

class ParallelRankSort {
	public static void main(String[] args) {

		// Invalid command line arguments
		if (args.length != 2) {
			System.out.println("ParallelRankSort Use");
			System.out.println("Command line arguments: <problem_size> <number_of_threads>");
			System.out.println("<problem_size>: Number of elements of the array to be sorted.");
			System.out.println("<number_of_threads>: Number of threads to be used in the parallelization.");
			System.out.println("	0: uses the number of available processors as number of threads.");
			System.out.println("e.g. `java ParallelRankSort 10000 8` which will run 8 threads for an array of 10000 elements.");
			System.exit(0);
		}

		// Get command line arguments
		int elemQuantity = Integer.parseInt(args[0]);
		System.out.println("Problem size: " + elemQuantity);
		int threadNum = Integer.parseInt(args[1]);
		if(threadNum == 0) {
			threadNum = Runtime.getRuntime().availableProcessors();
		}
		System.out.println("Thread number: " + threadNum);

		// Initialize arrays
		int[] readArray = new int[elemQuantity];
		int[] resultArray = new int[elemQuantity];

		// Create initial un-sorted array and print it
		for(int i = 0; i < elemQuantity; i++) {
			readArray[i] = elemQuantity - i;
			resultArray[i] = 0;
			if (i % 10 == 0) {
				readArray[i] = 10;
			}
		}

		// // Print initial array
		// System.out.println("\nInitial array:");
		// for(int i = 0; i < elemQuantity; i++) {
		// 	System.out.print(resultArray[i] + " ");
		// 	if (i % 10 == 0) {
		// 		System.out.println();
		// 	}
		// }
		// System.out.println();

		// Start timer
		long start = System.currentTimeMillis();

		// Calculate blocks of operation for threads
		int divNum = elemQuantity / threadNum;

		// Start threads
		ParallelRankThread threads[] = new ParallelRankThread[threadNum];
		for(int i = 0, j = 0; i < threadNum; i++, j += divNum) {
			threads[i] = new ParallelRankThread(readArray, resultArray, threadNum, i);
			threads[i].start();
		}

		// Join threads
		try {
			for(int i = 0; i < threadNum; i++) {
				threads[i].join();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Stop timer
		long elapsedTimeMillis = System.currentTimeMillis() - start;
		float elapsedTimeSec = elapsedTimeMillis / 1000F;

		// // Print sorted array
		// System.out.println("\nFinal array:");
		// for(int i = 0; i < elemQuantity; i++) {
		// 	System.out.print(resultArray[i] + " ");
		// 	if (i % 10 == 0) {
		// 		System.out.println();
		// 	}
		// }
		// System.out.println();

		// Print duration
		System.out.println("Duration: " + elapsedTimeSec + "s");

  }
}
