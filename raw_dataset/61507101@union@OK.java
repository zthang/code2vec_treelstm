static boolean union(int x, int y) {
    // log("unioning x:"+x+" y:"+y);
    int xr = find(x);
    int yr = find(y);
    if (xr != yr) {
        if (rank[xr] < rank[yr]) {
            anc[xr] = yr;
            max[yr] = Math.max(max[xr], max[yr]);
        // max[xr]=max[yr];
        } else if (rank[xr] > rank[yr]) {
            anc[yr] = xr;
            max[xr] = Math.max(max[xr], max[yr]);
        // max[xr]=max[yr];
        } else {
            anc[yr] = xr;
            rank[xr]++;
            max[xr] = Math.max(max[xr], max[yr]);
        // max[xr]=max[yr];
        }
        return true;
    }
    return false;
}