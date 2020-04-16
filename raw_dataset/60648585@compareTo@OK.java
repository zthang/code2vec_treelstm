public int compareTo(Pair p) {
    return (this.i < p.i) ? -1 : (this.i == p.i) ? this.j - p.j : 1;
}