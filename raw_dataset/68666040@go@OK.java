void go(int rt) {
    List<Integer> go1 = new ArrayList<>();
    for (int i : vis) {
        if (!g[rt].contains(i)) {
            go1.add(i);
        }
    }
    for (int vv : go1) {
        vis.remove(vv);
    }
    for (int vv : go1) {
        go(vv);
    }
}