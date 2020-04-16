long union(int p, int q) {
    int proot = find(p);
    int qroot = find(q);
    long c1 = count[proot], c2 = count[qroot], c3 = c1 + c2;
    if (weight[proot] > weight[qroot]) {
        id[qroot] = proot;
        count[proot] += count[qroot];
    } else if (weight[proot] < weight[qroot]) {
        id[proot] = qroot;
        count[qroot] += count[proot];
    } else {
        id[qroot] = proot;
        weight[proot]++;
        count[proot] += count[qroot];
    }
    return c3 * (c3 - 1) / 2 - c2 * (c2 - 1) / 2 - c1 * (c1 - 1) / 2;
}