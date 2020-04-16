public static int calc(int n, int[] c, int[] p) {
    HashSet<Integer> visited = new HashSet<Integer>();
    int ans = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
        if (visited.contains(i)) {
            continue;
        } else {
            // get the cycle starting from i
            List<Integer> cycle = new ArrayList<Integer>();
            int curr = i;
            do {
                visited.add(curr);
                cycle.add(curr);
                curr = p[curr];
            } while (curr != i);
            // System.out.println(cycle);
            ans = Math.min(ans, cycle.size());
            // all vertices are self-loops, hence infinite paths are present
            for (int pow = 1; pow < cycle.size(); pow++) {
                boolean gotSomeAnswer = false;
                if (cycle.size() % pow != 0) {
                    continue;
                }
                // sub-cycle start position
                for (int start = 0; start < pow; start++) {
                    boolean isUniColor = true;
                    // System.out.print("Pow : " + pow + " Cycle : ");
                    for (int pos = start; pos < cycle.size(); pos += pow) {
                        // System.out.print(cycle.get(pos) + " ");
                        if (c[cycle.get(pos)] != c[cycle.get(start)]) {
                            isUniColor = false;
                            break;
                        }
                    }
                    // System.out.println();
                    if (isUniColor) {
                        ans = Math.min(ans, pow);
                        gotSomeAnswer = true;
                    }
                }
            }
        }
    }
    return ans;
}