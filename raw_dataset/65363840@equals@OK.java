@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Pair other = (Pair) obj;
    if (first != other.first)
        return false;
    if (second != other.second)
        return false;
    return true;
}