public int compareTo(Pair other) {
    if (this.x > other.x) {
        return 1;
    } else if (this.x < other.x) {
        return -1;
    }
    return this.y - other.y;
}