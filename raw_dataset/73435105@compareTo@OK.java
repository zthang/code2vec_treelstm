public int compareTo(Pair p) {
    if (a > p.a)
        return 1;
    if (a == p.a)
        return (b - p.b);
    return -1;
}