static void dfs1(LinkedList<Integer>[] l, int s, int p, int[] col) {
    int v = col[s] == 1 ? 1 : -1;
    for (Integer I : l[s]) if (I != p) {
        dfs1(l, I, s, col);
        v = v + Math.max(subVal[I], 0);
    }
    subVal[s] = v;
}