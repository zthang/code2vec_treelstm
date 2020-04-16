public int compareTo(Pair other) {
    if (this.x != other.x)
        return this.x - other.x;
    return this.y - other.y;
}