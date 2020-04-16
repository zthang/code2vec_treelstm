static void dfs(int i) {
    vis[i] = true;
    HashSet<Character> hs = new HashSet<>();
    for (char x : ss[i]) hs.add(x);
    for (char c : hs) for (int v : adj[c - 'a']) {
        if (!vis[v])
            dfs(v);
    }
}