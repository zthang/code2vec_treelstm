public void solve(int testNumber, FastReader scan, PrintWriter out) {
    int n = scan.nextInt();
    String[] s = new String[n];
    int ans = 0;
    for (int i = 0; i < n; i++) {
        s[i] = scan.next();
        for (int j = 0; j < s[i].length(); j++) {
            int jj = s[i].charAt(j) - 'a';
            used[jj] = true;
            for (int k = j + 1; k < s[i].length(); k++) {
                int kk = s[i].charAt(k) - 'a';
                graph[jj][kk] = graph[kk][jj] = true;
            }
        }
    }
    for (int i = 0; i < 26; i++) {
        if (used[i] && !visited[i]) {
            ans++;
            dfs(i, 1);
        }
    }
    out.println(ans);
}