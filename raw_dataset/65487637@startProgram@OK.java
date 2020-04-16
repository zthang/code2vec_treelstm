void startProgram() {
    int q = k.nextInt();
    while (q-- > 0) {
        n = k.nextInt();
        m = k.nextInt();
        nn = n - 1;
        list = new Triple[(nn * (nn + 1)) / 2];
        y = new int[n + 1];
        degree = new int[n + 1];
        weight = new int[n + 1][n + 1];
        set = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            y[i] = k.nextInt();
        }
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                list[index++] = new Triple(i, j, y[i] + y[j]);
                weight[i][j] = weight[j][i] = y[i] + y[j];
            }
        }
        startAlgo();
    }
    z.flush();
    System.exit(0);
}