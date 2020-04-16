public List<Node> getChildren() {
    List<Node> result = new ArrayList<>();
    for (Node child : children) {
        if (child.label != parent.label) {
            result.add(child);
        }
    }
    return result;
}