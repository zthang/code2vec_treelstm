static void dfs2(int s, int p) {
    if (p == -1) {
        parVal[s] = 0;
    } else {
        int v = parVal[p] + subVal[p];
        if (subVal[s] >= 0)
            v -= subVal[s];
        parVal[s] = Math.max(0, v);
    }
    for (Integer I : l[s]) if (I != p)
        dfs2(I, s);
}