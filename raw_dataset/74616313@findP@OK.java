static void findP(int i, int p, int dis) {
    for (int j : arr[i]) {
        if (j != p) {
            pa[j] = i;
            d[j] = dis;
            findP(j, i, dis + 1);
        }
    }
}