void startAlgo() {
    if (n > m || n == 2) {
        z.println(-1);
        return;
    }
    long cost = 0;
    Triple[] ans = new Triple[m];
    int index2 = 0;
    for (int i = 0; i < list.length; i++) {
        Triple triple = list[i];
        int u = triple.u;
        int v = triple.v;
        if (!set[u] || !set[v] && (degree[u] <= 1 && degree[v] <= 1)) {
            set[u] = true;
            set[v] = true;
            degree[u]++;
            degree[v]++;
            ans[index2++] = new Triple(u, v);
            cost += triple.w;
            triple.taken = true;
            m--;
        }
    }
    int sU = -1;
    int sV = -1;
    for (int i = 1; i <= n; i++) {
        if (degree[i] == 1 && sU == -1) {
            sU = i;
        } else if (degree[i] == 1) {
            sV = i;
        }
    }
    if (sU == -1 || sV == -1) {
        z.println(-1);
        return;
    }
    cost += weight[sU][sV];
    ans[index2++] = new Triple(sU, sV);
    m--;
    if (m >= 0) {
        z.println(cost);
        for (Triple t : ans) {
            z.println(t.u + " " + t.v);
        }
    } else {
        z.println(-1);
    }
}