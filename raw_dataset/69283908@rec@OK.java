public Node rec(Node[] nodes, int l, int r, int k) {
    if (k < 0) {
        return nodes[l];
    }
    Arrays.sort(nodes, l, r + 1, (a, b) -> a.status[k] - b.status[k]);
    Node last = null;
    for (int i = r; i >= l; i--) {
        int j = i;
        while (i - 1 >= l && nodes[i - 1].status[k] == nodes[i].status[k]) {
            i--;
        }
        Node merged = rec(nodes, i, j, k - 1);
        if (last == null) {
            last = merged;
        } else {
            last = merge(last, merged);
        }
    }
    return last;
}