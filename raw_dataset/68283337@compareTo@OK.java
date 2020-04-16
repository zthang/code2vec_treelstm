public int compareTo(Composite X) {
    if (w != X.w)
        return w - X.w;
    return idx - X.idx;
}