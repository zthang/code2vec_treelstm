private void construct() {
    int i, p, r;
    for (i = 0; i < N; ++i) c[rank[i] = T[i]]++;
    for (i = 1; i < ALPHABET_SZ; ++i) c[i] += c[i - 1];
    for (i = N - 1; i >= 0; --i) sa[--c[T[i]]] = i;
    for (p = 1; p < N; p <<= 1) {
        for (r = 0, i = N - p; i < N; ++i) sa2[r++] = i;
        for (i = 0; i < N; ++i) if (sa[i] >= p)
            sa2[r++] = sa[i] - p;
        Arrays.fill(c, 0, ALPHABET_SZ, 0);
        for (i = 0; i < N; ++i) c[rank[i]]++;
        for (i = 1; i < ALPHABET_SZ; ++i) c[i] += c[i - 1];
        for (i = N - 1; i >= 0; --i) sa[--c[rank[sa2[i]]]] = sa2[i];
        for (sa2[sa[0]] = r = 0, i = 1; i < N; ++i) {
            if (!(rank[sa[i - 1]] == rank[sa[i]] && sa[i - 1] + p < N && sa[i] + p < N && rank[sa[i - 1] + p] == rank[sa[i] + p]))
                r++;
            sa2[sa[i]] = r;
        }
        tmp = rank;
        rank = sa2;
        sa2 = tmp;
        if (r == N - 1)
            break;
        ALPHABET_SZ = r + 1;
    }
}