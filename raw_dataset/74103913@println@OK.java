void println(int[] arr) {
    String line = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    println(line);
}