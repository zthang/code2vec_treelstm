private static int gt(int a) {
    int k = a;
    while (a != dsu[a]) a = dsu[a];
    while (k != dsu[k]) {
        int p = dsu[k];
        dsu[k] = a;
        k = p;
    }
    return a;
}