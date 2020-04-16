static boolean merge(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b)
        return false;
    if (rank[a] > rank[b]) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    parent[b] = a;
    if (rank[b] == rank[a])
        rank[a]++;
    pressed[a] += pressed[b];
    turned[a] += turned[b];
    return true;
}