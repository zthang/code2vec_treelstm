void dfs1(int c, int ff) {
    clr[c][aa[c]]++;
    for (int j = h[c]; j != -1; j = ne[j]) {
        if (to[j] == ff)
            continue;
        dfs1(to[j], c);
        clr[c][1] += clr[to[j]][1];
        clr[c][2] += clr[to[j]][2];
        if (clr[to[j]][1] == s1 && clr[to[j]][2] == 0 || clr[to[j]][2] == s2 && clr[to[j]][1] == 0) {
            r++;
        }
    }
}