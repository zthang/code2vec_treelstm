private static void solve() {
    HashSet<Character> seenChars = new HashSet<>();
    int[] forrest = new int[ALPHABET];
    int[] forrestRank = new int[ALPHABET];
    for (int i = 0; i < ALPHABET; i++) {
        forrest[i] = i;
        forrestRank[i] = 1;
    }
    for (int i = 0; i < N; i++) {
        // System.out.println("---");
        HashSet<Character> chars = new HashSet<>();
        for (char ch : passes[i].toCharArray()) {
            chars.add(ch);
            seenChars.add(ch);
        }
        for (char from : chars) {
            for (char to : chars) {
                // System.out.println(from + " - " + to);
                union(forrest, forrestRank, from - 'a', to - 'a');
            }
        }
    }
    HashSet<Integer> trees = new HashSet<>();
    for (char ch : seenChars) {
        // System.out.println(ch + " :: " + find(forrest, ch-'a'));
        trees.add(find(forrest, ch - 'a'));
    }
    sb.append(trees.size());
}