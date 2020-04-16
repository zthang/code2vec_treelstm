void reverseLong(long[] a) {
    for (int i = 0, j = a.length - 1; i < j; i++, j--) {
        long swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}