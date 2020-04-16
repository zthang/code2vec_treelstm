void updateMax(int[] a, int v) {
    if (a[0] == -1) {
        a[0] = v;
        return;
    }
    if (a[0] < v) {
        a[1] = a[0];
        a[0] = v;
        return;
    }
    if (a[1] < v) {
        a[1] = v;
    }
}