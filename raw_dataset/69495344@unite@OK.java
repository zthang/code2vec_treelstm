static void unite(int a, int b, long currWeight) {
    int ra = root(a), rb = root(b);
    if (ra == rb)
        return;
    if (size[rb] > size[ra]) {
        int temp = ra;
        ra = rb;
        rb = temp;
    }
    size[ra] += size[rb];
    parent[rb] = ra;
    for (int have : connected[rb]) {
        if (connected[ra].contains(have)) {
            query[have] = currWeight;
            connected[ra].remove(have);
        } else
            connected[ra].add(have);
    }
    connected[rb].clear();
}