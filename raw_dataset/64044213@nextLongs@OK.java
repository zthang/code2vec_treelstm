public long[][] nextLongs(int N) {
    return IntStream.range(0, N).mapToObj(i -> nextLongs()).toArray(long[][]::new);
}