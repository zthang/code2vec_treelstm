public FastOutput println(int c) {
    cache.append(c).append('\n');
    return this;
}