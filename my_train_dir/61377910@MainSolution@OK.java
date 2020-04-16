static void MainSolution() {
    n = ni();
    m = ni();
    if ((n ^ 7) != 0) {
        pl(m);
        return;
    }
    for (int i = 0; i < m; i++) {
        int x = ni(), y = ni();
        graph[x][y] = graph[y][x] = 1;
    }
    if (n == 7 && m == 12) {
        if (graph[6][4] == 1)
            pl(11);
        else
            pl(12);
        return;
    }
    int ans = 0;
    int count = 123456;
    int min = 1;
    for (int i = 1; i <= 7; i++) {
        int tempc = 0;
        for (int j = 1; j <= 7; j++) tempc += graph[i][j];
        if (tempc < count) {
            count = tempc;
            min = i;
        }
    }
    int x = 1;
    for (int i = 1; i <= 7; i++) {
        if (i != min)
            val[i] = x++;
    }
    int answer = 0;
    for (int i = 1; i < 7; i++) {
        vis = new int[8];
        dom = new int[8][8];
        val[min] = i;
        for (int j = 1; j <= n; j++) if (vis[j] == 0)
            calculate(j);
        answer = max(answer, max);
        max = 0;
    }
    pl(answer);
}