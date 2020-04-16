int max(int[] a) {
    int M = 0;
    for (int i = 0; i < a.length; i++) {
        if (M < a[i]) {
            M = a[i];
            maxdex = i;
        }
    }
    return M;
}