// ///////////------------------------------------//////////////
// //////////------------------Main-Logic--------//////////////
// /////////-------------------------------------//////////////
public void solve() {
    int t = sc.ni();
    while (t-- > 0) {
        int n = sc.ni();
        char[] arr = sc.next().toCharArray();
        int[] brr = new int[n];
        Arrays.fill(brr, -1);
        int[] crr = new int[n];
        Arrays.fill(crr, -1);
        int p = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == '>') {
                int k = i;
                while (k < (n - 1) && arr[k] == '>') k++;
                int l = k;
                while (k >= i) brr[k--] = p++;
                i = l - 1;
            } else {
                if (brr[i] == -1)
                    brr[i] = p++;
            }
        }
        if (brr[n - 1] == -1)
            brr[n - 1] = p++;
        p = n;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == '<') {
                int k = i;
                while (k < (n - 1) && arr[k] == '<') k++;
                int l = k;
                while (k >= i) crr[k--] = p--;
                i = l - 1;
            } else {
                if (crr[i] == -1)
                    crr[i] = p--;
            }
        }
        if (crr[n - 1] == -1)
            crr[n - 1] = p--;
        for (int i = 0; i < n; i++) pw.print(crr[i] + " ");
        pw.println("");
        for (int i = 0; i < n; i++) pw.print(brr[i] + " ");
        pw.println("");
    }
}