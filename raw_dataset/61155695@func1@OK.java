private int func1(HashMap<Integer, Integer> map, CAnadiAndDomino.Edge[] arr) {
    HashSet<CAnadiAndDomino.domino> set = new HashSet<>();
    for (int i = 1; i <= 6; i++) {
        for (int j = i; j <= 6; j++) {
            set.add(new CAnadiAndDomino.domino(i, j));
        }
    }
    int count = 0;
    for (CAnadiAndDomino.Edge e : arr) {
        int src = e.src;
        int dest = e.dest;
        if (set.contains(new CAnadiAndDomino.domino(map.get(src), map.get(dest)))) {
            count++;
            set.remove(new CAnadiAndDomino.domino(map.get(src), map.get(dest)));
        }
    }
    return count;
}