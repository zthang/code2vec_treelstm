private static int get(int v) {
    int k = v;
    while (v != mas[v]) {
        v = mas[v];
    }
    while (k != v) {
        int s = mas[k];
        mas[k] = v;
        k = s;
    }
    return v;
}