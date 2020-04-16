public static int dfs(int i) {
    HashSet<Integer> seen = new HashSet<Integer>();
    Stack<Integer> stk = new Stack<Integer>();
    stk.add(root);
    while (!stk.isEmpty()) {
        int curr = stk.pop();
        if (seen.contains(curr))
            continue;
        seen.add(curr);
        Node currNode = nodes[curr];
        if (currNode.val == 0) {
            currNode.number = i;
            return curr;
        }
        for (int temp : edges[curr]) {
            stk.add(temp);
        }
    }
    System.out.println("NO");
    System.exit(0);
    return -1;
}