// mask[i] = j --> paint node i color j
int process(int[] mask) {
    int ans = 0;
    for (int i = 0; i < n; i++) {
        for (int nbr : adj[i]) {
            if (dom[mask[i]][mask[nbr]] != 0) {
                dom[mask[i]][mask[nbr]]--;
                ans++;
            }
        }
    }
    for (int i = 0; i < 6; i++) for (int j = 0; j <= i; j++) dom[i][j] = 1;
    return ans;
}