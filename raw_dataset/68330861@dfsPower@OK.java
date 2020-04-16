private void dfsPower(TaskD.Node root) {
    root.power = 1;
    if (root.children.size() > 0) {
        for (TaskD.Node child : root.children) {
            dfsPower(child);
            root.power += child.power;
        }
    }
}