public int compareTo(tuble other) {
    if (this.x == other.x) {
        return this.y - other.y;
    } else {
        return this.x - other.x;
    }
}