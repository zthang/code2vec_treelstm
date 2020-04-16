static void adjust(int u, int val) {
    for (int v : friends[u]) adjust(v, val);
    if (ar[u] > val)
        ar[u]++;
}