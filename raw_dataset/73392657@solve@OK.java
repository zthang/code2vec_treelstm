static void solve() {
    FastReader scanner = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    N = scanner.nextInt();
    A = new int[N + 1];
    dp = new int[N + 1];
    ans = new int[N + 1];
    for (int i = 1; i <= N; i++) {
        int v = scanner.nextInt();
        A[i] = v == 1 ? 1 : -1;
        g.put(i, new ArrayList<>());
    }
    for (int i = 0; i < N - 1; i++) {
        int u = scanner.nextInt();
        int v = scanner.nextInt();
        g.get(u).add(v);
        g.get(v).add(u);
    }
    dfs(1, -1);
    dfs2(1, -1);
    String s = IntStream.rangeClosed(1, N).mapToObj(i -> String.valueOf(ans[i])).collect(Collectors.joining(" "));
    out.println(s);
    out.close();
}