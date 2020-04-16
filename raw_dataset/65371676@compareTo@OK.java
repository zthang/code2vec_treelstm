public int compareTo(Node other) {
    if (this.cost == other.cost) {
        return 0;
    } else if (this.cost > other.cost) {
        return 1;
    } else {
        return -1;
    }
}