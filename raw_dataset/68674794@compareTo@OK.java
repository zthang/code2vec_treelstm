public int compareTo(Node c) {
    int t = Integer.compare(this.a, c.a);
    if (t != 0)
        return t;
    return Integer.compare(this.l, c.l);
}