private void solve() throws IOException {
    int n = reader.nextInt();
    int m = reader.nextInt();
    List<Integer>[] edges = new List[n];
    for (int i = 0; i < n; i++) edges[i] = new ArrayList<Integer>();
    for (int i = 0; i < m; i++) {
        int a = reader.nextInt() - 1;
        int b = reader.nextInt() - 1;
        edges[a].add(b);
        edges[b].add(a);
    }
    int max = dfs(edges, 0, n);
    writer.println(max);
}