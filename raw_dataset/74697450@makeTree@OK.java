private void makeTree(Node parent) {
    this.level = parent.level + 1;
    this.parent = parent;
    for (Node child : getChildren()) {
        child.makeTree(this);
    }
}