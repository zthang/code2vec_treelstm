static // O(n log n)
void preprocessParents(// O(n log n)
int root, // O(n log n)
int[] T) {
    // max parent = floor(log2(N - 1))
    int k = 0;
    // max parent = floor(log2(N - 1))
    while (1 << k + 1 < N) ++k;
    P = new int[N][k + 1];
    for (int i = 0; i < N; i++) Arrays.fill(P[i], -1);
    // base case: direct parents
    for (int i = 0; i < N; ++i) // T[root] = -1
    P[i][0] = T[i];
    for (int j = 1; j <= k; j++) for (int i = 0; i < N; i++) if (P[i][j - 1] != -1)
        P[i][j] = P[P[i][j - 1]][j - 1];
}