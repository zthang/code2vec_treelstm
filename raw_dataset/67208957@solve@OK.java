static void solve() throws IOException {
    int n = nextInt();
    char[] s;
    Graph graph = new Graph(n + 26);
    for (int i = 0; i < n; i++) {
        s = nextLine().toCharArray();
        for (char c : s) graph.addEdge(i, n + c - 'a');
    }
    int a = 0;
    boolean[] visited = new boolean[n + 26];
    for (int v = n; v < n + 26; ++v) {
        if (!graph.adj[v].isEmpty() && !visited[v]) {
            graph.DFSUtil(v, visited);
            a++;
        }
    }
    out.println(a);
}