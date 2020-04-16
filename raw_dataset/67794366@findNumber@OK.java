// This function returns the number having
// maximum product of the digits
static long findNumber(long l, long r) {
    // Converting both integers to strings
    // string a = l.ToString();
    String b = Long.toString(r);
    // Let the current answer be r
    long ans = r;
    for (int i = 0; i < b.length(); i++) {
        if (b.charAt(i) == '0')
            continue;
        // Stores the current number having
        // current digit one less than current
        // digit in b
        char[] curr = b.toCharArray();
        curr[i] = (char) (((int) (curr[i] - (int) '0') - 1) + (int) ('0'));
        // to maximise the product
        for (int j = i + 1; j < curr.length; j++) curr[j] = '9';
        // Convert string to number
        int num = 0;
        for (int j = 0; j < curr.length; j++) num = num * 10 + (curr[j] - '0');
        // is greater than max product
        if (num >= l && product(ans) < product(num))
            ans = num;
    }
    return product(ans);
}