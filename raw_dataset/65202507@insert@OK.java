public static int insert(ArrayList<Interval> intervals) {
    Comparator<Interval> cpm = (o1, o2) -> o1.start - o2.start;
    intervals.sort(cpm);
    int ans = 0;
    int i = 0;
    int j = i + 1;
    while (j < intervals.size()) {
        if (intervals.get(j).start <= intervals.get(i).end) {
            if (intervals.get(j).end > intervals.get(i).end) {
                intervals.get(i).end = intervals.get(j).end;
            }
            ans++;
            j++;
        } else {
            i = j;
            j++;
        }
    }
    return ans;
}