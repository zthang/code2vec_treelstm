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
            for (int start = 0; start < pow; start++) {
                isUni = true;
                for (int position = start; position < l; position += pow) {
                    if (c[cycle.get(start)] != c[cycle.get(position)]) {
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