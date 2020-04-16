public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return (o1.getValue()).compareTo(o2.getValue());
        }
    });
    // put data from sorted list to hashmap
    HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
    for (Map.Entry<Integer, Integer> aa : list) {
        temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
}