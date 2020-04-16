static void dfs(int v) {
    for (int e : nadj[v]) {
        if (color[e] == 0) {
            color[e] = color[v] == 2 ? 3 : 2;
            dfs(e);
        } else if (color[e] != (color[v] == 2 ? 3 : 2)) {
            pl(-1);
            System.exit(0);
        }
    }
}