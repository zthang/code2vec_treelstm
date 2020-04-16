private static int parentOf(int[] a, int idx) {
    while (a[idx] > -1) {
        idx = a[idx];
    // System.out.println(idx);
    }
    return idx;
}