public TreeNode<T> addChild(T value, double distance) {
    return createUnattached(value, distance).attach();
}