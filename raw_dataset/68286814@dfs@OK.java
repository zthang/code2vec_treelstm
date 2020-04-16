boolean dfs(int cur) {
    for (int i : a[cur]) if (!dfs(i))
        return false;
    ArrayList<pair<pair<Integer, Integer>, Integer>> tot = new ArrayList<>();
    for (int i : a[cur]) build(i, 0, tot);
    if (tot.size() < c[cur])
        return false;
    Collections.sort(tot);
    if (tot.size() > c[cur]) {
        for (int i = c[cur]; i < tot.size(); i++) ans[tot.get(i).y]++;
        ans[cur] = tot.get(c[cur]).x.x + 1;
    } else
        ans[cur] = tot.size() + 1;
    return true;
}