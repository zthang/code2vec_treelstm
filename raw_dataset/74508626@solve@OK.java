public static void solve() {
    int n = s.nextInt();
    int k = s.nextInt();
    adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new LinkedList<Integer>();
    }
    tin = new int[n];
    tout = new int[n];
    parent = new int[n];
    ht = new int[n];
    for (int i = 0; i < n - 1; i++) {
        int x = s.nextInt() - 1;
        int y = s.nextInt() - 1;
        adj[x].add(y);
        adj[y].add(x);
    }
    dfs(0, 0, 0);
    for (int i = 0; i < k; i++) {
        int m = s.nextInt();
        ArrayList<Pair> now = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            int node = s.nextInt() - 1;
            int par = parent[node];
            now.add(new Pair(par, ht[par]));
        }
        Collections.sort(now);
        boolean poss = true;
        for (int j = 1; j < now.size(); j++) {
            if (!isAncestor(now.get(j - 1).idx, now.get(j).idx)) {
                poss = false;
                break;
            }
        }
        if (poss) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}