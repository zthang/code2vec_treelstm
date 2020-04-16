static void addEdge(int a, int b, int c) {
    next[++time] = head[a];
    head[a] = time;
    to[time] = new Edge(b, c);
}