static void dfs(int c) {
    un.remove(c);
    ArrayList<Integer> v = new ArrayList<Integer>();
    for (int x : un) if (!arr[c].contains(x))
        v.add(x);
    for (int u : v) un.remove(u);
    for (int u : v) dfs(u);
}