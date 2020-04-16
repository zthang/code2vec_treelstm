        private boolean findSolution(List<List<Long>> boxes, Set<Integer> remaining,
                                     Map<Long, Pair> next, List<Pair> solution,
                                     Pair curr) {
            if (curr == null) {
                for (int nextBoxId : remaining) {
                    remaining.remove(nextBoxId);
                    for (long x : boxes.get(nextBoxId)) {
                        if (next.containsKey(x) && findSolution(boxes, remaining, next,
                                solution, new Pair(x, nextBoxId))) {
                            return true;
                        }
                    }
                    remaining.add(nextBoxId);
                }
            } else if (remaining.contains(curr.boxId)) {
                remaining.remove(curr.boxId);
                Pair child = next.get(curr.value);
                if (remaining.contains(child.boxId)) {
                    if (next.containsKey(child.value) && findSolution(boxes, remaining,
                            next, solution, child)) {
                        solution.add(curr);
                        return true;
                    }
                } else if (remaining.size() > 0) {
                    if (findSolution(boxes, remaining, next, solution, null)) {
                        solution.add(curr);
                        return true;
                    }
                } else {
                    solution.add(curr);
                    return true;
                }
                remaining.add(curr.boxId);
            }
            return false;
        }