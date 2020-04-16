// class code
// public class Solution
static void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int[] a = new int[n + 1];
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        a[i] = nextInt();
        sum += a[i];
    }
    if (m < n || n == 2) {
        out.println(-1);
        return;
    }
    out.println(2 * sum);
    for (int i = 1; i <= n - 1; i++) out.println(i + " " + (i + 1));
    out.println(n + " " + 1);
}