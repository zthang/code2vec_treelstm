static void dfs(LinkedList<Integer>[] l, int s, int p) {
    for (Integer I : l[s]) if (I != p)
        dfs(l, I, s);
}