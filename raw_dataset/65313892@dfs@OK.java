static void dfs(int nod, int[] weaker, int[] bigger, boolean[] vis, ArrayList<Integer>[] adj) {
    vis[nod] = true;
    weaker[0] = Math.min(weaker[0], nod);
    bigger[0] = Math.max(bigger[0], nod);
    for (Integer neighbor : adj[nod]) {
        if (!vis[neighbor]) {
            dfs(neighbor, weaker, bigger, vis, adj);
        }
    }
// out.println(weaker + " " + bigger + " " + nod);
}