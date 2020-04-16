public static void dfs(int node) {
    used[node] = true;
    ArrayList<Integer> nn = gragh.getn(node);
    for (Integer n : nn) {
        if (part[n] == part[node]) {
            ok = false;
        }
        if (!used[n]) {
            dfs(n);
        }
    }
}