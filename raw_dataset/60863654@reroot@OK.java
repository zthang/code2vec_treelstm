private Node reroot(int x, int level) {
    gctReroot++;
    if (lvs[level].forest[x] == null)
        return null;
    Node any = lvs[level].forest[x];
    Node[] a_b = split(any);
    return merge(a_b[1], a_b[0]);
}