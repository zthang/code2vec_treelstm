public int compareTo(Edge other) {
    if (this.w != other.w) {
        return this.w - other.w;
    } else {
        return this.type - other.type;
    }
}