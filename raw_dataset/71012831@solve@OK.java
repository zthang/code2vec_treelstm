public static void solve() {
    int n = s.nextInt();
    int m = s.nextInt();
    int k = s.nextInt();
    int total = 4 * n * m - 2 * n - 2 * m;
    if (total < k) {
        out.println("NO");
        return;
    }
    out.println("YES");
    ArrayList<String> ans = new ArrayList<String>();
    ArrayList<Integer> count = new ArrayList<Integer>();
    total = 0;
    boolean flag = false;
    // going down
    outerloop: for (int i = 0; i < n - 1; i++) {
        int tempcount = 0;
        String temp;
        if ((i & 1) == 0) {
            temp = "DUR";
        } else {
            temp = "DUL";
        }
        int temptempcount = 0;
        for (int j = 0; j < m - 1; j++) {
            if (total + tempcount + 3 <= k) {
                tempcount += 3;
                temptempcount++;
            } else {
                total += tempcount;
                if (temptempcount != 0) {
                    ans.add(temp);
                    count.add(temptempcount);
                }
                if (total == k) {
                    flag = true;
                    break outerloop;
                }
                for (int x = 0; x < 3; x++) {
                    if (total + 1 == k) {
                        StringBuilder z = new StringBuilder();
                        z.append(temp.charAt(x));
                        ans.add(z.toString());
                        count.add(1);
                        flag = true;
                        break outerloop;
                    } else {
                        StringBuilder z = new StringBuilder();
                        z.append(temp.charAt(x));
                        ans.add(z.toString());
                        count.add(1);
                    }
                    total++;
                }
            }
        }
        total += tempcount;
        if (temptempcount != 0) {
            ans.add(temp);
            count.add(temptempcount);
        }
        if (total == k) {
            flag = true;
            break;
        }
        total++;
        ans.add("D");
        count.add(1);
        if (total == k) {
            flag = true;
            break;
        }
    }
    if (flag) {
        Print(ans, count);
        return;
    }
    // going horizontal
    String temp;
    if ((n - 1) % 2 == 0) {
        temp = "R";
    } else {
        temp = "L";
    }
    int tempcount = 0;
    for (int i = 0; i < m - 1; i++) {
        tempcount++;
        if (total + tempcount == k) {
            ans.add(temp);
            count.add(tempcount);
            flag = true;
            break;
        }
    }
    if (flag) {
        Print(ans, count);
        return;
    }
    ans.add(temp);
    count.add(tempcount);
    total += tempcount;
    outerloop: for (int i = n - 1; i >= 0; i--) {
        if (i % 2 == 0) {
            temp = "L";
        } else {
            temp = "R";
        }
        tempcount = 0;
        for (int j = 0; j < m - 1; j++) {
            for (int x = 0; x < 1; x++) {
                tempcount++;
                if (total + tempcount == k) {
                    ans.add(temp);
                    count.add(tempcount);
                    flag = true;
                    break outerloop;
                }
            }
        }
        total += tempcount;
        ans.add(temp);
        ;
        count.add(tempcount);
        total++;
        ans.add("U");
        count.add(1);
        if (total == k) {
            flag = true;
            break;
        }
    }
    Print(ans, count);
}