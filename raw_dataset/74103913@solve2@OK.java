void solve2() {
    int n = in.nextInt();
    List<List<Integer>> girls = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        int k = in.nextInt();
        List<Integer> boys = Arrays.stream(in.nextInts(k)).boxed().collect(Collectors.toList());
        girls.add(boys);
    }
    Set<Integer> marriedBoys = new HashSet<>();
    Set<Integer> notMarriedGirls = new HashSet<>();
    for (int i = 0; i < girls.size(); i++) {
        List<Integer> boys = girls.get(i);
        int girl = i + 1;
        int myBoy = -1;
        for (int boy : boys) {
            if (!marriedBoys.contains(boy)) {
                myBoy = boy;
                break;
            }
        }
        if (myBoy != -1) {
            marriedBoys.add(myBoy);
        } else {
            notMarriedGirls.add(girl);
        }
    }
    if (marriedBoys.size() != n) {
        for (int i = 1; i <= n; i++) {
            if (!marriedBoys.contains(i)) {
                out.println("IMPROVE");
                out.println(notMarriedGirls.toArray()[0] + " " + i);
                break;
            }
        }
    } else {
        out.println("OPTIMAL");
    }
}