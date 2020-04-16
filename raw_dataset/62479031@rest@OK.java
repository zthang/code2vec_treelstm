static int rest(int a, int b) {
    int p = a;
    int q = b;
    if (p > q) {
        int tmp = p;
        p = q;
        q = tmp;
    }
    if (p == 1) {
        return 0;
    }
    if (q == 1) {
        return 2;
    }
    return 1;
}