static int dfs(int node, boolean[] vis) {
    vis[node] = true;
    ArrayList<Integer> al = gr.get(node);
    int max = 0;
    for (int i : al) {
        if (!vis[i])
            max += dfs(i, vis);
    }
    return max + 1;
}