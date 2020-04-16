void startAlgo() {
    if (n > m || n == 2) {
        z.println(-1);
        return;
    }
    int mm = m;
    long cost = 0;
    int index2 = 0;
    int len = (nn * (nn + 1)) / 2;
    for (int i = 0; i < len; i++) {
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
        int i = 0;
        while (m > 0) {
            Triple triple = list[i++];
            int u = triple.u;
            int v = triple.v;
            if ((u == sU && v == sV) || (u == sV && v == sU)) {
                continue;
            } else {
                if (!triple.taken) {
                    ans[index2++] = new Triple(u, v);
                    triple.taken = true;
                    cost += triple.w;
                    m--;
                }
            }
        }
        z.println(cost);
        for (int ii = 0; ii < mm; ii++) {
            Triple t = ans[ii];
            z.println(t.u + " " + t.v);
        }
    } else {
        z.println(-1);
    }
}