public int compare(Pair c1, Pair c2) {
    return (c1.a < c2.a || (c1.a == c2.a && c1.b < c2.b)) ? -1 : 1;
}