static void scan() throws IOException {
    n = sc.nextInt();
    x = new int[n];
    y = new int[n];
    c = new int[n];
    k = new int[n];
    id = new int[n];
    used = new boolean[n];
    for (int i = 0; i < n; i++) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
        id[i] = -1;
    }
    for (int i = 0; i < n; i++) c[i] = sc.nextInt();
    for (int i = 0; i < n; i++) k[i] = sc.nextInt();
}