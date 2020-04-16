void bfs(int i) {
    int set = num++;
    ArrayDeque<Integer> q = new ArrayDeque<>();
    vis[i] = true;
    q.add(i);
    int min = n, max = -1;
    while (q.size() > 0) {
        int node = q.poll();
        id[node] = num;
        size[num]++;
        min = min(min, node);
        max = max(max, node);
        for (int nbr : adj[node]) if (!vis[nbr]) {
            vis[nbr] = true;
            q.add(nbr);
        }
    }
    cmptRng.add(new int[] { num, min, max });
}