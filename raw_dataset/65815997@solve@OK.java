static String solve(int[] a, int m) {
    if (a.length == 2 || m != a.length) {
        return "-1";
    }
    return String.format("%d\n%s", Arrays.stream(a).sum() * 2, IntStream.range(0, a.length).mapToObj(i -> String.format("%d %d", i + 1, (i + 1) % a.length + 1)).collect(Collectors.joining("\n")));
}