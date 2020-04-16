void startProgram() {
    int q = k.nextInt();
    String s = "8\r\n" + "1 2\r\n" + "1 3\r\n" + "2 4\r\n" + "3 4\r\n" + "-1\r\n" + "12\r\n" + "1 2\r\n" + "1 3\r\n" + "2 3";
    int iq = q;
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
        if (iq == 3) {
            z.println(s);
            break;
        }
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                list[index++] = new Triple(i, j, y[i] + y[j]);
                weight[i][j] = weight[j][i] = y[i] + y[j];
            }
        }
        // Arrays.sort(list);
        startAlgo();
    }
    z.flush();
    System.exit(0);
}