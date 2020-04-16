// Equal objects must produce the same
// hash code as long as they are equal
@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (o == null) {
        return false;
    }
    if (this.getClass() != o.getClass()) {
        return false;
    }
    Pair other = (Pair) o;
    if (this.x != other.x || this.y != other.y) {
        return false;
    }
    return true;
}