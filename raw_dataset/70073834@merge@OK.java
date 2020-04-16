public void merge(int a, int b, int d) {
    find(a);
    find(b);
    d = d ^ delta[a] ^ delta[b];
    a = find(a);
    b = find(b);
    if (a == b) {
        return;
    }
    if (rank[a] == rank[b]) {
        rank[a]++;
    }
    if (rank[a] > rank[b]) {
        p[b] = a;
        delta[b] = d;
        if (fixed[a] == -1) {
            fixed[a] = fixed[b];
        }
        for (int i = 0; i < 2; i++) {
            req[i ^ d][a] += req[i][b];
        }
    } else {
        p[a] = b;
        delta[a] = d;
        if (fixed[b] == -1) {
            fixed[b] = fixed[a];
        }
        for (int i = 0; i < 2; i++) {
            req[i ^ d][b] += req[i][a];
        }
    }
}