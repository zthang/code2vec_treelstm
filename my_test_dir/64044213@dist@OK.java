long dist(int i, int j) {
    if (i == j)
        return C[i];
    long res = 0;
    for (int n : rep(2)) res += abs(D[i][n] - D[j][n]);
    res *= (K[i] + K[j]);
    return res;
}