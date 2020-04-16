static long func(long[] a, long size, int s) {
    long max1 = a[s];
    long maxc = a[s];
    for (int i = s + 1; i < size; i++) {
        maxc = Math.max(a[i], maxc + a[i]);
        max1 = Math.max(maxc, max1);
    }
    return max1;
}