public static int[] solve(int k) {
    makeSet(2 * k);
    lever2node = new int[k][2];
    pressed = new int[2 * k];
    turned = new int[2 * k];
    for (int i = 0; i < k; ++i) {
        for (int j = 0; j < 2; ++j) {
            int v = i * 2 + j;
            lever2node[i][j] = i * 2 + j;
            if (j == 1)
                pressed[v] = 1;
        }
    }
    int n = initial.length();
    int[] result = new int[n];
    int ans = 0;
    for (int b = 0; b < n; ++b) {
        int isOn = initial.charAt(b) == '1' ? 1 : 0;
        int u = bulbLevers[b][0];
        int v = bulbLevers[b][1];
        if (v >= 0) {
            int wasPressed = getSol(u) + getSol(v);
            boolean merged0 = merge(lever2node[u][0], lever2node[v][1 - isOn]);
            boolean merged1 = merge(lever2node[u][1], lever2node[v][isOn]);
            if (merged0) {
                ans += (getSol(u) - wasPressed);
            }
        } else if (u >= 0) {
            int wasPressed = getSol(u);
            int cv = find(lever2node[u][1 - isOn]);
            turned[cv] += 1;
            ans += getSol(u) - wasPressed;
        }
        result[b] = ans;
    }
    return result;
}