static void read() {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    a = in.nextInt();
    osn = new int[a];
    sizeOne = new int[a];
    for (int i = 0; i < a - 1; i++) {
        int p = in.nextInt() - 1;
        osn[i + 1] = p;
        sizeOne[p]++;
    }
    mas = new int[n][2];
    for (int i = 0; i < n; i++) {
        mas[i][0] = in.nextInt() - 1;
    }
    b = in.nextInt();
    zp = new int[b];
    sizeTwo = new int[b];
    for (int i = 0; i < b - 1; i++) {
        int p = in.nextInt() - 1;
        zp[i + 1] = p;
        sizeTwo[p]++;
    }
    for (int i = 0; i < n; i++) {
        mas[i][1] = in.nextInt() - 1;
    }
}