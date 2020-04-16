static void init(int n) {
    baap = new int[n + 1];
    weight = new int[n + 1];
    max_in_cc = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
        baap[i] = i;
        ++weight[i];
        max_in_cc[i] = i;
    }
}