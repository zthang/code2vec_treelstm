public static String solve(int n, Map<Integer, Set<Integer>> graph) {
    int[] colors = new int[n];
    int first = findFirstNotColored(colors);
    Set<Integer> adjacent = graph.getOrDefault(first, Collections.emptySet());
    color(1, colors, adjacent);
    int second = findFirstNotColored(colors);
    adjacent = graph.getOrDefault(second, Collections.emptySet());
    color(2, colors, adjacent);
    int third = findFirstNotColored(colors);
    adjacent = graph.getOrDefault(third, Collections.emptySet());
    color(3, colors, adjacent);
    Map<Integer, Long> colorsDistribution = Arrays.stream(colors).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Set<Integer> visited = new HashSet<>();
    dfs(0, visited, graph, colors, colorsDistribution);
    if (visited.size() != n) {
        throw new RuntimeException();
    }
    return Arrays.stream(colors).mapToObj(Integer::toString).collect(Collectors.joining(" "));
}