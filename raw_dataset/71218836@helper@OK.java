public static void helper(String[] arr, String res, int i) {
    if (i == arr.length) {
        if (res.equals("ababwxyzijjizyxwbaba")) {
            System.out.println(res);
        }
        if (res.length() == 20) {
            System.out.println(res);
        }
        if (isPalindrome(res)) {
            if (res.length() > ans.length()) {
                ans = res;
            }
        }
        return;
    }
    helper(arr, res + arr[i], i + 1);
    helper(arr, arr[i] + res, i + 1);
    helper(arr, res, i + 1);
}