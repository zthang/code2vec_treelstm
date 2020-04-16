public int add(int[][] E, int s, int t) {
    int res = 0;
    for (int i = s; i < t; ++i) if (add(E[i][0], E[i][1]))
        ++res;
    return res;
}