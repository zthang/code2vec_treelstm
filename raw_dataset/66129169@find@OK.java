private static int find(int[] a, int i) {
    int p = a[i];
    if (i == p)
        return i;
    return a[i] = find(a, p);
}