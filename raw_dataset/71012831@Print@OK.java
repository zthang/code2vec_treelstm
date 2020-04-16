public static void Print(ArrayList<String> ans, ArrayList<Integer> count) {
    int count_ = 0;
    for (int i = 0; i < ans.size(); i++) {
        if (count.get(i) != 0) {
            count_++;
        // out.println(count.get(i)+" "+ans.get(i));
        }
    }
    out.println(count_);
    for (int i = 0; i < ans.size(); i++) {
        if (count.get(i) != 0) {
            out.println(count.get(i) + " " + ans.get(i));
        }
    }
}