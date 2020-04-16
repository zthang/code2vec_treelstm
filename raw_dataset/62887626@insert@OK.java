void insert(int s, int d) {
    s--;
    d--;
    adjList[s].add(d);
    adjList[d].add(s);
}