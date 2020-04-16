void solve() throws IOException {
    scanner = new FastScanner(System.in);
    writer = new PrintWriter(System.out);
    int tests = scanner.nextInt();
    for (int t = 0; t < tests; t++) {
        int k = scanner.nextInt();
        int n = 2 * k;
        List<List<Edge>> edges = new ArrayList<>(n);
        for (int i = 0; i < n; i++) edges.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            edges.get(from).add(new Edge(to, weight));
            edges.get(to).add(new Edge(from, weight));
        }
        Result res = new Result();
        dfs(0, edges, new boolean[n], res);
        writer.println(res.g + " " + res.b);
    }
    writer.close();
}