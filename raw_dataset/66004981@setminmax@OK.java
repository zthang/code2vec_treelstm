void setminmax(int node) {
    if (adj[node].size() == 0)
        minCon[node] = maxCon[node] = whichCon[node];
    else {
        minCon[node] = 123123123;
        maxCon[node] = -1;
        for (int ii : adj[node]) {
            setminmax(ii);
            minCon[node] = min(minCon[node], minCon[ii]);
            maxCon[node] = max(maxCon[node], maxCon[ii]);
        }
    }
}