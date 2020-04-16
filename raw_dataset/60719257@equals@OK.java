@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null)
        return false;
    Pair other = (Pair) obj;
    if (this.x == other.x && this.y == other.y) {
        return true;
    }
    return false;
}