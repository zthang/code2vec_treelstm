public int compareTo(X x) {
    if (x.d == d)
        return r - x.r;
    return x.d - d;
}