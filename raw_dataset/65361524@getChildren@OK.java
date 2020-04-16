public List<TreeNode<T>> getChildren() {
    return this.children.size() == 0 ? Collections.emptyList() : Collections.unmodifiableList(children);
}