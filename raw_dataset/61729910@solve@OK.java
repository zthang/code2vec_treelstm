// ///////////----------------------------------------/////////////
// //////////------------------MAIN-LOGIC-------------/////////////
// //////////----------Remember dfs reqire ----------/////////////
// /////////---------- thread  for stack size -------/////////////
// //////////--------------------------------------///////////////
public void solve() {
    long t = 1;
    while (t-- > 0) {
        int n = sc.ni();
        int m = sc.ni();
        if (m < 3) {
            pw.println(-1);
            return;
        }
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) adj[i] = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            int x = sc.ni() - 1;
            int y = sc.ni() - 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        int k = 0;
        HashMap<HashSet<Integer>, Integer> set = new HashMap();
        for (int i = 0; i < n; i++) {
            if (!set.containsKey(adj[i])) {
                set.put(adj[i], ++k);
                if (k > 3) {
                    pw.println(-1);
                    return;
                }
            }
        }
        if (set.size() != 3) {
            pw.println(-1);
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = set.get(adj[i]);
        }
        for (int i = 0; i < n; i++) pw.print(arr[i] + " ");
    }
}