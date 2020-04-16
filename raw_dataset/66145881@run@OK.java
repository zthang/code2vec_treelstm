static void run() {
    int n = in.nextInt();
    DisjointUnionSets ds = new DisjointUnionSets(26);
    Set<Character> seen = new HashSet<>();
    while (n-- > 0) {
        char[] str = in.nextCharMap(1)[0];
        Set<Character> cs = new HashSet<>();
        for (char c : str) {
            cs.add(c);
            seen.add(c);
        }
        Character[] characters = cs.toArray(new Character[] {});
        for (int i = 0; i < characters.length; i++) {
            for (int j = i + 1; j < characters.length; j++) {
                ds.union(characters[i] - 'a', characters[j] - 'a');
            }
        }
    }
    Set<Integer> parents = new HashSet<>();
    seen.forEach((c) -> {
        parents.add(ds.find(c - 'a'));
    });
    System.out.println(parents.size());
}