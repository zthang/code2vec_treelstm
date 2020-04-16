static Node createNode(int lower, int upper) {
    if (lower == upper) {
        Node node = new Node(lower, upper);
        node.minIndex = lower;
        return node;
    }
    Node node = new Node(lower, upper);
    int mid = (upper - lower) / 2 + lower;
    Node left = createNode(lower, mid);
    Node right = createNode(mid + 1, upper);
    node.left = left;
    node.right = right;
    if (depth[left.minIndex] <= depth[right.minIndex]) {
        node.minIndex = left.minIndex;
    } else {
        node.minIndex = right.minIndex;
    }
    return node;
}