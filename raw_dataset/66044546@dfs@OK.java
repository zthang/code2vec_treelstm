static void dfs(LinkedList<Integer>[] l, int s, boolean[] v) {
    v[s] = true;
    for (Integer i : l[s]) if (v[i] == false)
        dfs(l, i, v);
}