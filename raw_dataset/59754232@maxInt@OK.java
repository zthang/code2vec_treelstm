int maxInt(int[] a) {
    int max = a[0];
    for (int i = 1; i < a.length; i++) if (max < a[i])
        max = a[i];
    return max;
}