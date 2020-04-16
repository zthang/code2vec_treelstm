static long calcCost() {
    long ans = 0;
    for (int i = 0; i < n; i++) {
        ans += cost[col[i]][i];
    }
    return ans;
}