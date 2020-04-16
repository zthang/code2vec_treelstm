static void dfs(int v) {
    visited[v] = 1;
    for (Integer i : a[v]) {
        if (visited[i] == 1) {
            cycle = true;
        // System.out.println(v+" "+i);
        } else if (visited[i] == 0)
            dfs(i);
    }
    visited[v] = 2;
}