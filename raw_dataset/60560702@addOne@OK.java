private void addOne(int from, int to, int charAt) {
    graph[from].add((charAt << 24) + to);
}