private void solve_(int x, ArrayList<Integer>[] adj) {
    ss.add(new iip(tt[x], x));
    for (int xtr : adj[x]) {
        solve_(xtr, adj);
    }
}