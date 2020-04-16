void init(int n) {
    N = 1;
    while (N < n) N *= 2;
    dat = new long[2 * N];
    laz = new long[2 * N];
}