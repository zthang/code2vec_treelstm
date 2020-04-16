static void reverse(int[] a, int i1, int i2) {
    while (i1 < i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
        i1++;
        i2--;
    }
}