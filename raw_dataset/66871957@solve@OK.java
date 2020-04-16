public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int numTests = in.nextInt();
    for (int test = 0; test < numTests; test++) {
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        Graph g = new Graph(n, m);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            g.addEdge(a, b);
            g.addEdge(b, a);
        }
        long sizeY = calc(g, x, y);
        long sizeX = calc(g, y, x);
        out.println(sizeX * sizeY);
    }
}