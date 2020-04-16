public double nextDouble() {
    double cur = nextLong();
    return c != '.' ? cur : cur + nextLong() / cnt;
}