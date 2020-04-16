void dfs(int p, int i) {
    pp[i] = p;
    ta[i] = ++time;
    for (int l = ae[i]; l != 0; l = ll[l]) {
        int j = jj[l];
        if (j != p) {
            if (ta[j] == 0)
                dfs(i, j);
            else if (ta[j] < ta[i]) {
                int k = 1, d = dd[j];
                cc[j] = link(cc[j], c);
                for (int h = i; h != j; h = pp[h]) {
                    k++;
                    d += dd[h];
                    cc[h] = link(cc[h], c);
                }
                ck[c] = k;
                cd[c] = d;
                c++;
            }
        }
    }
}