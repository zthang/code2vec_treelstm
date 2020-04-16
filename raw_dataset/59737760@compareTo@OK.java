public int compareTo(Edge e) {
    if (e.w == w && e.u == u)
        return v - e.v;
    if (e.w == w)
        return u - e.u;
    return w - e.w;
}