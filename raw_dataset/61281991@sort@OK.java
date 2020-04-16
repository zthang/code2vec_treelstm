static HashMap<Long, Pair> sort(HashMap<Long, Pair> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Long, Pair>> list = new LinkedList<Map.Entry<Long, Pair>>(hm.entrySet());
    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<Long, Pair>>() {

        public int compare(Map.Entry<Long, Pair> o1, Map.Entry<Long, Pair> o2) {
            return (o1.getValue().y) - (o2.getValue().y);
        }
    });
    // put data from sorted list to hashmap
    HashMap<Long, Pair> temp = new LinkedHashMap<Long, Pair>();
    for (Map.Entry<Long, Pair> aa : list) {
        temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
}