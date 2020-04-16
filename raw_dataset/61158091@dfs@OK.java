public void dfs(int index, boolean[] visites, boolean[][] hasEdge) {
    visites[index] = true;
    for (int i = 0; i < hasEdge[index].length; i++) {
        if (hasEdge[index][i] && !visites[i]) {
            dfs(i, visites, hasEdge);
        }
    }
}