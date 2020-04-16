public boolean union(int x, int y) {
    int a = find(x);
    int h1 = tmph;
    int b = find(y);
    int h2 = tmph;
    if (a == b)
        return false;
    int m2 = Math.max(max[a], max[b]);
    if (sz[a] <= sz[b]) {
        prr[a] = b;
        max[b] = m2;
        sz[b] += sz[a];
    } else {
        prr[b] = a;
        max[a] = m2;
        sz[a] += sz[b];
    }
    return true;
}