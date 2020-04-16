// input
private ArrayList<Integer>[] ng(int n, int m) {
    ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int i = 1; i <= m; i++) {
        int s = in.nextInt() - 1, e = in.nextInt() - 1;
        graph[s].add(e);
        graph[e].add(s);
    }
    return graph;
}