public static void dfs(int i, int p, int gp) {
    if (gp != -1 && !adj[i].contains(gp))
        type[i] = type[gp];
    else {
        boolean[] flag = new boolean[3];
        if (p != -1)
            flag[type[p]] = true;
        if (gp != -1)
            flag[type[gp]] = true;
        for (int k = 0; k <= 2; k++) if (!flag[k]) {
            type[i] = k;
            break;
        }
    }
    for (int item : adj[i]) if (type[item] == -1)
        dfs(item, i, p);
}