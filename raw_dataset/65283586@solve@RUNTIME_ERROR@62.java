        public void solve(InputReader in, PrintWriter out, boolean debug) {
            int k = in.nextInt();
            List<List<Long>> boxes = new ArrayList<>();
            Map<Long, Integer> revBoxMap = new HashMap<>();
            long totSum = 0;
            long[] boxSums = new long[k];
            for (int i = 0; i < k; i++) {
                List<Long> box = new ArrayList<>();
                int n = in.nextInt();
                for (int j = 0; j < n; j++) {
                    long a = in.nextLong();
                    totSum += a;
                    boxSums[i] += a;
                    box.add(a);
                    revBoxMap.put(a, i);
                }
                boxes.add(box);
            }
            if (totSum % k != 0) {
                out.println("No");
            } else {
                long boxSum = totSum / k;
                long[] delta = new long[k];
                for (int i = 0; i < k; i++) {
                    delta[i] = boxSum - boxSums[i];
                }
                if (debug) {
                    out.println("boxSum=" + boxSum);
                    out.println("boxSums=" + Arrays.toString(boxSums));
                    out.println("delta=" + Arrays.toString(delta));
                }
                Map<Long, Pair> nextValue = new HashMap<>();
                Set<Pair> remaining = new HashSet<>();
                for (int i = 0; i < k; i++) {
                    for (long boxVal : boxes.get(i)) {
                        long nextVal = boxVal + delta[i];
                        if (revBoxMap.containsKey(nextVal)) {
                            int nextBoxId = revBoxMap.get(nextVal);
                            if (nextBoxId != i || nextVal == boxVal) {
                                nextValue.put(boxVal, new Pair(nextVal, nextBoxId));
                                remaining.add(new Pair(boxVal, i));
                            }
                        }
                    }
                }
                if (debug) {
                    out.println("nextValue=" + nextValue);
                }
                Map<Integer, List<Pair>> cycles = new HashMap<>();
                Set<Pair> visited = new HashSet<>();
                while (remaining.size() > 0) {
                    Pair top = remaining.iterator().next();
                    visited.add(top);
                    while (nextValue.containsKey(top.value) && remaining.contains(
                            nextValue.get(top.value))) {
                        Pair child = nextValue.get(top.value);
                        if (visited.contains(child)) {
                            int cycleId = 0;
                            List<Pair> cycleElements = new ArrayList<>();
                            Pair curr = nextValue.get(top.value);
                            do {
                                cycleId += 1 << curr.boxId;
                                cycleElements.add(curr);
                                remaining.remove(curr);
                                curr = nextValue.get(curr.value);
                            } while (curr != child);
                            cycles.put(cycleId, cycleElements);
                            break;
                        } else {
                            visited.add(child);
                            top = child;
                        }
                    }
                    remaining.remove(top);
                }
                if (debug) {
                    out.print("Cycles=");
                    for (int cycleId : cycles.keySet()) {
                        out.print(Integer.toBinaryString(cycleId) + "=" + cycles.get(
                                cycleId) + ", ");
                    }
                    out.println();
                }
                int max = (1 << k) - 1;
                boolean[] covered = new boolean[max + 1];
                int[] subCover = new int[max + 1];
                covered[0] = true;
                for (int i = 0; i <= max; i++) {
                    for (int j = i; j >= 0; j = (j - 1) & i) {
                        if (cycles.containsKey(j) && covered[i & (~j)]) {
                            if (debug) {
                                out.println("Covered " + Integer.toBinaryString(i));
                            }
                            subCover[i] = j;
                            covered[i] = true;
                            break;
                        }
                        if (j == 0) { break; }
                    }
                }
                if (covered[max]) {
                    out.println("Yes");
                    Queue<Integer> bfs = new LinkedList<>();
                    List<Pair> solution = new ArrayList<>();
                    bfs.add(max);
                    while (bfs.size() > 0) {
                        int top = bfs.poll();
                        if (cycles.containsKey(top)) {
                            solution.addAll(cycles.get(top));
                        } else {
                            int sc = subCover[top];
                            bfs.add(sc);
                            bfs.add(top & (~sc));
                        }
                    }
                    int[] prev = new int[k];
                    for (Pair p : solution) {
                        prev[nextValue.get(p.value).boxId] = p.boxId;
                        if (debug) {
                            out.println(p + " <- " + nextValue.get(p.value));
                        }
                    }
                    solution.stream().sorted(
                            Comparator.comparing(p -> p.boxId)).forEachOrdered(
                            p -> out.println(p.value + " " + (prev[p.boxId] + 1)));
                } else {
                    out.println("No");
                }
            }

        }