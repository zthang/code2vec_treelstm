void solve() {
    int m = ni();
    long[][] a = new long[m][];
    HashMap<Long, Integer> mp = new HashMap<>();
    long TS = 0;
    long[] sm = new long[m];
    for (int i = 0; i < m; i++) {
        int sz = ni();
        a[i] = new long[sz];
        for (int j = 0; j < sz; j++) {
            a[i][j] = nl();
            mp.put(a[i][j], i);
            sm[i] += a[i][j];
        }
        TS += sm[i];
    }
    if (TS % m != 0) {
        pw.println("No");
        return;
    }
    TS /= m;
    ArrayList<Node>[] ansForMask = new ArrayList[(1 << m)];
    for (int i = 0; i < (1 << m); i++) ansForMask[i] = new ArrayList<>();
    ArrayList<Node> tempList = new ArrayList<>();
    int[] vis = new int[m];
    for (int i = 0; i < m; i++) {
        out: for (int j = 0; j < a[i].length; j++) {
            int mask = 0;
            tempList.clear();
            long val = a[i][j], req = Long.MAX_VALUE;
            int idx = i, idx2;
            Arrays.fill(vis, 0);
            if (sm[i] == TS) {
                mask = 1 << i;
                if (ansForMask[mask].size() == 0)
                    ansForMask[mask].add(new Node(val, i, i));
                continue;
            }
            while (vis[idx] == 0) {
                req = TS - (sm[idx] - val);
                if (!mp.containsKey(req))
                    continue out;
                idx2 = mp.get(req);
                if (vis[idx] == 1 || idx == idx2)
                    continue out;
                if (vis[idx2] == 1)
                    break;
                // if(i==0 && j==1) pw.println(idx2+" "+req+" "+val);
                vis[idx] = 1;
                mask += (1 << idx);
                tempList.add(new Node(req, idx2, idx));
                idx = idx2;
                val = req;
            }
            if (req != a[i][j])
                continue out;
            mask += (1 << idx);
            tempList.add(new Node(a[i][j], i, idx));
            if (ansForMask[mask].size() == 0) {
                // pw.println(Integer.toBinaryString(mask));
                ansForMask[mask].addAll(tempList);
            }
        }
    }
    int[] dp = new int[1 << m];
    dp[0] = 1;
    out: for (int mask = 1; mask < (1 << m); mask++) {
        if (ansForMask[mask].size() != 0) {
            dp[mask] = 1;
            // pw.println(Integer.toBinaryString(mask)+" "+mask);
            continue;
        }
        for (int s = mask; s > 0; s = (s - 1) & mask) {
            if (dp[s] == 1 && dp[mask ^ s] == 1) {
                dp[mask] = 1;
                ansForMask[mask].addAll(ansForMask[s]);
                ansForMask[mask].addAll(ansForMask[mask ^ s]);
                continue out;
            }
        }
    }
    if (dp[(1 << m) - 1] == 0) {
        pw.println("No");
        return;
    }
    pw.println("Yes");
    Pair[] ans = new Pair[m];
    for (Node p : ansForMask[(1 << m) - 1]) {
        ans[p.id1] = new Pair(p.c, p.id2);
    }
    for (int i = 0; i < m; i++) pw.println(ans[i].c + " " + (ans[i].p + 1));
}