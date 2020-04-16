public int compareTo(Pair<A, B> o) {
    int c = first.compareTo(o.first);
    if (c != 0)
        return c;
    return second.compareTo(o.second);
}