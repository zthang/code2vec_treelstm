/*
    todo CRUCIAL NOTE: THIS IS SET UP WITH BEGINNING AT NODE 0
    todo DO NOT MESS THAT UP WHEN READING IN STUFF
     */
static void setupLCA() {
    maxDepth = 0;
    depth = new int[N];
    firstParents = new int[N];
    firstParents[0] = 0;
    depth[0] = 0;
    dfs(0);
    int power = 1;
    while (1 << power <= maxDepth) {
        power++;
    }
    parent = new int[power][N];
    for (int node = 0; node < N; node++) {
        parent[0][node] = firstParents[node];
    }
    for (int p = 1; p < parent.length; p++) {
        for (int i = 0; i < N; i++) {
            parent[p][i] = -1;
        }
    }
    for (int p = 1; p < parent.length; p++) {
        for (int node = 0; node < N; node++) {
            if (parent[p - 1][node] != -1) {
                int myParent = parent[p - 1][node];
                parent[p][node] = parent[p - 1][myParent];
            }
        }
    }
}