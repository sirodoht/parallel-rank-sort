class SeqRankSort
{
	public static void main(String[] args)
	{
    final int N = 10;
    int[] readArray = new int[N];
    int[] resultArray = new int[N];
    int currentItem;
    int currentPosition;

    System.out.println("\nInitial array:");
    for (int i = 0; i < N; i++) {
      readArray[i] = N - i;
      System.out.print(readArray[i] + " ");
    }
    System.out.println();

    for (int j = 0; j < N; j++) {
      currentItem = readArray[j];
      currentPosition = 0;
      for (int i = 0; i < N; i++) {
        if (currentItem > readArray[i]) {
          currentPosition++;
        }

				// Handles equal numbers
				if ((currentItem == readArray[i]) && (j < i)) {
					currentPosition++;
				}
      }
      resultArray[currentPosition] = currentItem;
    }

    System.out.println("\nFinal array:");
    for (int i = 0; i < N; i++) {
      System.out.print(resultArray[i] + " ");
    }
    System.out.println();

  }
}
