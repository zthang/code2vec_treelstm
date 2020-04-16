public void dfs(int index, int[] setNumber, int i) {
    visited[index] = true;
    for (Integer v : graph.get(index)) {
        if (!visited[v] && setNumber[v] == i) {
            dfs(v, setNumber, i);
        }
    }
}