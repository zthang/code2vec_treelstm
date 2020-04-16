public static void solve() {
    int n = s.nextInt();
    adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new LinkedList<Integer>();
    }
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
        make_set(i);
    }
    int m = s.nextInt();
    while (m-- > 0) {
        int x = s.nextInt() - 1;
        int y = s.nextInt() - 1;
        adj[x].add(y);
        adj[y].add(x);
    }
    HashMap<Integer, Integer> parents = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
        parents.put(i, 0);
    }
    for (int i = 1; i < n; i++) {
        for (Integer x : adj[i]) {
            int parent = find_set(x);
            int val = parents.get(parent) + 1;
            parents.put(parent, val);
        }
        HashSet<Integer> remove = new HashSet<Integer>();
        for (Integer x : parents.keySet()) {
            if (size[x] != parents.get(x)) {
                Union_set(x, i);
                remove.add(x);
                remove.add(i);
            }
        }
        HashSet<Integer> add = new HashSet<Integer>();
        for (Integer x : remove) {
            parents.remove(x);
            add.add(find_set(x));
        }
        for (Integer x : add) {
            parents.put(x, 0);
        }
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (Integer x : parents.keySet()) {
            temp.put(x, 0);
        }
        parents = temp;
    }
    HashSet<Integer> components = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
        int parent = find_set(i);
        components.add(parent);
    }
    out.println(components.size() - 1);
}