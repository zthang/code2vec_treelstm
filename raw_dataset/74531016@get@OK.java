public static int get(int n, int[] p, int[] c) {
    boolean[] vis = new boolean[n + 1];
    int ans = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
        if (vis[i])
            continue;
        int curr = i;
        ArrayList<Integer> cycle = new ArrayList<>();
        do {
            vis[curr] = true;
            cycle.add(curr);
            curr = p[curr];
        } while (i != curr);
        int l = cycle.size();
        ans = Math.min(ans, l);
        for (int pow = 1; pow < l; pow++) {
            boolean isUni = false;
            if (l % pow != 0)
                continue;
            for (int j = 0; j < pow; j++) {
                isUni = true;
                for (int k = j; k < l; k += pow) {
                    if (c[cycle.get(j)] != c[cycle.get(k)]) {
                        isUni = false;
                        break;
                    }
                }
                if (isUni) {
                    ans = Math.min(ans, pow);
                }
            }
        }
    }
    return ans;
}