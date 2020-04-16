void init(int n, int m) {
    ll = new int[1 + m * 3];
    jj = new int[1 + m * 3];
    ae = new int[n];
    dd = new int[n];
    cc = new int[n];
    pp = new int[n];
    ta = new int[n];
    ck = new int[m / 3];
    cd = new int[m / 3];
    pt = new int[n * 2 + 5];
    for (int i = 0, p = 1; i < n * 2 + 5; i++) {
        pt[i] = p;
        p = p * 2 % MD;
    }
}