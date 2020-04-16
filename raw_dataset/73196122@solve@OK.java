private void solve(Node node, Map<Integer, Integer> ans) {
    for (Node child : node.children) {
        int x = node.value;
        int y = child.value;
        if (child.value > 0) {
            node.value -= child.value;
        }
        if (node.value > 0) {
            child.value += node.value;
        }
        ans.put(child.label, child.value);
        solve(child, ans);
        node.value = x;
        child.value = y;
    }
}