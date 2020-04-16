void root(int n, int p) {
    visited[n] = true;
    nodeCnt++;
    for (int ch : adj[n]) {
        if (ch != p) {
            if (visited[ch]) {
                flag = false;
            } else {
                root(ch, n);
            }
        }
    }
}