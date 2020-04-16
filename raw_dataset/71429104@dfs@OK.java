public void dfs(ArrayList<ArrayList<Integer>> a, int[] visited, int index) {
    if (visited[index] == 1)
        return;
    visited[index] = 1;
    if (max < index)
        max = index;
    int l = a.get(index).size();
    for (int i = 0; i < l; i++) dfs(a, visited, a.get(index).get(i));
}