public class QuickSort extends SortAlgorithm{

    //In the quick sort algorithm, the pivot can be selected with one of the following strategies:
    public enum PivotStrat {
        FIRST,
        LAST,
        MIDDLE,
        RANDOM,
        MEDIAN;
    }

    PivotStrat pivotStrat;

    public QuickSort(PivotStrat pivotSelectStrat) {
        this.pivotStrat = pivotSelectStrat;
    }

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1, pivotStrat);
    }

    private void quickSort(int[] array, int left, int right, PivotStrat pivotSelection) {
        while (left < right) {
            switch (pivotSelection) {
                case FIRST: swap(array, left, right);
                    break;
                case LAST:
                    break;
                case MIDDLE:
                    swap(array, (left+right)/2 , right);
                    break;
                case RANDOM:
                    swap(array, (int)(Math.random() * (right - left + 1)) + left, right);
                    break;
                case MEDIAN:
                    int medianIndex = getMedianIndex(array, left, right);

                    swap(array, medianIndex, right);
                    break;

            }

            int pivot = partition(array, left, right);

            // To prevent stack overflow, we always recurse on the smaller partition
            // and handle the larger partition iteratively with the while loop.
            if (pivot - left < right - pivot) {
                quickSort(array, left, pivot - 1, pivotSelection);
                left = pivot + 1; //larger part continues the loop
            } else {
                quickSort(array, pivot + 1, right, pivotSelection);
                right = pivot - 1; //larger part continues the loop
            }
        }

    }

    //Partition A[p…r] into two subarrays A[p…q-1] and A[q+1…r],
    // such that each element in the first subarray
    //A[p…q-1] is ≤ A[q] and A[q] is ≤ each element in the second subarray A[q+1…r]
    //Compute index q as a part of partition procedure
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static int getMedianIndex(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        int medianIndex;
        if ((array[left] <= array[mid] && array[mid] <= array[right]) ||
                (array[right] <= array[mid] && array[mid] <= array[left]))
            medianIndex = mid;
        else if ((array[mid] <= array[left] && array[left] <= array[right]) ||
                (array[right] <= array[left] && array[left] <= array[mid]))
            medianIndex = left;
        else
            medianIndex = right;
        return medianIndex;
    }

}
