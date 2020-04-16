public int compareTo(Pair p) {
    return (this.L < p.L) ? -1 : (this.L == p.L) ? this.i - p.i : 1;
}