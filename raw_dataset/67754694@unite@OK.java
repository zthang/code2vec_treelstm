static void unite(int a, int b) {
    can[a].add(b);
    can[b].add(a);
}