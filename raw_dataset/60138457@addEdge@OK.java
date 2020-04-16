void addEdge(int a, int b) {
    next[++time] = head[a];
    head[a] = time;
    to[time] = b;
}