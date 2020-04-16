private void traverse(List<TreeNode<T>> list, int mode) {
    Queue<TreeNode<T>> queue = QueueUtils.createLIFO();
    queue.add(this);
    while (!queue.isEmpty()) {
        TreeNode<T> n = queue.remove();
        if (mode != 2 || n.getChildCount() == 0)
            list.add(n);
        Iterable<TreeNode<T>> children = mode == 1 ? n.getChildren() : Utils.reverseIterable(n.getChildren());
        for (TreeNode<T> child : children) {
            queue.add(child);
        }
    }
    if (mode == 1)
        Collections.reverse(list);
}