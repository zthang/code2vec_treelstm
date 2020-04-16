public long dfsForMinLCA(Node root, int sub) {
    int size = root.size - sub;
    if (size % 2 == 1) {
        throw new RuntimeException();
    }
    Node heavyNode = root.heavy.other(root);
    int heavySize = heavyNode.size - sub;
    if (heavySize <= size / 2) {
        return root.depth * (long) (size / 2);
    }
    long ans = (long) (root.size - heavyNode.size) * root.depth;
    ans += dfsForMinLCA(heavyNode, sub + (root.size - heavyNode.size));
    return ans;
}