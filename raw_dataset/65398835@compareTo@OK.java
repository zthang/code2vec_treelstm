public int compareTo(PairII o) {
    int value = Integer.compare(first, o.first);
    if (value != 0) {
        return value;
    }
    return Integer.compare(second, o.second);
}