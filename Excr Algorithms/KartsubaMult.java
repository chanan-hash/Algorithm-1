public class KartsubaMult {
    public static void main(String[] args) {
        int x = 5;
        int y = 3;
        int xMy = Kartsuba(x, y);
        System.out.println(xMy);
        System.out.println(Kartsuba(9, 12));
        System.out.println(Kartsuba(20, 10));
        System.out.println(Kartsuba(48, 72));
//        System.out.println(Math.log(Math.max(48,72)%10));
//        System.out.println((int)Math.ceil(Math.log(Math.max(48,72)%10))+1);
    }

    // O(n^1.58..)
    public static int Kartsuba(int x, int y) {
        if (x < 10 || y < 10) { // can be also if (x < 10 && y < 10). The "Or" operator can save us recursive calls, such as in case of 9,12
                                // The or immediately will do 9*12, and the "And" will do another recursive call to divide 12 again.
                                // we can see it in the debugger the differences
            return x * y;
        } else {
//            int n = (int) (Math.ceil(Math.log(Math.max(x, y) % 10))) + 1; // giving us the max num of digits
            int n = Math.max(numLength(x), numLength(y));
            int a = (int) (x / (Math.pow(10, n / 2)));     // left part of x
            int b = (int) (x % (Math.pow(10, n / 2)));     // right part of x
            int c = (int) (y / (Math.pow(10, n / 2)));     // left part of y
            int d = (int) (y % (Math.pow(10, n / 2)));     // right part of y

            int ac = Kartsuba(a, c); // remainder x*y = ac + (ad+bc) + bd
            int bd = Kartsuba(b, d); //(ad + bc) = (a+b)*(c+d) - ab - cd
            int ad_plus_bc = Kartsuba(a + b, c + d) - ac - bd; //(ad + bc) = (a+b)*(c+d) - ab - cd

            int product = (int) (ac * (Math.pow(10, 2 * (n / 2))) + (ad_plus_bc * (Math.pow(10, n / 2))) + bd); // calculating sum
            // ac * 10^(2*(n/2)) + ad_plus_bc * 10^(n/2) + bd
            return product;
        }
    }

    // from: https://www.geeksforgeeks.org/java-program-to-implement-the-karatsuba-multiplication-algorithm/
    // The methods help us to calculate the num of the digits of a given number
    public static int numLength(long n) {
        int noLen = 0;
        while (n > 0) {
            noLen++;
            n /= 10;
        }

        // Returning length of number n
        return noLen;
    }

}
