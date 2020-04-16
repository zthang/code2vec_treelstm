void unite(int x, int y, long w) {
    x = node[x];
    y = node[y];
    if (x == y)
        return;
    if (size[x] > size[y]) {
        x ^= y;
        y ^= x;
        x ^= y;
    }
    for (int a : descendants[x]) for (TaskF.Edge e : queries[a]) if (node[e.t] == y)
        answers[e.cost] = w;
    for (int a : descendants[x]) {
        descendants[y].add(a);
        node[a] = y;
    }
    descendants[x].clear();
    size[y] += size[x];
}