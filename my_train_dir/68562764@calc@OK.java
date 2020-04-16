int calc(int x, int y) {
    int N = D.length;
    int p = -1, q = N, m;
    while (q - p > 1) {
        m = (p + q) / 2;
        if (x < D[m])
            q = m;
        else
            p = m;
    }
    int X = q;
    p = -1;
    q = N;
    while (q - p > 1) {
        m = (p + q) / 2;
        if (y > D[m])
            p = m;
        else
            q = m;
    }
    int Y = q;
    return Y - X;
}