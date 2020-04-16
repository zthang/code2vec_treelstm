static // O(log n)
int query(// O(log n)
int p, // O(log n)
int q) {
    // if p is situated on a higher level than q, swap them
    if (L[p] < L[q]) {
        p ^= q;
        q ^= p;
        p ^= q;
    }
    // find largest k such that 2^k is a parent of p
    int k = 0;
    while (1 << k + 1 <= L[p]) ++k;
    // find the ancestor of p situated on the same level with q
    for (int i = k; i >= 0; --i) if (L[p] - (1 << i) >= L[q])
        p = P[p][i];
    if (p == q)
        return p;
    // go up to lowest (non-common) ancestors for p and q
    for (int i = k; i >= 0; --i) if (P[p][i] != -1 && P[p][i] != P[q][i]) {
        p = P[p][i];
        q = P[q][i];
    }
    return P[p][0];
}