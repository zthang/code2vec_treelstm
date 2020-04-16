@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Node other = (Node) obj;
    if (x != other.x)
        return false;
    if (y != other.y)
        return false;
    return true;
}