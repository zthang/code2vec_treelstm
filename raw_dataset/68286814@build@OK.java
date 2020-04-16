void build(int cur, int lvl, ArrayList<pair<pair<Integer, Integer>, Integer>> tot) {
    tot.add(new pair<>(new pair<>(ans[cur], lvl), cur));
    for (int i : a[cur]) build(i, lvl + 1, tot);
}