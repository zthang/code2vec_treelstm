public int[][] nextInts(int N) {
    return IntStream.range(0, N).mapToObj(i -> nextInts()).toArray(int[][]::new);
}