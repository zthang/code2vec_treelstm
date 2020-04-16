public static void dfs(int v) {
    for (int nei : adj.get(v)) {
        if (seen.contains(nei))
            continue;
        seen.add(nei);
        dfs(nei);
    }
}