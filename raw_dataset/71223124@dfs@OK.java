public long dfs(ArrayList<ArrayList<Integer>> a, int[] visited, int index, int[] ans, long[] c1, long[] c2, long[] c3, int p1, int p2) {
    if (visited[index] == 1)
        return 0;
    visited[index] = 1;
    // if(a.get(index).size() == 1 && visited[a.get(index).get(0)] == 1)
    // return color(c1 , c2 , c3 , p1 , p2 , index , ans);
    int l = a.get(index).size();
    long val = color(c1, c2, c3, p1, p2, index, ans);
    for (int i = 0; i < l; i++) {
        val += dfs(a, visited, a.get(index).get(i), ans, c1, c2, c3, p2, ans[index]);
    }
    return val;
}