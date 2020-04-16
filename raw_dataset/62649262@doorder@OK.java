static void doorder(int v) {
    ord.add(v);
    vis.add(v);
    for (int i = 0; i < tree.get(v).size(); i++) {
        if (vis.contains(tree.get(v).get(i)))
            continue;
        doorder(tree.get(v).get(i));
    }
}