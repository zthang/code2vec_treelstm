private static void isOptimal(int n, BufferedReader br, BufferedWriter bw) throws IOException {
    HashSet<Integer> hs = new HashSet<Integer>();
    int available = -1;
    for (int j = 0; j < n; j++) {
        String[] row = br.readLine().split(" ");
        int wishLength = Integer.parseInt(row[0]);
        boolean flag = true;
        for (int i = 0; i < wishLength; i++) {
            int x = Integer.parseInt(row[i + 1]);
            if (hs.contains(x) == false) {
                flag = false;
                hs.add(x);
                break;
            }
        }
        if (flag == true && available == -1) {
            available = j + 1;
        }
    }
    if (hs.size() == n) {
        bw.write("OPTIMAL" + "\n");
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (hs.contains(i) == false) {
            bw.write("IMPROVE" + "\n");
            bw.write(available + " " + i + "\n");
            break;
        }
    }
}