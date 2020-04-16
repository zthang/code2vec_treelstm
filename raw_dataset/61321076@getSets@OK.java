private ArrayList<Integer>[] getSets() {
    HashMap<Integer, ArrayList<Integer>> sets = new HashMap<>();
    for (int i = 0; i < p.length; i++) {
        int parent = get(i);
        if (!sets.containsKey(parent))
            sets.put(parent, new ArrayList<>());
        sets.get(parent).add(i);
    }
    int i = 0;
    ArrayList<Integer>[] res = new ArrayList[sets.size()];
    for (ArrayList<Integer> set : sets.values()) res[i++] = set;
    return res;
}