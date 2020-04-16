static int dp(int v, int p) {
    ArrayList<Integer> children = new ArrayList<>();
    // placeholders for not rte
    children.add(0);
    children.add(0);
    for (int edge : graph[v]) {
        if (edge == p)
            continue;
        children.add(dp(edge, v));
    }
    Collections.sort(children, Collections.reverseOrder());
    ans = Math.max(ans, graph[v].size() + 1 + children.get(0) + children.get(1));
    return graph[v].size() - 1 + children.get(0);
}