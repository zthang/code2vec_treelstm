public int compareTo(Pair p) {
    if (this.second == p.second)
        return this.first - p.first;
    return this.second - p.second;
}