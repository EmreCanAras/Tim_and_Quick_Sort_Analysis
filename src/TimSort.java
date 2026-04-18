public class TimSort extends SortAlgorithm {
    private final int RUN_SIZE = 64;

    @Override
    public void sort(int[] array) {
        int n = array.length;

        //If the array size is smaller than 64, then it is just sorted using insertion sort.
        if (n < RUN_SIZE) {
            insertionSort(array, 0, n - 1);
            return;
        }

        //Sort every run using insertion sort.
        for (int i = 0; i < n; i += RUN_SIZE) {
            insertionSort(array, i, Math.min(i + RUN_SIZE - 1, n - 1));
        }

        //Merge all the runs one by one using merge sort.
        //After every iteration, double the size of the merged sub-array.
        for (int size = RUN_SIZE; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid   = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);

                if (mid < right) {
                    merge(array, left, mid, right);
                }
            }
        }


    }


    private void merge(int[] array, int left, int mid, int right) {
        int leftSize  = mid - left + 1;
        int rightSize = right - mid;

        int[] leftPart  = new int[leftSize  + 1];
        int[] rightPart = new int[rightSize + 1];

        //Take the left part
        for (int i = 0; i < leftSize; i++)
            leftPart[i] = array[left + i];

        //Take right part
        for (int i = 0; i < rightSize; i++)
            rightPart[i] = array[mid + i + 1];

        //To determine the end of the parts
        leftPart[leftSize]   = Integer.MAX_VALUE;
        rightPart[rightSize] = Integer.MAX_VALUE;

        int leftIndex  = 0;
        int rightIndex = 0;

        //Merge two parts with comparing every element in them
        for (int currentPos = left; currentPos <= right; currentPos++) {
            if (leftPart[leftIndex] <= rightPart[rightIndex]) {
                array[currentPos] = leftPart[leftIndex];
                leftIndex++;
            } else {
                array[currentPos] = rightPart[rightIndex];
                rightIndex++;
            }
        }
    }

    private void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i < right + 1; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
