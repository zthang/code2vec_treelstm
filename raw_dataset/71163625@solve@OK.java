void solve() throws IOException {
    int t = readInt();
    for (int ti = 0; ti < t; ti++) {
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        char[] s = line[1].toCharArray();
        // (1)
        List<Integer> numUpsUntilDown = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '>') {
                numUpsUntilDown.add(count);
                count = 0;
            } else {
                count++;
            }
        }
        numUpsUntilDown.add(count);
        List<Integer> ans = new ArrayList<>();
        int curr = 0;
        ans.add(curr);
        for (int x : numUpsUntilDown) {
            ans.add(curr - 1 - x);
            for (int j = curr - x; j <= curr - 1; j++) ans.add(j);
            curr = curr - 1 - x;
        }
        ans.remove(0);
        int min = ans.get(0);
        for (int i : ans) min = Math.min(min, i);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) - min + 1);
        }
        for (int i : ans) pw.print(i + " ");
        pw.println();
        // (2)
        List<Integer> numDownsUntilUp = new ArrayList<>();
        count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '<') {
                numDownsUntilUp.add(count);
                count = 0;
            } else {
                count++;
            }
        }
        numDownsUntilUp.add(count);
        ans.clear();
        curr = 0;
        ans.add(curr);
        for (int x : numDownsUntilUp) {
            ans.add(curr + 1 + x);
            for (int j = curr + x; j >= curr + 1; j--) ans.add(j);
            curr = curr + 1 + x;
        }
        ans.remove(0);
        min = ans.get(0);
        for (int i : ans) min = Math.min(min, i);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) - min + 1);
        }
        for (int i : ans) pw.print(i + " ");
        pw.println();
    }
}