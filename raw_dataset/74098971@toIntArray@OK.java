public int[] toIntArray(String s) {
    return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
}