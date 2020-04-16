public int compareTo(iip o) {
    if (this.a == o.a) {
        return this.b - o.b;
    }
    return this.a - o.a;
}