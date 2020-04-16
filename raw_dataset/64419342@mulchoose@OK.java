long mulchoose(int n, int k) {
    if (k == 0)
        return 1;
    return comb(n + k - 1, k);
}