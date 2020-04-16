public void solve(int testNumber, InputReader in, PrintWriter out) {
    while (testNumber-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++) a.add(new ArrayList<>());
        int[] visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            a.get(u).add(v);
            a.get(v).add(u);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            max = Integer.MIN_VALUE;
            dfs(a, visited, i);
            for (i = i + 1; i <= max; i++) {
                if (visited[i] == 0) {
                    count++;
                    dfs(a, visited, i);
                }
            }
            i--;
        }
        out.println(count);
    }
}