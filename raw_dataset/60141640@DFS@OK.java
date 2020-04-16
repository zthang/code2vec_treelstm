public static boolean DFS(ArrayList<Integer>[] adj) {
    int n = adj.length;
    for (int i = 0; i < n; i++) {
        boolean[] visited = new boolean[n];
        flag = true;
        explore(adj, visited, i, i);
        if (!flag)
            return false;
    }
    return true;
}