import java.io.IOException;

public class CompareSorts {
    private final int GENERATED_ARRAY_SIZE = 1000000;
    public CompareSorts() throws IOException {

        int[] randomNumbers = FileOperations.readIntArray("random.txt");
        int[] semiOrderedNumbers = FileOperations.readIntArray("semi_ordered.txt");
        int[] decreasingOrderNumbers = new int[GENERATED_ARRAY_SIZE];
        int[] increasingOrderNumbers = new int[GENERATED_ARRAY_SIZE];

        for (int i = 0; i < GENERATED_ARRAY_SIZE; i++) {
            decreasingOrderNumbers[i] = (GENERATED_ARRAY_SIZE * 2) - (i * 2);
            increasingOrderNumbers[i] = i * 3;
        }


        Sorter sorter;

        String[] dataTypes = {"random", "semi_ordered", "decreasing", "increasing"};
        int[][] arrays = {randomNumbers, semiOrderedNumbers, decreasingOrderNumbers, increasingOrderNumbers};

        System.out.println("Sorted with Tim Sort:");
        sorter = new Sorter(new TimSort());
        for (int i = 0; i < dataTypes.length; i++) {
            runAndSave(sorter, arrays[i], "timsort_" + dataTypes[i] + "_out.txt");
        }

        System.out.println("Sorted with Quick Sort:");
        for (QuickSort.PivotStrat strat : QuickSort.PivotStrat.values()) {
            String stratName = strat.name().toLowerCase();
            sorter = new Sorter(new QuickSort(strat));
            for (int i = 0; i < dataTypes.length; i++) {
                runAndSave(sorter, arrays[i], "quicksort_" + stratName + "_" + dataTypes[i] + "_out.txt");
            }
        }

    }

    private static void runAndSave(Sorter sorter, int[] array, String fileName) throws IOException {
        long startTime = System.currentTimeMillis();
        sorter.sort(array);
        long endTime = System.currentTimeMillis();
        FileOperations.writeIntArray(fileName, array);
        System.out.println(fileName + ": " + (endTime - startTime) + " milliseconds");
    }
}
