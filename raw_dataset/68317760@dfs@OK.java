ArrayList<Integer> dfs(int x) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int y : adj[x]) {
        ArrayList<Integer> temp = dfs(y);
        for (int i : temp) list.add(i);
    }
    if (c[x] > list.size()) {
        res = false;
        return list;
    }
    list.add(c[x], x);
    return list;
}