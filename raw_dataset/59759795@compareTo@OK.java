public int compareTo(Edge o) {
    if (w == o.w)
        return to - o.to;
    return w - o.w;
}