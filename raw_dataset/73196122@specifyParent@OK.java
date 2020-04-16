private void specifyParent(Node parent) {
    this.parent = parent;
    for (Node child : new ArrayList<>(children)) {
        if (child.label != parent.label) {
            child.specifyParent(this);
        } else {
            children.remove(child);
        }
    }
}