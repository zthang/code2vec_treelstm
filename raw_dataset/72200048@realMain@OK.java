public void realMain() throws Exception {
    BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);
    String in = fin.readLine();
    String[] ar = in.split(" ");
    int n = Integer.parseInt(ar[0]);
    int m = Integer.parseInt(ar[1]);
    ArrayList<Node> nodes = new ArrayList<Node>();
    for (int i = 0; i < n; i++) {
        Node node = new Node(i);
        nodes.add(node);
    }
    for (int i = 0; i < m; i++) {
        int ret = 0;
        boolean dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        int from = ret - 1;
        ret = 0;
        dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        int to = ret - 1;
        nodes.get(from).goingto.add(to);
        nodes.get(to).comingfrom.add(from);
    }
    int ret = 0;
    boolean dig = false;
    for (int ch = 0; (ch = fin.read()) != -1; ) {
        if (ch >= '0' && ch <= '9') {
            dig = true;
            ret = ret * 10 + ch - '0';
        } else if (dig)
            break;
    }
    int k = ret;
    int[] p = new int[k];
    for (int i = 0; i < k; i++) {
        ret = 0;
        dig = false;
        for (int ch = 0; (ch = fin.read()) != -1; ) {
            if (ch >= '0' && ch <= '9') {
                dig = true;
                ret = ret * 10 + ch - '0';
            } else if (dig)
                break;
        }
        p[i] = ret - 1;
    }
    int[] shortesttoend = new int[n];
    int[] numshortest = new int[n];
    for (int i = 0; i < n; i++) {
        shortesttoend[i] = Integer.MAX_VALUE;
        numshortest[i] = 0;
    }
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(p[k - 1]);
    boolean[] visited = new boolean[n];
    // System.err.println(nodes.get(p[k - 1]).comingfrom);
    visited[p[k - 1]] = true;
    while (queue.size() > 0) {
        int cur = queue.poll();
        for (Integer comingfrom : nodes.get(cur).comingfrom) {
            if (visited[comingfrom]) {
                continue;
            }
            nodes.get(comingfrom).distance = nodes.get(cur).distance + 1;
            visited[comingfrom] = true;
            queue.add(comingfrom);
        }
    }
    for (int i = 0; i < n; i++) {
        for (Integer goingto : nodes.get(i).goingto) {
            if (shortesttoend[i] > nodes.get(goingto).distance + 1) {
                shortesttoend[i] = nodes.get(goingto).distance + 1;
                numshortest[i] = 1;
            } else if (shortesttoend[i] == nodes.get(goingto).distance + 1) {
                numshortest[i]++;
            }
        }
    }
    // System.err.println(Arrays.toString(shortesttoend));
    // System.err.println(Arrays.toString(numshortest));
    int min = 0;
    int max = 0;
    int cur = p[0];
    for (int i = 1; i < k; i++) {
        if (shortesttoend[cur] < nodes.get(p[i]).distance + 1) {
            min++;
            max++;
        } else if (numshortest[cur] > 1) {
            max++;
        }
        cur = p[i];
    }
    System.out.println(min + " " + max);
}