static long cost(int a) {
    return cost[parent(a)].c;
}