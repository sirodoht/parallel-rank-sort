import java.util.*;

class ParallelRankSort {
	public static void main(String[] args) {

		// Invalid command line arguments
		if (args.length != 3) {
			System.out.println("ParallelRankSort Use");
			System.out.println("Command line arguments: <problem_size> <number_of_threads>");
			System.out.println("<problem_size>: Number of elements of the array to be sorted.");
			System.out.println("<number_of_threads>: Number of threads to be used in the parallelization.");
			System.out.println("	0: uses the number of available processors as number of threads.");
			System.out.println("<random>: Boolean for the use of random data. Use `true` for true. Every other statement evaluates false.");
			System.out.println("\ne.g. `java ParallelRankSort 10000 8 true` which will run 8 threads for an array of 10000 random elements.");
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
		Boolean random = Boolean.valueOf(args[2]);
		System.out.println("Random data: " + random);

		// Initialize arrays
		int[] readArray = new int[elemQuantity];
		int[] resultArray = new int[elemQuantity];


		// Create initial un-sorted array and print it
		for(int i = 0; i < elemQuantity; i++) {
			if (random) {
				Random rand = new Random();
				readArray[i] = rand.nextInt(elemQuantity) + 1;
			} else {
				readArray[i] = elemQuantity - i;
			}
			resultArray[i] = 0;
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
		int blockSize = elemQuantity / threadNum;

		// Start threads
		ParallelRankThread threads[] = new ParallelRankThread[threadNum];
		for(int i = 0, j = 0; i < threadNum; i++, j += blockSize) {
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
