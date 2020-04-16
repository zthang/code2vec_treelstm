public int compare(pair o1, pair o2) {
    if (o1.l == o2.l)
        return o1.r - o2.r;
    return o1.l - o2.l;
}