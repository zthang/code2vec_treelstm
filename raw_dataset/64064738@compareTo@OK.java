public int compareTo(Pair other) {
    if (dist < other.dist)
        return -1;
    return 1;
}