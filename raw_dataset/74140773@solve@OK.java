public void solve(List<PriorityQueue> priorityQueueList) {
    Set<Integer> princes = new HashSet<>();
    Set<Integer> availablePrinces = new HashSet<>();
    Map<Integer, Boolean> daughter = new HashMap<>();
    boolean married = false;
    int daugIndex = 1;
    for (PriorityQueue<Integer> p : priorityQueueList) {
        married = false;
        daughter.put(daugIndex, false);
        while (!p.isEmpty()) {
            int prinId = p.poll();
            if (!married && !princes.contains(prinId)) {
                princes.add(prinId);
                married = true;
                daughter.put(daugIndex, true);
                availablePrinces.remove(prinId);
            } else if (married && !princes.contains(prinId)) {
                availablePrinces.add(prinId);
            }
        }
        daugIndex++;
    }
    if (princes.size() == priorityQueueList.size()) {
        System.out.println("OPTIMAL");
    } else {
        System.out.println("IMPROVE");
        for (Map.Entry<Integer, Boolean> mp : daughter.entrySet()) {
            if (!mp.getValue()) {
                if (!availablePrinces.isEmpty()) {
                    int prkey = availablePrinces.iterator().next();
                    System.out.println(mp.getKey() + " " + prkey);
                    availablePrinces.remove(prkey);
                    break;
                } else {
                    for (int pr = 1; pr <= 100000; pr++) if (!princes.contains(pr)) {
                        System.out.println(mp.getKey() + " " + pr);
                        break;
                    }
                    break;
                }
            }
        }
    }
}