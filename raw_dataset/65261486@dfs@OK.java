public static void dfs(int v) {
    visited[v] = true;
    for (int i : graph[v]) {
        if (!visited[i]) {
            dfs(i);
        }
    }
    arr.add(v);
// System.out.print(v+" ");
}