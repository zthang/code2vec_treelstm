private static List<Integer>[] buildTree(Set<Integer>[] g) {
    List<Integer>[] tmp = new List[g.length];
    for (int i = 0; i < g.length; ++i) tmp[i] = new ArrayList<>();
    dfsTreeBuild(tmp, g, 0, -1);
    return tmp;
}