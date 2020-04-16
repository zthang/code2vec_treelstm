public static ArrayList<Integer> construct(int[][] a, ArrayList<Integer> order, int n) {
    int[] init = a[order.get(n - 3)];
    HashMap<Integer, Node> map = new HashMap<>();
    for (int i = 0; i < 3; i++) map.put(init[i], new Node());
    for (int i = 0; i < 3; i++) {
        map.get(init[i]).left = init[(i - 1 + 3) % 3];
        map.get(init[i]).right = init[(i + 1) % 3];
    }
    for (int i = n - 4; i >= 0; i--) {
        init = a[order.get(i)];
        for (int j = 0; j < 3; j++) if (!map.containsKey(init[j])) {
            int temp = init[0];
            init[0] = init[j];
            init[j] = temp;
            break;
        }
        if (map.get(init[1]).left == init[2])
            insert(map, init[2], init[0], init[1]);
        else
            insert(map, init[1], init[0], init[2]);
    }
    ArrayList<Integer> seq = new ArrayList<>();
    int curr = 0;
    do {
        seq.add(curr);
        curr = map.get(curr).right;
    } while (curr != 0);
    return seq;
}