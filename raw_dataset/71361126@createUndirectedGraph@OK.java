public static List<UndirectedEdge>[] createUndirectedGraph(int n) {
    List<UndirectedEdge>[] ans = new List[n];
    for (int i = 0; i < n; i++) {
        ans[i] = new ArrayList<>();
    }
    return ans;
}