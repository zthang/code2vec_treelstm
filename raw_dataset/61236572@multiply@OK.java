// my_no multiply(my_no obj){
// long num1=obj.num;
// long denom1=obj.denom;
// long num2=this.num;
// long denom2=this.denom;
// 
// }
my_no multiply(int no) {
    long n = num * no;
    long d = denom;
    long gcd = gcd(n, d);
    n /= gcd;
    d /= gcd;
    return new my_no(n, d);
}