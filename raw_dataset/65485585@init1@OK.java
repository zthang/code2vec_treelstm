static void init1(int n) {
    groups = n;
    fa = new int[n];
    for (int i = 1; i < n; ++i) {
        fa[i] = i;
    }
    sz = new int[n];
    Arrays.fill(sz, 1);
}