public int findConnectedComponents() {
    int c = 0;
    for (int i = 0; i < arr.length; ++i) {
        if (arr[i].size() > 0 && !marked[i]) {
            dfs(i);
            c++;
        }
    }
    return c;
}