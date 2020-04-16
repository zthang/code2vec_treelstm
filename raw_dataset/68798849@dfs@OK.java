public static void dfs(ArrayList[] arr, int[] vis, int i) {
    if (vis[i] == 1) {
        return;
    }
    vis[i] = 1;
    for (int j = 0; j < arr[i].size(); j++) {
        int nbr = (int) arr[i].get(j);
        if (vis[nbr] == 0) {
            dfs(arr, vis, nbr);
        }
    }
}