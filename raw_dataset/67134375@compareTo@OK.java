public int compareTo(Pair o) {
    if (b == o.b)
        return a - o.a;
    return Long.compare(b, o.b);
}