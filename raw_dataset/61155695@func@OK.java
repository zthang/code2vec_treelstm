private void func(int curr, HashMap<Integer, Integer> map, int n, CAnadiAndDomino.Edge[] arr, CAnadiAndDomino.ans ans1) {
    if (curr == n + 1) {
        ans1.a = Math.max(ans1.a, func1(map, arr));
        return;
    }
    for (int i = 1; i <= 6; i++) {
        map.put(curr, i);
        func(curr + 1, map, n, arr, ans1);
    }
}