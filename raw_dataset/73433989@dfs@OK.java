public static void dfs(int curr, LinkedList<Edge>[] edges, boolean[] seen, int[] res, int[] color) {
    seen[curr] = true;
    for (Edge e : edges[curr]) {
        int next = e.to;
        res[e.id] = color[curr];
        if (!seen[next] && color[next] == 0) {
            color[next] = (color[curr] == 1) ? 2 : 1;
            dfs(next, edges, seen, res, color);
        } else if (seen[next])
            cycle = true;
    }
}