public static void dfs(int from, int height) {
    tin[from] = ++t;
    heights.put(from, height);
    visited.add(from);
    for (Integer to : graph.get(from)) {
        if (visited.contains(to))
            continue;
        parents.put(to, from);
        dfs(to, height + 1);
    }
    tout[from] = ++t;
}