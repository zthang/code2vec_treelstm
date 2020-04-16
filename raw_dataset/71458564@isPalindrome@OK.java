private static boolean isPalindrome(String str) {
    StringBuilder sb = new StringBuilder();
    sb.append(str);
    String str1 = sb.reverse().toString();
    return str.equals(str1);
}