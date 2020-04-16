public boolean check(Set<Node> set, int n) {
    if (set.size() == 0) {
        return false;
    }
    for (Node node : set) {
        if (node.next.size() != n - set.size()) {
            return false;
        }
        for (Node next : node.next) {
            if (next.group == node.group) {
                return false;
            }
        }
    }
    return true;
}