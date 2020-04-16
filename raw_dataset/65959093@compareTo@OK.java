@Override
public int compareTo(Pair other) {
    if (this.x != other.x)
        return Long.compare(this.x, other.x);
    return Long.compare(this.y * other.x, this.x * other.y);
}