public void solve() throws IOException {
    int n = readInt();
    int m = readInt();
    int k = readInt();
    int val = 4 * n * m - 2 * n - 2 * m;
    if (k > val)
        out.println("NO");
    else {
        out.println("YES");
        int count = k;
        int jl = 0;
        String[] arr = new String[1000001];
        if (n == 1) {
            if (count <= m - 1) {
                arr[jl] = count + " R";
                jl++;
            } else {
                arr[jl] = ((m - 1) + " R");
                jl++;
                arr[jl] = ((count - m + 1) + " L");
                jl++;
            }
        } else if (m == 1) {
            if (count <= n - 1) {
                arr[jl] = ((n - 1) + " D");
                jl++;
            } else {
                arr[jl] = ((n - 1) + " D");
                jl++;
                arr[jl] = ((count - n + 1) + " U");
                jl++;
            }
        } else {
            if (count < m - 1) {
                arr[jl] = (count + " R");
                jl++;
                count = 0;
            } else {
                arr[jl] = ((m - 1) + " R");
                jl++;
                count = count - m + 1;
            }
            if (count != 0) {
                if (count < m - 1) {
                    arr[jl] = (count + " L");
                    jl++;
                    count = 0;
                } else {
                    arr[jl] = ((m - 1) + " L");
                    jl++;
                    count = count - m + 1;
                }
            }
            int i = 1;
            while (count > 0 && i < n) {
                if (count > 0) {
                    arr[jl] = (1 + " D");
                    jl++;
                    count--;
                } else
                    break;
                if (count == 0)
                    break;
                int z = count / 3;
                int rem = count % 3;
                if (z >= m - 1) {
                    z = m - 1;
                    rem = 0;
                }
                if (z != 0) {
                    arr[jl] = (z + " RUD");
                    jl++;
                }
                count = count - 3 * z;
                if (count == 0)
                    break;
                if (rem == 1) {
                    count--;
                    arr[jl] = (1 + " R");
                    jl++;
                } else if (rem == 2) {
                    count = count - 2;
                    arr[jl] = (1 + " RU");
                    jl++;
                }
                if (count == 0)
                    break;
                if (count < m - 1) {
                    arr[jl] = (count + " L");
                    jl++;
                    count = 0;
                } else {
                    arr[jl] = ((m - 1) + " L");
                    jl++;
                    count = count - m + 1;
                }
                i++;
            }
            if (count > 0) {
                arr[jl] = (count + " U");
                jl++;
                count = 0;
            }
        }
        out.println(jl);
        for (int i1 = 0; i1 < jl; i1++) out.println(arr[i1]);
    }
}