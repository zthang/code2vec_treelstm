public int compareTo(DijkstraState s) {
    // return this.dist - s.dist
    if (this.dist > s.dist)
        return 1;
    else if (this.dist == s.dist)
        return 0;
    else
        return -1;
}