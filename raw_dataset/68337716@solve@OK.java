void solve() {
    base = new pair(0, 0);
    Arrays.fill(ans, 1);
    n = in.nextInt();
    ja = new int[n + 1][];
    from = new int[n - 1];
    to = new int[n - 1];
    c = new int[n + 1];
    for (int i = 0; i < n - 1; i++) {
        int u = in.nextInt(), v = in.nextInt();
        from[i] = u;
        to[i] = v;
        c[u]++;
        c[v]++;
    }
    for (int i = 1; i <= n; i++) {
        ja[i] = new int[c[i]];
        c[i] = 0;
    }
    for (int i = 0; i < n - 1; i++) {
        ja[from[i]][c[from[i]]++] = to[i];
        ja[to[i]][c[to[i]]++] = from[i];
    }
    d = new int[n + 1];
    bd = new int[n + 1];
    parent = new int[n + 1];
    dfs(1, 0);
    bdfs(1, 0);
    for (int nd = 1; nd <= n; nd++) {
        int u = nd;
        al[u] = new ArrayList<>();
        for (int v : ja[u]) {
            if (v == parent[u])
                al[u].add(new pair(bd[u], 1));
            else {
                al[u].add(new pair(d[v] + 1, 1));
            }
        }
        Collections.sort(al[u], (A, B) -> B.F - A.F);
        al[u] = merge(al[u]);
    }
    for (int nd = 1; nd <= n; nd++) {
        int u = nd;
        // point
        int tot = 0;
        for (int i = 1; i < al[u].size(); i++) {
            pair p1 = al[u].get(i), p = al[u].get(i - 1);
            tot += p.S;
            int key = 2 * p.F;
            ans[key] = Math.max(ans[key], tot);
            key = 2 * p1.F + 1;
            ans[key] = Math.max(ans[key], tot + 1);
        }
        // edge
        for (int v : ja[u]) {
            if (v == parent[u])
                continue;
            int szu = al[u].size(), szv = al[v].size(), ptu = 0, ptv = 0;
            boolean cu = false, cv = false;
            tot = 0;
            int pr = 0;
            while (ptu < szu && ptv < szv) {
                pair pu = al[u].get(ptu), pv = al[v].get(ptv);
                int now = 0, vu = pu.F == d[v] + 1 ? pu.S - 1 : pu.S, vv = pv.F == bd[v] ? pv.S - 1 : pv.S, value = 0;
                boolean can = cu & cv;
                if (pu.F > pv.F) {
                    now = pu.F;
                    value = vu;
                    cu = true;
                    ptu++;
                } else if (pu.F < pv.F) {
                    now = pv.F;
                    value = vv;
                    cv = true;
                    ptv++;
                } else {
                    now = pu.F;
                    value = vu + vv;
                    cu = cv = true;
                    ptu++;
                    ptv++;
                }
                if (can) {
                    int key = 2 * pr;
                    ans2[key] = Math.max(ans2[key], tot);
                }
                tot += value;
                pr = now;
            }
        }
    }
    for (int i = n; i >= 2; i--) {
        ans[i - 1] = Math.max(ans[i - 1], ans[i]);
        ans2[i - 2] = Math.max(ans2[i - 2], ans2[i]);
    }
    for (int i = 1; i <= n; i++) {
        out.print(Math.max(ans[i], ans2[i]) + " ");
    }
}