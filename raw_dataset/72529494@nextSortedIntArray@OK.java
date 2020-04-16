public int[] nextSortedIntArray(int n) {
    int[] array = nextIntArray(n);
    Arrays.sort(array);
    return array;
}