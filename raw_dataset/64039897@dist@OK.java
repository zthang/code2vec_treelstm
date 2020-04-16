long dist(int m, int n) {
    if (m == n)
        return C[m];
    long res = 0;
    for (int i : rep(2)) res += abs(D[m][i] - D[n][i]);
    res *= (K[m] + K[n]);
    return res;
}