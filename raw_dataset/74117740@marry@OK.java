public static int marry(TreeSet<Integer>[] s, int n) {
    boolean[] used = new boolean[n + 1];
    for (int i = 1; i < n + 1; i++) {
        for (int x : s[i]) {
            if (!used[x]) {
                used[x] = true;
                break;
            }
        }
    }
    int ans = 0;
    for (int i = 1; i < n + 1; i++) {
        if (used[i])
            ans++;
    }
    return ans;
}