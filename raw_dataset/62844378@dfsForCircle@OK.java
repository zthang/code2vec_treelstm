public void dfsForCircle(Node root, Edge from, List<Circle> circles, List<Node> stack) {
    if (root.visited) {
        if (!root.instack) {
            return;
        }
        int len = from.other(root).depth - root.depth + 1;
        Circle c = new Circle(len);
        c.prob = pow.pow(ONE_TWO, len);
        circles.add(c);
        for (int i = stack.size() - 1; i >= 0; i--) {
            Node node = stack.get(i);
            c.nodes.add(node);
            node.probSum = mod.plus(node.probSum, c.prob);
            if (node == root) {
                break;
            }
        }
        return;
    }
    root.instack = true;
    stack.add(root);
    root.depth = stack.size();
    root.visited = true;
    for (Edge e : root.next) {
        if (e == from) {
            continue;
        }
        Node node = e.other(root);
        dfsForCircle(node, e, circles, stack);
    }
    stack.remove(stack.size() - 1);
    root.instack = false;
}