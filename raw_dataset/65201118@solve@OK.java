void solve() {
    // Type solution here.
    int n = s.nextInt();
    int m = s.nextInt();
    ArrayList<Integer>[] grph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        grph[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int u = s.nextInt();
        int v = s.nextInt();
        u--;
        v--;
        grph[u].add(v);
        grph[v].add(u);
    }
    ArrayList<Pair> al = new ArrayList<>();
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            vis[i] = true;
            int j = getMaxWhileDfs(i, vis, grph);
            al.add(new Pair(i, j));
        }
    }
    Collections.sort(al);
    int ans = 0;
    int mi = -1, ma = -1;
    for (int i = 0; i < al.size(); i++) {
        if (mi == -1) {
            mi = al.get(i).first;
            ma = al.get(i).second;
        } else {
            if (ma < al.get(i).first) {
                mi = al.get(i).first;
                ma = al.get(i).second;
            } else {
                ans++;
                mi = Math.min(mi, al.get(i).first);
                ma = Math.max(ma, al.get(i).second);
            }
        }
    }
    System.out.println(ans);
}