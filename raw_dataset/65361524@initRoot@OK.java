protected void initRoot(TreeNode<T> node) {
    if (root != null)
        throw new IllegalStateException("Can't modify the root after it has already been initialized!");
    this.root = node;
}