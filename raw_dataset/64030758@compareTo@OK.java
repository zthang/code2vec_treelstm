public int compareTo(Pair p) {
    return (this.L < p.L) ? -1 : (this.L == p.L) ? this.x - p.x : 1;
}