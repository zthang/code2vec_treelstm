static void solve(Scanner scanner) {
    int T = Integer.parseInt(scanner.nextLine());
    WeightedUnionFindTree uft = new WeightedUnionFindTree(26);
    for (int i = 0; i < T; i++) {
        String s = scanner.nextLine();
        LinkedHashSet<Integer> used = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            int n = c - 'a';
            uft.activate(n);
            if (used.add(n)) {
                used.forEach(x -> uft.merge(n, x));
            }
        }
    }
    Set<Integer> roots = new HashSet<>();
    for (int i = 0; i < 26; i++) {
        if (uft.activated(i)) {
            roots.add(uft.par[i]);
        }
    }
    System.out.println(roots.size());
}