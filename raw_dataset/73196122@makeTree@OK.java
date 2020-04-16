private void makeTree(int r) {
    root = nodes.get(r);
    root.specifyParent(root);
}