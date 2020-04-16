public String getSpaceSeperatedInts(int[] ints) {
    return Stream.of(ints).map(String::valueOf).collect(Collectors.joining(" "));
}