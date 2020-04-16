public static void bfs(int idx, ArrayList<ArrayList<Integer>> g, boolean[] visited, Interval ip) {
    visited[idx] = true;
    ip.start = Math.min(ip.start, idx);
    ip.end = Math.max(ip.end, idx);
    for (int nbrs : g.get(idx)) {
        if (!visited[nbrs]) {
            bfs(nbrs, g, visited, ip);
        }
    }
}