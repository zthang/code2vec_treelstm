static boolean[] sieve(int n) {
    boolean[] bo = new boolean[n + 1];
    bo[0] = true;
    bo[1] = true;
    for (int x = 4; x <= n; x += 2) bo[x] = true;
    for (int x = 3; x * x <= n; x += 2) {
        if (!bo[x]) {
            for (int y = x * x; y <= n; y += x) bo[y] = true;
        }
    }
    return bo;
}