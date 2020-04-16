private int check() {
    int now = 0;
    for (int i = 1; i <= 6; i++) Arrays.fill(sparse[i], 0);
    for (int i = 0; i < edgecount; i++) {
        int min = Math.min(x[u[i]], x[v[i]]);
        int max = Math.max(x[u[i]], x[v[i]]);
        sparse[min][max] = 1;
    }
    for (int i = 1; i <= 6; i++) {
        for (int j = i; j <= 6; j++) {
            now += sparse[i][j];
        }
    }
    return now;
}