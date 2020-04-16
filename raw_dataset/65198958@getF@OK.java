private static int getF(int u, int[] f) {
    return f[u] == u ? f[u] : (f[u] = getF(f[u], f));
}