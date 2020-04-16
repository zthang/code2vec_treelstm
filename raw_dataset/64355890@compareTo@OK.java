@Override
public int compareTo(Edge o) {
    long x = this.weight - o.weight;
    if (x < 0)
        return -1;
    if (x > 0)
        return 1;
    return (int) x;
}