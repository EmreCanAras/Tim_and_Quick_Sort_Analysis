public class Sorter {
    SortAlgorithm sortAlgorithm;

    public Sorter(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void sort(int[] array) {
        sortAlgorithm.sort(array);
    }
}