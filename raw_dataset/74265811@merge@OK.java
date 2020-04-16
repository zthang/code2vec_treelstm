static public void merge(int[][] arr) {
    int n = arr[0].length;
    aksh[] a = new aksh[n];
    for (int i = 0; i < n; i++) a[i] = new aksh(arr[i][0], arr[i][1]);
    Arrays.sort(a);
    Stack<aksh> s = new Stack<>();
    s.push(a[0]);
    for (int i = 1; i < n; i++) {
        aksh temp = s.peek();
        if (temp.y > a[i].x) {
            temp.y = a[i].y;
            s.pop();
            s.push(temp);
        } else if (temp.y < a[i].x) {
            s.push(a[i]);
            System.out.println("hii");
        }
    }
    int size = s.size();
    int[][] ans = new int[size][2];
    int j = 0;
    while (!s.isEmpty()) {
        aksh temp = s.pop();
        ans[j][0] = temp.x;
        ans[j][1] = temp.y;
        j++;
    }
}