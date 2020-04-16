@Override
public boolean equals(Object ob) {
    if (ob == null)
        return false;
    if (!(ob instanceof Node))
        return false;
    if (ob == this)
        return true;
    Node obj = (Node) ob;
    if (this.x == obj.x && this.y == obj.y)
        return true;
    return false;
}