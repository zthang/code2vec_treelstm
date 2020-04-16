public int compareTo(Object o) {
    Pair pr = (Pair) o;
    if (s > pr.s)
        return 1;
    if (s == pr.s) {
        if (f > pr.f)
            return 1;
        else
            return -1;
    } else
        return -1;
}