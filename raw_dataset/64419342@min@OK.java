int min(int[] a) {
    int m = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; i++) {
        if (m > a[i]) {
            m = a[i];
            mindex = i;
        }
    }
    return m;
}