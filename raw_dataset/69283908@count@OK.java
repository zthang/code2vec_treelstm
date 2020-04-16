public long count(Node root, Edge p, int depth) {
    long ans = (long) root.weight * depth;
    for (Edge e : root.next) {
        if (e == p) {
            continue;
        }
        Node node = e.other(root);
        ans += count(node, e, depth + e.len);
    }
    return ans;
}