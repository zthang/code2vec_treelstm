long check(int color1, int color2, int color3) {
    long ans = 0;
    for (int i = 0; i < n; i++) {
        if (i % 3 == 0) {
            if (color1 == 1) {
                ans += arr[mas.get(i)].a;
            } else if (color1 == 2) {
                ans += arr[mas.get(i)].b;
            } else {
                ans += arr[mas.get(i)].c;
            }
        } else if (i % 3 == 1) {
            if (color2 == 1) {
                ans += arr[mas.get(i)].a;
            } else if (color2 == 2) {
                ans += arr[mas.get(i)].b;
            } else {
                ans += arr[mas.get(i)].c;
            }
        } else {
            if (color3 == 1) {
                ans += arr[mas.get(i)].a;
            } else if (color3 == 2) {
                ans += arr[mas.get(i)].b;
            } else {
                ans += arr[mas.get(i)].c;
            }
        }
    }
    return ans;
}