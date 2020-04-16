private static List<Integer> mapKeyToList(HashMap<Integer, Integer> map) {
    return map.keySet().stream().collect(Collectors.toList());
}