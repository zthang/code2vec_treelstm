/**
 * ************************************Precision Printing*********************************************
 */
static void printPrecision(double d) {
    DecimalFormat ft = new DecimalFormat("0.000000000000");
    out.print(ft.format(d));
}