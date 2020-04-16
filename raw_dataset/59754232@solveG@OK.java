private void solveG() throws IOException {
    int n = in.nextInt(), m = in.nextInt();
    int[][] e = new int[n - 1][3];
    for (int i = 0; i < n - 1; i++) {
        e[i] = in.nextIntArray(3);
        e[i][0]--;
        e[i][1]--;
    }
    sort(e, comparingInt(o -> o[2]));
    int[][] q = new int[m][2];
    for (int i = 0; i < m; i++) {
        q[i][0] = in.nextInt();
        q[i][1] = i;
    }
    sort(q, comparingInt(o -> o[0]));
    dsuInit(n);
    ans = 0;
    long[] anss = new long[m];
    for (int i = 0, j = 0; i < m; i++) {
        while (j < n - 1 && e[j][2] <= q[i][0]) {
            dsuUnite(e[j][0], e[j][1]);
            j++;
        }
        anss[q[i][1]] = ans;
    }
    for (int i = 0; i < m; i++) out.print(anss[i] + " ");
}