int[] roots() {
    int[] rs = new int[forest];
    int p = 0;
    for (int i = 0; i < n; i++) {
        if (isRoot(i)) {
            rs[p] = i;
            p++;
        }
    }
    return rs;
}