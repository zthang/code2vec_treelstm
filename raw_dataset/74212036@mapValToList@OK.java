private static List<Integer> mapValToList(HashMap<Integer, Integer> map) {
    return map.values().stream().collect(Collectors.toList());
}