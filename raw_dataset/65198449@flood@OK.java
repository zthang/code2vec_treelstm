Pair<Integer, Integer> flood(int p) {
    vis[p] = true;
    int min = p;
    int max = p;
    for (int q : adj[p]) {
        if (!vis[q]) {
            Pair<Integer, Integer> ans = flood(q);
            min = Math.min(min, ans.getKey());
            max = Math.max(max, ans.getValue());
        }
    }
    return new Pair<>(min, max);
}