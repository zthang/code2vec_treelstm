public TreeNode<T> attach() {
    if (isAttached())
        throw new NoSuchElementException("Node has already been attached!");
    TreeNode.this.children.add(this);
    isAttached = true;
    return this;
}