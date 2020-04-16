public int compareTo(Composite X) {
    if (v != X.v)
        return v - X.v;
    return idx - X.idx;
}