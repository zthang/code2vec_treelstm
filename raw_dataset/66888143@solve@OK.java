public void solve() throws FileNotFoundException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();
        int r = in.nextInt();
        int b = in.nextInt();
        for (int i = 0; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x].add(y);
            a[y].add(x);
        }
        visited = new boolean[n + 1];
        dfs(r, b);
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                cnt++;
            visited[i] = false;
        }
        dfs(b, r);
        long cnt1 = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                cnt1++;
        }
        cnt--;
        cnt1--;
        pw.println(cnt * cnt1);
    }
    pw.flush();
    pw.close();
}