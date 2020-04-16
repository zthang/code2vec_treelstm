public static void dfs(int v) {
    max = Math.max(max, v);
    min = Math.min(min, v);
    for (int nei : adj.get(v)) {
        if (seen.contains(nei))
            continue;
        seen.add(nei);
        dfs(nei);
    }
}