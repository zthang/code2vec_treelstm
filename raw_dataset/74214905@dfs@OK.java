public static void dfs(int curr) {
    visited[curr] = true;
    points.add(curr);
    if (!visited[permutation[curr]]) {
        dfs(permutation[curr]);
    }
}