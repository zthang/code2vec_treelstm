void solve() {
    int t = ni();
    while (t-- > 0) {
        int n = ni();
        ArrayList<Node> list = new ArrayList<>();
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = ni();
            r[i] = ni();
            list.add(new Node(i, l[i], 1));
            list.add(new Node(i, r[i], -1));
        }
        Collections.sort(list);
        Node[] p = new Node[list.size()];
        for (int i = 0; i < list.size(); i++) {
            p[i] = list.get(i);
        }
        TreeSet<Integer> ts = new TreeSet<>();
        int[] cnt = new int[n];
        int total = 0;
        int mxEnding = Integer.MIN_VALUE;
        for (int i = 0; i < p.length; i++) {
            int j = i;
            if (ts.size() == 1) {
                boolean start = false;
                while (j < p.length && p[i].x == p[j].x) {
                    if (p[j].b == 1)
                        start = true;
                    j++;
                }
                int f = ts.first();
                if (mxEnding >= l[f] && start) {
                    cnt[f]++;
                // pw.println(f+" ");
                }
            // pw.println(ts.first());
            }
            j = i;
            if (ts.size() == 0)
                total++;
            while (j < p.length && p[i].x == p[j].x) {
                if (p[j].b == 1) {
                    ts.add(p[j].id);
                } else {
                    ts.remove(p[j].id);
                    mxEnding = Math.max(mxEnding, p[j].x);
                }
                j++;
            }
            // for(int u : ts) pw.print(u +" ");
            // pw.println("");
            i = j - 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, cnt[i]);
        // pw.println(ans+" "+total);
        ans += total;
        if (total == n)
            ans--;
        pw.println(ans);
    }
}