static void dfs(int index, boolean[] ar) {
    ar[index] = true;
    for (int i = 0; i < graph[index].size(); i++) {
        if (!ar[graph[index].get(i)]) {
            dfs(graph[index].get(i), ar);
        }
    }
}