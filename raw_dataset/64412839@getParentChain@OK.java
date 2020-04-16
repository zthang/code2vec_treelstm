public List<TreeNode<T>> getParentChain() {
    List<TreeNode<T>> res = new ArrayList<>();
    TreeNode<T> node = this;
    while ((node = node.getParent()) != null) {
        res.add(node);
    }
    Collections.reverse(res);
    return res;
}