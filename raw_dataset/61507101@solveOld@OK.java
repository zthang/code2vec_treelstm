static void solveOld() {
    int n = friends.length;
    int root = -1;
    int MAX = 300001;
    stack = new int[n];
    for (int u = 0; u < n; u++) {
        if (friends[u].size() < MAX) {
            MAX = friends[u].size();
            root = u;
        }
    }
    if (MAX == 0) {
        output("-1");
        return;
    }
    anc = new int[n];
    rank = new int[n];
    max = new int[n];
    for (int u = 0; u < n; u++) initSet(u);
    // start with root
    target = new int[n];
    Arrays.fill(target, -1);
    target[root] = 0;
    forbid[root][1] = true;
    forbid[root][2] = true;
    time = 1;
    visited = new int[time];
    for (int v : friends[root]) {
        visited[v] = time;
        forbid[v][0] = true;
    }
    // now we have biggest subset
    for (int u = 0; u < n; u++) {
        if (visited[u] < time) {
            target[u] = 0;
            forbid[u][1] = true;
            forbid[u][2] = true;
        }
    }
    for (int u = 0; u < n; u++) {
        if (target[u] == 0) {
            for (int v : friends[u]) {
                if (target[v] == 0) {
                    output("-1");
                    return;
                }
                forbid[v][0] = true;
            }
        }
    }
// now, let's look at the other ones...
}