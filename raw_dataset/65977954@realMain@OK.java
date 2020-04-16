public void realMain() throws Exception {
    BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);
    String in = fin.readLine();
    String[] ar = in.split(" ");
    int n = Integer.parseInt(ar[0]);
    boolean[][] has = new boolean[n][26];
    boolean[] isused = new boolean[26];
    for (int i = 0; i < n; i++) {
        in = fin.readLine();
        for (int j = 0; j < in.length(); j++) {
            has[i][in.charAt(j) - 'a'] = true;
            isused[in.charAt(j) - 'a'] = true;
        }
    }
    ArrayList<LetterNode> letternodes = new ArrayList<LetterNode>();
    for (int i = 0; i < 26; i++) {
        letternodes.add(new LetterNode(i));
    }
    boolean[][] conn = new boolean[26][26];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 26; j++) {
            if (!has[i][j]) {
                continue;
            }
            for (int k = 0; k < 26; k++) {
                if (j != k && has[i][k] && !conn[j][k]) {
                    // System.out.println("added: " + j + ", " + k);
                    conn[j][k] = true;
                    conn[k][j] = true;
                    letternodes.get(j).children.add(letternodes.get(k));
                    letternodes.get(k).children.add(letternodes.get(j));
                }
            }
        }
    }
    boolean[] visited = new boolean[26];
    int[] color = new int[26];
    int curcolor = 1;
    for (int i = 0; i < 26; i++) {
        if (!isused[i]) {
            continue;
        }
        if (!visited[i]) {
            ArrayList<Integer> queue = new ArrayList<Integer>();
            queue.add(i);
            while (queue.size() > 0) {
                int curi = queue.remove(0);
                color[curi] = curcolor;
                visited[curi] = true;
                for (LetterNode child : letternodes.get(curi).children) {
                    if (!visited[child.letter]) {
                        queue.add(child.letter);
                        visited[child.letter] = true;
                    }
                }
            }
            curcolor++;
        }
    }
    // System.out.println(letternodes.get(0));
    // System.out.println(letternodes.get(1));
    // System.out.println(letternodes.get(2));
    // System.out.println(letternodes.get(4));
    System.out.println(curcolor - 1);
}