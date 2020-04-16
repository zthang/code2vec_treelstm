public void realMain() throws Exception {
    BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);
    String in = fin.readLine();
    String[] ar = in.split(" ");
    int n = Integer.parseInt(ar[0]);
    /*long[] c1 = new long[n];
		long[] c2 = new long[n];
		long[] c3 = new long[n];
*/
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
        nodes[i] = new Node();
        nodes[i].children = new ArrayList<Node>();
        nodes[i].index = i;
        long ret = 0;
        boolean dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        nodes[i].c1 = ret;
    }
    for (int i = 0; i < n; i++) {
        long ret = 0;
        boolean dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        nodes[i].c2 = ret;
    }
    for (int i = 0; i < n; i++) {
        long ret = 0;
        boolean dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        nodes[i].c3 = ret;
    }
    for (int i = 0; i < n - 1; i++) {
        int ret = 0;
        boolean dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        int node1 = ret - 1;
        ret = 0;
        dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        int node2 = ret - 1;
        nodes[node1].children.add(nodes[node2]);
        nodes[node2].children.add(nodes[node1]);
    }
    for (int i = 0; i < n; i++) {
        if (nodes[i].children.size() > 2) {
            System.out.println("-1");
            return;
        }
    }
    int node1 = 0;
    for (int i = 0; i < n; i++) {
        if (nodes[i].children.size() == 1) {
            node1 = i;
            break;
        }
    }
    int[] colored = new int[n];
    int[] bestcolored = new int[n];
    int node2 = nodes[node1].children.get(0).index;
    boolean[] covered = new boolean[n];
    covered[node1] = true;
    covered[node2] = true;
    long mincost = Long.MAX_VALUE;
    long cost = 0;
    cost += nodes[node1].c1;
    cost += nodes[node2].c2;
    colored[node1] = 1;
    colored[node2] = 2;
    int cur = node2;
    int count = 2;
    int[] order = { 1, 2, 3 };
    int orderindex = 2;
    while (count < n) {
        int oldcur = cur;
        cur = nodes[oldcur].children.get(0).index;
        if (covered[cur]) {
            cur = nodes[oldcur].children.get(1).index;
        }
        int nextcolor = order[orderindex];
        colored[cur] = nextcolor;
        if (nextcolor == 1) {
            cost += nodes[cur].c1;
        } else if (nextcolor == 2) {
            cost += nodes[cur].c2;
        } else if (nextcolor == 3) {
            cost += nodes[cur].c3;
        }
        orderindex++;
        orderindex %= 3;
        covered[cur] = true;
        count++;
    }
    if (cost < mincost) {
        bestcolored = Arrays.copyOf(colored, n);
    }
    mincost = Math.min(mincost, cost);
    covered = new boolean[n];
    colored = new int[n];
    covered[node1] = true;
    covered[node2] = true;
    cost = 0;
    cost += nodes[node1].c1;
    cost += nodes[node2].c3;
    colored[node1] = 1;
    colored[node2] = 3;
    cur = node2;
    count = 2;
    order[0] = 1;
    order[1] = 3;
    order[2] = 2;
    orderindex = 2;
    while (count < n) {
        int oldcur = cur;
        cur = nodes[oldcur].children.get(0).index;
        if (covered[cur]) {
            cur = nodes[oldcur].children.get(1).index;
        }
        int nextcolor = order[orderindex];
        colored[cur] = nextcolor;
        if (nextcolor == 1) {
            cost += nodes[cur].c1;
        } else if (nextcolor == 2) {
            cost += nodes[cur].c2;
        } else if (nextcolor == 3) {
            cost += nodes[cur].c3;
        }
        orderindex++;
        orderindex %= 3;
        covered[cur] = true;
        count++;
    }
    if (cost < mincost) {
        bestcolored = Arrays.copyOf(colored, n);
    }
    mincost = Math.min(mincost, cost);
    covered = new boolean[n];
    colored = new int[n];
    covered[node1] = true;
    covered[node2] = true;
    cost = 0;
    cost += nodes[node1].c2;
    cost += nodes[node2].c1;
    colored[node1] = 2;
    colored[node2] = 1;
    cur = node2;
    count = 2;
    order[0] = 2;
    order[1] = 1;
    order[2] = 3;
    orderindex = 2;
    while (count < n) {
        int oldcur = cur;
        cur = nodes[oldcur].children.get(0).index;
        if (covered[cur]) {
            cur = nodes[oldcur].children.get(1).index;
        }
        int nextcolor = order[orderindex];
        colored[cur] = nextcolor;
        if (nextcolor == 1) {
            cost += nodes[cur].c1;
        } else if (nextcolor == 2) {
            cost += nodes[cur].c2;
        } else if (nextcolor == 3) {
            cost += nodes[cur].c3;
        }
        orderindex++;
        orderindex %= 3;
        covered[cur] = true;
        count++;
    }
    if (cost < mincost) {
        bestcolored = Arrays.copyOf(colored, n);
    }
    mincost = Math.min(mincost, cost);
    covered = new boolean[n];
    colored = new int[n];
    covered[node1] = true;
    covered[node2] = true;
    cost = 0;
    cost += nodes[node1].c2;
    cost += nodes[node2].c3;
    colored[node1] = 2;
    colored[node2] = 3;
    cur = node2;
    count = 2;
    order[0] = 2;
    order[1] = 3;
    order[2] = 1;
    orderindex = 2;
    while (count < n) {
        int oldcur = cur;
        cur = nodes[oldcur].children.get(0).index;
        if (covered[cur]) {
            cur = nodes[oldcur].children.get(1).index;
        }
        int nextcolor = order[orderindex];
        colored[cur] = nextcolor;
        if (nextcolor == 1) {
            cost += nodes[cur].c1;
        } else if (nextcolor == 2) {
            cost += nodes[cur].c2;
        } else if (nextcolor == 3) {
            cost += nodes[cur].c3;
        }
        orderindex++;
        orderindex %= 3;
        covered[cur] = true;
        count++;
    }
    if (cost < mincost) {
        bestcolored = Arrays.copyOf(colored, n);
    }
    mincost = Math.min(mincost, cost);
    covered = new boolean[n];
    colored = new int[n];
    covered[node1] = true;
    covered[node2] = true;
    cost = 0;
    cost += nodes[node1].c3;
    cost += nodes[node2].c1;
    colored[node1] = 3;
    colored[node2] = 1;
    cur = node2;
    count = 2;
    order[0] = 3;
    order[1] = 1;
    order[2] = 2;
    orderindex = 2;
    while (count < n) {
        int oldcur = cur;
        cur = nodes[oldcur].children.get(0).index;
        if (covered[cur]) {
            cur = nodes[oldcur].children.get(1).index;
        }
        int nextcolor = order[orderindex];
        colored[cur] = nextcolor;
        if (nextcolor == 1) {
            cost += nodes[cur].c1;
        } else if (nextcolor == 2) {
            cost += nodes[cur].c2;
        } else if (nextcolor == 3) {
            cost += nodes[cur].c3;
        }
        orderindex++;
        orderindex %= 3;
        covered[cur] = true;
        count++;
    }
    if (cost < mincost) {
        bestcolored = Arrays.copyOf(colored, n);
    }
    mincost = Math.min(mincost, cost);
    covered = new boolean[n];
    colored = new int[n];
    covered[node1] = true;
    covered[node2] = true;
    cost = 0;
    cost += nodes[node1].c3;
    cost += nodes[node2].c2;
    colored[node1] = 3;
    colored[node2] = 2;
    cur = node2;
    count = 2;
    order[0] = 3;
    order[1] = 2;
    order[2] = 1;
    orderindex = 2;
    while (count < n) {
        int oldcur = cur;
        cur = nodes[oldcur].children.get(0).index;
        if (covered[cur]) {
            cur = nodes[oldcur].children.get(1).index;
        }
        int nextcolor = order[orderindex];
        colored[cur] = nextcolor;
        if (nextcolor == 1) {
            cost += nodes[cur].c1;
        } else if (nextcolor == 2) {
            cost += nodes[cur].c2;
        } else if (nextcolor == 3) {
            cost += nodes[cur].c3;
        }
        orderindex++;
        orderindex %= 3;
        covered[cur] = true;
        count++;
    }
    if (cost < mincost) {
        bestcolored = Arrays.copyOf(colored, n);
    }
    mincost = Math.min(mincost, cost);
    System.out.println(mincost);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
        sb.append(bestcolored[i]);
        sb.append(' ');
    }
    System.out.println(sb);
}