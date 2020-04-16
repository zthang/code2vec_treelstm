public static int[] findMinimumMoves(int[] arr) {
    int[] moves = new int[arr.length];
    Map<Integer, List<Integer>> childToParents = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < arr.length; i++) {
        moves[i] = -1;
    }
    List<Integer> leaves = new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++) {
        int left = i - arr[i];
        int right = i + arr[i];
        // Find ones
        if (isValidIndex(arr, left) && !isSameParity(left, i, arr) || isValidIndex(arr, right) && !isSameParity(right, i, arr)) {
            moves[i] = 1;
            leaves.add(i);
        }
        // Update parents
        if (isValidIndex(arr, left)) {
            if (childToParents.get(left) != null) {
                childToParents.get(left).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                childToParents.put(left, list);
            }
        }
        if (isValidIndex(arr, right)) {
            if (childToParents.get(right) != null) {
                childToParents.get(right).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                childToParents.put(right, list);
            }
        }
    }
    Set<Integer> children = new HashSet<Integer>(leaves);
    Set<Integer> processed = new HashSet<Integer>(leaves);
    int depth = 2;
    while (!children.isEmpty()) {
        Set<Integer> newChildren = new HashSet<Integer>();
        for (Integer i : children) {
            List<Integer> parents = childToParents.get(i);
            if (parents == null) {
                continue;
            }
            for (Integer p : parents) {
                if (!processed.contains(p)) {
                    processed.add(p);
                    newChildren.add(p);
                    moves[p] = depth;
                }
            }
        }
        depth++;
        children = newChildren;
    }
    return moves;
}