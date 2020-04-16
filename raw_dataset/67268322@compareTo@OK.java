public int compareTo(Pair o) {
    if (l == o.l) {
        return r - o.r;
    }
    return l - o.l;
}