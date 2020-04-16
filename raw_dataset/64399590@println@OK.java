public FastOutput println(String c) {
    cache.append(c).append('\n');
    return this;
}