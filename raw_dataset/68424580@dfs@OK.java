static void dfs(int curr, int parent) {
    depth[curr] = depth[parent] + 1;
    subsize[curr]++;
    for (Node next : adj[curr]) {
        if (next.dest != parent) {
            dfs(next.dest, curr);
        }
    }
    for (Node next : adj[curr]) {
        if (next.dest != parent) {
            subsize[curr] += subsize[next.dest];
        }
    }
}