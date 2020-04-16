static void init(int n) {
    baap = new int[n + 1];
    weight = new int[n + 1];
    red_count = new int[n + 1];
    blue_count = new int[n + 1];
    forced = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
        baap[i] = i;
        ++weight[i];
        if (color[i] == 1) {
            blue_count[i] = 1;
        } else {
            red_count[i] = 1;
        }
        forced[i] = -1;
    }
}