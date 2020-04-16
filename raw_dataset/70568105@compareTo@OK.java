public int compareTo(Pair p) {
    if (this.value < p.value) {
        return -1;
    } else if (this.value == p.value) {
        return 0;
    }
    return 1;
}