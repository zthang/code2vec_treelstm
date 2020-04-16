public int compareTo(Pair p) {
    if (this.second == p.second)
        return 0;
    if (this.first <= p.first)
        return -1;
    else
        return 1;
}