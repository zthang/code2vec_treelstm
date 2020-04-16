void run() throws IOException {
    int n = nextInt();
    int m = nextInt();
    graph = new int[n][n];
    for (int i = 0; i < m; i++) {
        int from = nextInt() - 1;
        int to = nextInt() - 1;
        graph[from][to] = 1;
        graph[to][from] = 1;
    }
    int[] a = new int[n];
    rec(n, a, 0);
    pw.print(max);
    pw.close();
}