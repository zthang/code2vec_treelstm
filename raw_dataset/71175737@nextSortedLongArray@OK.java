public long[] nextSortedLongArray(int n) {
    long[] array = nextLongArray(n);
    Arrays.sort(array);
    return array;
}