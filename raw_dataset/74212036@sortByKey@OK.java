private static HashMap<Integer, Integer> sortByKey(HashMap<Integer, Integer> map) {
    return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
}