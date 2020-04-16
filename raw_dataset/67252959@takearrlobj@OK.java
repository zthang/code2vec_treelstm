public Long[] takearrlobj(int n) throws IOException {
    Long[] in = new Long[n];
    for (int i = 0; i < n; i++) in[i] = nextLong();
    return in;
}