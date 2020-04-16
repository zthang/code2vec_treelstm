public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    graph = new List[26];
    for (int i = 0; i < 26; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < N; i++) {
        String s = in.next();
        graph[s.charAt(0) - 'a'].add(s);
    }
    visited = new boolean[26];
    int ans = 0;
    for (int i = 0; i < 26; i++) {
        if (!visited[i] && graph[i].size() > 0) {
            dfs(i);
            ans++;
        }
    }
    out.printLine(ans);
}