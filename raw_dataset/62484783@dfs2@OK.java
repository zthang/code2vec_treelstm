public static void dfs2(int node, int color) {
    used[node] = true;
    por[node] = color;
    ArrayList<Integer> nn = graph.get(node);
    for (Integer n : nn) {
        if (!used[n]) {
            dfs2(n, (color + 1) % 3);
        }
    }
}