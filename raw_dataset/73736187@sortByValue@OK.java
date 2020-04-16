public HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hm.entrySet());
    // ->change o1,o2 for reverseorder
    Collections.sort(list, (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> (o1.getValue()).compareTo(o2.getValue()));
    // put data from sorted list to hashmap
    HashMap<Integer, Integer> temp = new LinkedHashMap<>();
    list.forEach((aa) -> {
        temp.put(aa.getKey(), aa.getValue());
    });
    return temp;
}