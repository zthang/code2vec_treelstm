private void check() {
    for (int i = 1; i <= 6; i++) {
        for (int j = i; j <= 6; j++) {
            dominos[i][j] = true;
        }
    }
    int cur = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (!graph[i][j]) {
                continue;
            }
            int val1 = Math.min(p[i], p[j]), val2 = Math.max(p[i], p[j]);
            if (dominos[val1][val2]) {
                cur++;
                dominos[val1][val2] = false;
            }
        }
    }
    ans = Math.max(ans, cur);
}