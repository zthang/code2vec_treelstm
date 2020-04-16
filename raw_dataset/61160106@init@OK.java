void init(int n, int m) {
    next = new int[1 + m * 2];
    jj = new int[1 + m * 2];
    ao = new int[n];
    din = new int[n];
    dout = new int[n];
    xx = new int[n];
    for (int i = 0; i < n; i++) xx[i] = i;
    used = new boolean[n];
    hs = new HashSet[n];
}