static void combine(String instr, StringBuffer outstr, int index, int k) {
    if (outstr.length() == k) {
        list1.add(outstr.toString());
        return;
    }
    if (outstr.toString().length() == 0)
        outstr.append(instr.charAt(index));
    for (int i = 0; i < instr.length(); i++) {
        outstr.append(instr.charAt(i));
        combine(instr, outstr, i + 1, k);
        outstr.deleteCharAt(outstr.length() - 1);
    }
    index++;
}