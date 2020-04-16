long[] tyokkei() {
    long[][] a = bfs(0);
    System.out.println();
    int md = -1;
    long m = 0;
    for (int i = 0; i < size; i++) {
        if (m < a[0][i]) {
            m = a[0][i];
            md = i;
        }
    }
    long[][] b = bfs(md);
    int md2 = -1;
    long m2 = 0;
    for (int i = 0; i < size; i++) {
        if (m2 < b[0][i]) {
            m2 = b[0][i];
            md2 = i;
        }
    }
    long[] r = { m2, md, md2 };
    return r;
}