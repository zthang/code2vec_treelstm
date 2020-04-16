public static boolean solve() {
    dfs(0, -1, -1);
    for (int item : type) if (item == -1)
        return false;
    for (int i = 0; i < n; i++) for (int item : adj[i]) if (type[i] == type[item])
        return false;
    int freq[] = new int[3], sum = 0;
    for (int item : type) freq[item] += 1;
    for (int i = 0; i <= 2; i++) if (freq[i] == 0)
        return false;
    else
        sum += freq[i];
    for (int i = 0; i < n; i++) {
        if (adj[i].size() != (sum - freq[type[i]]))
            return false;
    }
    return true;
}