public void solve(List<PriorityQueue> priorityQueueList) {
    Set<Integer> princes = new HashSet<>();
    // Set<Integer> availablePrinces = new HashSet<>();
    // Map<Integer, Boolean> daughter = new HashMap<>();
    boolean married = false;
    int daugIndex = -1;
    for (int i = 0; i < priorityQueueList.size(); i++) {
        // <Integer> p : priorityQueueList) {
        PriorityQueue<Integer> p = priorityQueueList.get(i);
        married = false;
        // daughter.put(daugIndex, false);
        while (!p.isEmpty()) {
            int prinId = p.poll();
            if (!married && !princes.contains(prinId)) {
                princes.add(prinId);
                married = true;
                // availablePrinces.remove(prinId);
                break;
            }
        // } else if (married && !princes.contains(prinId)) {
        // availablePrinces.add(prinId);
        // }
        }
        if (!married && daugIndex == -1)
            daugIndex = i;
    }
    if (princes.size() == priorityQueueList.size()) {
        System.out.println("OPTIMAL");
    } else {
        daugIndex++;
        System.out.println("IMPROVE");
        for (int pr = 1; pr <= 100000; pr++) if (!princes.contains(pr)) {
            System.out.println(daugIndex + " " + pr);
            break;
        }
    }
}