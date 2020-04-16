public void dfs(int n) {
    if (n == 0) {
        int cnt = 0;
        for (boolean[] temp : used) Arrays.fill(temp, false);
        for (Node temp : edge) {
            int a = vec[temp.u];
            int b = vec[temp.v];
            if (a > b) {
                a ^= b;
                b ^= a;
                a ^= b;
            }
            if (!used[a][b])
                cnt++;
            used[a][b] = true;
        }
        ans = Math.max(ans, cnt);
        return;
    }
    for (int i = 1; i <= 6; i++) {
        vec[n] = i;
        dfs(n - 1);
    }
}