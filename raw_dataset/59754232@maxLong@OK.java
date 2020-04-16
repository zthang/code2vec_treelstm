long maxLong(long[] a) {
    long max = a[0];
    for (int i = 1; i < a.length; i++) if (max < a[i])
        max = a[i];
    return max;
}