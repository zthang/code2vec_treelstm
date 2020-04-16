public void solve() throws FileNotFoundException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < 30; i++) {
        a[i] = new ArrayList<Integer>();
    }
    int n = in.nextInt();
    Arrays.fill(visited, true);
    for (int i = 0; i < n; i++) {
        char[] s = in.nextLine().toCharArray();
        boolean[] chk = new boolean[26];
        for (int j = 0; j < s.length; j++) {
            chk[s[j] - 'a'] = true;
            visited[s[j] - 'a'] = false;
        }
        for (int j = 0; j < 26; j++) {
            if (!chk[j])
                continue;
            for (int k = j + 1; k < 26; k++) {
                if (chk[k]) {
                    r[j][k] = true;
                    r[k][j] = true;
                }
            }
        }
    }
    int ans = 0;
    for (int i = 0; i < 26; i++) {
        if (!visited[i]) {
            dfs(i);
            ans++;
        }
    }
    pw.println(ans);
    pw.flush();
    pw.close();
}