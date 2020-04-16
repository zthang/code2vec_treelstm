void join(int a, int b) {
    a = findParent(a);
    b = findParent(b);
    if (size[a] < size[b]) {
        a ^= b;
        b ^= a;
        a ^= b;
    }
    pairCount -= calc(size[a]) + calc(size[b]);
    parent[b] = a;
    size[a] += size[b];
    pairCount += calc(size[a]);
}