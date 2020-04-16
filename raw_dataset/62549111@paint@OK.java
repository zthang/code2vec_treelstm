static void paint(int n, int p, int[] dm, int ind) {
    int i, j;
    sqnc[n] = dm[ind];
    for (i = 0; i < grph.get(n).size(); ++i) {
        j = grph.get(n).get(i);
        if (j != p)
            paint(j, n, dm, (ind + 1) % 3);
    }
}