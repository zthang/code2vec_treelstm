public int compareTo(Pair o) {
    if (a == o.a)
        return b - o.b;
    return o.a - a;
}