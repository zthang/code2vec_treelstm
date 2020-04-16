public void run() {
    InputReader sc = new InputReader(System.in);
    // Scanner sc=new Scanner(System.in);
    // Random sc=new Random();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    Node[] a = new Node[n];
    for (int i = 0; i < n; i++) {
        a[i] = new Node(i, sc.nextInt(), sc.nextInt());
    }
    Arrays.sort(a, new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.start, o2.start);
        }
    });
    DSU dsu = new DSU(n);
    TreeSet<Pair<Integer, Integer>> set = new TreeSet<>(new Comparator<Pair<Integer, Integer>>() {

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            return Integer.compare(o1.getKey(), o2.getKey());
        }
    });
    for (int i = 0; i < n; i++) {
        while (!set.isEmpty() && set.first().getKey() < a[i].start) set.pollFirst();
        for (Pair<Integer, Integer> x : set) {
            if (x.getKey() < a[i].end) {
                boolean connect = dsu.union(x.getValue(), i);
                if (connect == false) {
                    out.println("NO");
                    out.close();
                    return;
                }
            } else {
                break;
            }
        }
        set.add(new Pair<>(a[i].end, i));
    }
    HashSet<Integer> numOfRoot = new HashSet<>();
    for (int i = 0; i < n; i++) {
        numOfRoot.add(dsu.root(i));
    }
    if (numOfRoot.size() == 1)
        out.println("YES");
    else
        out.println("NO");
    out.close();
}