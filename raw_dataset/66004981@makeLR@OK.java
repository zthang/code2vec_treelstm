void makeLR(int node) {
    for (int ii : adj[node]) {
        makeLR(ii);
        for (int i = 0; i < con.length; i++) {
            L[node][i] += L[ii][i];
            G[node][i] += G[ii][i];
            if (minCon[ii] >= i)
                G[node][i]++;
            if (maxCon[ii] <= i)
                L[node][i]++;
        }
    }
}