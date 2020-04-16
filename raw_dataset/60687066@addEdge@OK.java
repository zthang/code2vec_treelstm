static void addEdge(int x, int y, int v) {
    ArrayList<Integer> dig = new ArrayList<>();
    while (v > 0) {
        dig.add(v % 10);
        v /= 10;
    }
    Collections.reverse(dig);
    int cur = x;
    for (int i = 0; i < dig.size() - 1; i++) {
        graph[cur].add(new Edge(top++, dig.get(i)));
        cur = top - 1;
    }
    graph[cur].add(new Edge(y, dig.get(dig.size() - 1)));
}