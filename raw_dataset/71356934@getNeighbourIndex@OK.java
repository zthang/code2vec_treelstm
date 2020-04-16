int getNeighbourIndex(int node) {
    if (this.u == node) {
        return v;
    }
    return u;
}