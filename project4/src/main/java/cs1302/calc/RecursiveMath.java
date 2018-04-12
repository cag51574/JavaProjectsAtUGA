package cs1302.calc;

/* Implement the Math interface using recursion here. For each method, replace
 * the throw statement with your implementation.
 */

/**
 * REPLACE ME WITH ACTUAL JAVADOC FOR THIS CLASS.
 *
 * @author AUTHOR
 */
public class RecursiveMath implements Math {
    int count = 0;

    public int inc(int n) {
	return n + 1;
        //throw new UnsupportedOperationException();
    } // inc

    public int dec(int n) {
	if(n==0) return 0;
	return n - 1;
        //throw new UnsupportedOperationException();
    } // dec

    public int add(int lhs, int rhs) {
	if(rhs == 0) return lhs;
	return add(inc(lhs),dec(rhs));
        //throw new UnsupportedOperationException();
    } // add

    public int sub(int lhs, int rhs) {
	if(rhs == 0) return lhs;
	return sub(dec(lhs),dec(rhs));
        //throw new UnsupportedOperationException();
    } // sub

    public int mul(int lhs, int rhs) {
	if(rhs == 0) return 0;
	if(rhs == 1) return lhs;
	if(lhs == 1) return rhs;
	return mul(add(lhs,lhs),dec(rhs));
        //throw new UnsupportedOperationException();
    } // mul

    public int div(int lhs, int rhs) {
        if(rhs == 0) throw new ArithmeticException();
        if(lhs < 1) {
	    lhs = count;
	    count = 0;
	    return lhs;
	}
        if(lhs < rhs) return count;
        //if(rhs == 1) return lhs;
	System.out.println(count);
	count =inc(count);
	return div(sub(lhs,rhs),rhs);
        //throw new UnsupportedOperationException();
    } // div

    public int fac(int n) {
	if(n == 1 || n == 0) return 1;
	return mul(n,fac(dec(n)));
        //throw new UnsupportedOperationException();
    } // fac

    public int pow(int lhs, int rhs) {
	if(rhs == 0) return 1;
	if(rhs == 1) return lhs;
	return mul(pow(lhs,dec(rhs)),lhs);
        //throw new UnsupportedOperationException();
    } // pow

} // RecursiveMath
