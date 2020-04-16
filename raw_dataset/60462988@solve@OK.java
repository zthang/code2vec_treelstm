public void solve(int testNumber, FastReader s, PrintWriter out) {
    int n = s.nextInt();
    EPetyaAndConstructionSet.pair[] arr = new EPetyaAndConstructionSet.pair[n];
    for (int i = 0; i < n; i++) {
        arr[i] = new EPetyaAndConstructionSet.pair(2 * i + 1, s.nextInt());
    }
    HashMap<Integer, EPetyaAndConstructionSet.Node> leftMap = new HashMap<>();
    HashMap<Integer, EPetyaAndConstructionSet.Node> rightMap = new HashMap<>();
    HashMap<Integer, Integer> levels = new HashMap<>();
    HashSet<Integer> leftSet = new HashSet<>();
    HashSet<Integer> rightSet = new HashSet<>();
    Arrays.sort(arr);
    EPetyaAndConstructionSet.Node root = new EPetyaAndConstructionSet.Node(arr[0].from);
    root.level = 0;
    leftMap.put(0, root);
    rightMap.put(0, root);
    int count = 0;
    EPetyaAndConstructionSet.Node parent = root;
    EPetyaAndConstructionSet.Node curr;
    int i = 1;
    while (count != arr[0].val - 1) {
        curr = new EPetyaAndConstructionSet.Node(arr[i].from);
        curr.level = parent.level + 1;
        curr.left = true;
        leftSet.add(i);
        leftMap.put(curr.level, curr);
        levels.put(i, curr.level);
        parent.children.add(curr);
        parent = curr;
        count++;
        i++;
    }
    EPetyaAndConstructionSet.Node a = new EPetyaAndConstructionSet.Node(arr[0].to);
    a.level = parent.level + 1;
    a.left = true;
    parent.children.add(a);
    leftMap.put(a.level, a);
    parent = root;
    // i--;
    while (i != n) {
        curr = new EPetyaAndConstructionSet.Node(arr[i].from);
        curr.level = parent.level + 1;
        curr.left = false;
        levels.put(i, curr.level);
        rightSet.add(i);
        rightMap.put(curr.level, curr);
        parent.children.add(curr);
        parent = curr;
        count++;
        i++;
    }
    leftSet.add(0);
    rightSet.add(0);
    for (int j = 1; j < n; j++) {
        int level = levels.get(j);
        if (leftSet.contains(j)) {
            if (level > arr[j].val) {
                if (leftMap.containsKey(level + arr[j].val - 1)) {
                    EPetyaAndConstructionSet.Node n1 = leftMap.get(level + arr[j].val - 1);
                    EPetyaAndConstructionSet.Node newNode = new EPetyaAndConstructionSet.Node(arr[j].to);
                    newNode.left = true;
                    newNode.level = level + arr[j].val;
                    n1.children.add(newNode);
                    if (!leftMap.containsKey(newNode.level)) {
                        leftMap.put(newNode.level, newNode);
                    }
                } else {
                    EPetyaAndConstructionSet.Node n1 = leftMap.get(level - arr[j].val + 1);
                    EPetyaAndConstructionSet.Node newNode = new EPetyaAndConstructionSet.Node(arr[j].to);
                    newNode.left = true;
                    newNode.level = level - arr[j].val;
                    n1.children.add(newNode);
                    if (!leftMap.containsKey(newNode.level)) {
                        leftMap.put(newNode.level, newNode);
                    }
                }
            } else {
                if (leftMap.containsKey(level + arr[j].val - 1)) {
                    EPetyaAndConstructionSet.Node n1 = leftMap.get(level + arr[j].val - 1);
                    EPetyaAndConstructionSet.Node newNode = new EPetyaAndConstructionSet.Node(arr[j].to);
                    newNode.left = true;
                    newNode.level = level + arr[j].val;
                    n1.children.add(newNode);
                    if (!leftMap.containsKey(newNode.level)) {
                        leftMap.put(newNode.level, newNode);
                    }
                } else {
                    EPetyaAndConstructionSet.Node n1 = rightMap.get(arr[j].val - level - 1);
                    EPetyaAndConstructionSet.Node newNode = new EPetyaAndConstructionSet.Node(arr[j].to);
                    newNode.left = true;
                    newNode.level = arr[j].val - level - 1;
                    n1.children.add(newNode);
                    if (!rightMap.containsKey(newNode.level)) {
                        rightMap.put(newNode.level, newNode);
                    }
                }
            }
        } else {
            if (level > arr[j].val) {
                if (rightMap.containsKey(level + arr[j].val - 1)) {
                    EPetyaAndConstructionSet.Node n1 = rightMap.get(level + arr[j].val - 1);
                    EPetyaAndConstructionSet.Node newNode = new EPetyaAndConstructionSet.Node(arr[j].to);
                    newNode.left = true;
                    newNode.level = level + arr[j].val;
                    n1.children.add(newNode);
                    if (!rightMap.containsKey(newNode.level)) {
                        rightMap.put(newNode.level, newNode);
                    }
                } else {
                    EPetyaAndConstructionSet.Node n1 = rightMap.get(level - arr[j].val + 1);
                    EPetyaAndConstructionSet.Node newNode = new EPetyaAndConstructionSet.Node(arr[j].to);
                    newNode.left = true;
                    newNode.level = level - arr[j].val;
                    n1.children.add(newNode);
                    if (!rightMap.containsKey(newNode.level)) {
                        rightMap.put(newNode.level, newNode);
                    }
                }
            } else {
                if (rightMap.containsKey(level + arr[j].val - 1)) {
                    EPetyaAndConstructionSet.Node n1 = rightMap.get(level + arr[j].val - 1);
                    EPetyaAndConstructionSet.Node newNode = new EPetyaAndConstructionSet.Node(arr[j].to);
                    newNode.left = true;
                    newNode.level = level + arr[j].val;
                    n1.children.add(newNode);
                    if (!rightMap.containsKey(newNode.level)) {
                        rightMap.put(newNode.level, newNode);
                    }
                } else {
                    EPetyaAndConstructionSet.Node n1 = leftMap.get(arr[j].val - level - 1);
                    EPetyaAndConstructionSet.Node newNode = new EPetyaAndConstructionSet.Node(arr[j].to);
                    newNode.left = true;
                    newNode.level = arr[j].val - level - 1;
                    n1.children.add(newNode);
                    if (!leftMap.containsKey(newNode.level)) {
                        leftMap.put(newNode.level, newNode);
                    }
                }
            }
        }
    }
    Queue<EPetyaAndConstructionSet.Node> q = new LinkedList<>();
    q.add(root);
    ArrayList<EPetyaAndConstructionSet.edge> edges = new ArrayList<>();
    while (!q.isEmpty()) {
        EPetyaAndConstructionSet.Node curr1 = q.poll();
        for (EPetyaAndConstructionSet.Node node : curr1.children) {
            edges.add(new EPetyaAndConstructionSet.edge(curr1.val, node.val));
        }
        q.addAll(curr1.children);
    }
    // out.println(edges);
    StringBuilder str = new StringBuilder();
    for (EPetyaAndConstructionSet.edge e : edges) {
        str.append(e + "\n");
    }
    out.println(str);
}