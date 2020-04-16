static void dfs2(LinkedList<Integer>[] l, int s, int p) {
    if (p == -1)
        parVal[s] = 0;
    else {
        int total = parVal[p] + subVal[p];
        total = total - (subVal[s] > 0 ? subVal[s] : 0);
        parVal[s] = Math.max(total, 0);
    }
    for (Integer I : l[s]) if (I != p)
        dfs2(l, I, s);
}