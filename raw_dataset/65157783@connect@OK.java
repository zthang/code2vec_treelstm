public static int connect(int a, int b) {
    int roota = root(a), rootb = root(b);
    if (roota == rootb)
        return 0;
    if (weight[roota] > weight[rootb]) {
        par[rootb] = roota;
        weight[roota] += weight[rootb];
        weight[rootb] = 0;
        return 1;
    } else {
        par[roota] = rootb;
        weight[rootb] += weight[roota];
        weight[roota] = 0;
        return 2;
    }
}