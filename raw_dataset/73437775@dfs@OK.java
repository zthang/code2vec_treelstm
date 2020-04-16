public static void dfs(int node, int[] levels, int currentLevel, Map<Integer, Set<Integer>> edges, int ceilSqrtN, boolean[] marked) {
    stack[stackPointer++] = node;
    levels[node] = currentLevel;
    for (int neighbor : edges.get(node)) {
        if (levels[neighbor] == -1) {
            // not visited
            dfs(neighbor, levels, currentLevel + 1, edges, ceilSqrtN, marked);
        } else {
            // visited - back edge
            int levelDiff = levels[node] - levels[neighbor];
            if ((levelDiff + 1) >= ceilSqrtN) {
                writer.println("2");
                writer.println(levelDiff + 1);
                int popped = stack[--stackPointer];
                while (popped != neighbor) {
                    writer.print(popped + 1);
                    writer.print(' ');
                    popped = stack[--stackPointer];
                }
                writer.println(neighbor + 1);
                writer.close();
                System.exit(0);
            }
        }
    }
    if (!marked[node]) {
        if (listPointer < ceilSqrtN) {
            list[listPointer++] = node;
        }
        // mark node and its neighbors
        marked[node] = true;
        for (int neighbor : edges.get(node)) {
            marked[neighbor] = true;
        }
    }
    stackPointer--;
}