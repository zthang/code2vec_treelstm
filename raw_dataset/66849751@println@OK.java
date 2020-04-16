public FastOutput println(long c) {
    cache.append(c).append('\n');
    return this;
}