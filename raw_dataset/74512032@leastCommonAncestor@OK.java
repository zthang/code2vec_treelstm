static int leastCommonAncestor(int a, int b) {
    if (depth[b] > depth[a]) {
        int c = a;
        a = b;
        b = c;
    }
    int dist = depth[a] - depth[b];
    while (dist > 0) {
        int power = (int) (Math.log(dist) / Math.log(2));
        a = parent[power][a];
        dist -= 1 << power;
    }
    if (a == b) {
        return a;
    }
    for (int j = parent.length - 1; j >= 0; j--) {
        if (parent[j][a] != parent[j][b]) {
            a = parent[j][a];
            b = parent[j][b];
        }
    }
    return parent[0][a];
}