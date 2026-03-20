public abstract class SortAlgorithm{

    //Common swapping two elements in an array operation
    protected void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public abstract void sort(int[] array);
}
