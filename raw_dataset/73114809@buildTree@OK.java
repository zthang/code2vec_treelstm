private static List<Integer>[] buildTree(List<Integer>[] g) {
    List<Integer>[] t = new List[g.length];
    for (int i = 0; i < t.length; i++) {
        t[i] = new ArrayList<>();
    }
    dfsTreeBuild(t, g, 0, -1);
    return t;
}