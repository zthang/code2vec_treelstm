public int compareTo(Node o) {
    if ((this.a % 2) == (o.a % 2)) {
        return (this.b - o.b);
    } else {
        return this.a - o.a;
    }
}