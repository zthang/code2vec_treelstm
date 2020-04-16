long rec(int node, int father, TreeSet<Integer>[] adjTree) {
    long res = 0;
    for (int neighbor : adjTree[root(node)]) {
        if ((father != -1 && root(neighbor) == root(father)) || root(neighbor) == root(node))
            continue;
        res = Math.max(res, rec(root(neighbor), root(node), adjTree));
    }
    res += w[root(node)];
    return res;
}