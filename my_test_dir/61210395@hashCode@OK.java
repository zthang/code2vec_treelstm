@Override
public int hashCode() {
    int hash = 5;
    hash = 47 * hash + this.x;
    hash = 47 * hash + this.y;
    return hash;
}