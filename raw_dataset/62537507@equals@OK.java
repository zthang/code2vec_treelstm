@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Node)) {
        return false;
    } else {
        Node node = (Node) obj;
        return (n == node.n);
    }
}