public String[] string(int length) {
    return IntStream.range(0, length).mapToObj(x -> string()).toArray(String[]::new);
}