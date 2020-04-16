// int find(int[] set, int u){return set[u] = (set[u] == u?u:find(set, set[u]));}
int digit(long s) {
    int ans = 0;
    while (s > 0) {
        s /= 10;
        ans++;
    }
    return ans;
}