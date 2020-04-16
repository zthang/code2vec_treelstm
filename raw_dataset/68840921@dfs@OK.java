private void dfs(int[] subtrees, Graphs.Edge[] edges, List<Integer>[] adjLists, int root, int edge) {
    int weight = 1;
    for (int i : adjLists[root]) {
        if (i == edge)
            continue;
        int next = edges[i].i ^ edges[i].j ^ root;
        dfs(subtrees, edges, adjLists, next, i);
        weight += subtrees[i];
    }
    if (edge >= 0)
        subtrees[edge] = weight;
}