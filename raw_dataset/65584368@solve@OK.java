public static void solve() {
    // Input
    int nodeCount = in.nextInt();
    int steelChainsNeeded = in.nextInt();
    // Keep track of fridges
    ArrayList<Fridge> fridges = new ArrayList<>();
    for (int i = 0; i < nodeCount; i++) {
        fridges.add(new Fridge(i + 1, in.nextInt()));
    }
    fridges.sort(Comparator.comparingInt(f -> f.cost));
    // We need at least nodeCount steel chains
    if (nodeCount != steelChainsNeeded) {
        System.out.println("-1");
        return;
    }
    if (nodeCount <= 2) {
        System.out.println("-1");
        return;
    }
    int cost = fridges.stream().mapToInt(f -> f.cost).sum() * 2;
    System.out.println(cost);
    Fridge prev = fridges.get(fridges.size() - 1);
    for (Fridge fridge : fridges) {
        System.out.println(prev.id + " " + fridge.id);
        prev = fridge;
    }
}