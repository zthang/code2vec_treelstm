private static void getRes(PrintWriter w, String s) {
    int l = Integer.parseInt(s.split(" ")[0]);
    s = s.split(" ")[1];
    int min = 1;
    int max = l;
    StringBuilder longest = new StringBuilder();
    int[] longg = new int[l];
    for (int i = l - 2; i >= 0; i--) {
        char c = s.charAt(i);
        if (c == '<') {
            longg[i + 1] = max--;
        } else {
            longg[i + 1] = min++;
        }
    }
    longg[0] = max;
    for (int num : longg) {
        longest.append(num + " ");
    }
    max = l;
    int count = 0;
    int index = 0;
    StringBuilder shortest = new StringBuilder();
    while (index < s.length()) {
        if (s.charAt(index) == '>') {
            shortest.append(max-- + " ");
            index++;
        } else {
            while (index < s.length() && s.charAt(index) == '<') {
                count++;
                index++;
            }
            int temp = max - count - 1;
            while (count > 0) {
                shortest.append(max - count + " ");
                count--;
            }
            index++;
            shortest.append(max + " ");
            max = temp;
        }
    }
    if (max == 1) {
        shortest.append(max);
    }
    w.println(shortest.toString().trim());
    w.println(longest.toString().trim());
}