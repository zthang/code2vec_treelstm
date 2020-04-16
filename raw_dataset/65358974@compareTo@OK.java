public int compareTo(Pair p) {
    if (cost != p.cost)
        return cost - p.cost;
    return idx - p.idx;
}