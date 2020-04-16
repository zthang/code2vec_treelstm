// ///////////------------------------------------//////////////
// //////////------------------Main-Logic--------//////////////
// /////////-------------------------------------//////////////
public void solve() {
    int t = sc.ni();
    while (t-- > 0) {
        int n = sc.ni();
        int[] arr = new int[n + 1];
        int[] visit = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = sc.ni();
        Stack<Integer> stk = new Stack();
        int x = 1;
        int p = 0;
        StringBuilder ans = new StringBuilder();
        while (true) {
            if (visit[x] == 1) {
                while (stk.peek() != x) {
                    p++;
                    ans.append(stk.pop() + " ");
                }
                ans.append(stk.pop());
                p++;
                break;
            } else {
                stk.push(x);
                visit[x] = 1;
                x = x - arr[x];
            }
        }
        pw.println(p + "\n" + ans);
    }
}