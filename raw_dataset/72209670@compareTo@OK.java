public int compareTo(Pair<U, V> b) {
    int cmpU = first.compareTo(b.first);
    return cmpU != 0 ? cmpU : second.compareTo(b.second);
}