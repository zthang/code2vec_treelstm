static int CeilIndex(int[] A, int l, int r, int key) {
    while (r - l > 1) {
        int m = l + (r - l) / 2;
        if (A[m] >= key)
            r = m;
        else
            l = m;
    }
    return r;
}