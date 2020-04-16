public int compareTo(Pair<U, V> b) {
    int cmpU = u.compareTo(b.u);
    return cmpU != 0 ? cmpU : v.compareTo(b.v);
}