package cs1302.calc;

/* Implement the Math interface using iteration here. For each method, replace
 * the throw statement with your implementation.
 */

/**
 * REPLACE ME WITH ACTUAL JAVADOC FOR THIS CLASS.
 *
 * @author AUTHOR
 */
public class IterativeMath implements Math {

    public int inc(int n) {
	return n + 1;
        //throw new UnsupportedOperationException();
    } // inc

    public int dec(int n) {
	if(n == 0) return 0;
	return n - 1;
        //throw new UnsupportedOperationException();
    } // dec

    public int add(int lhs, int rhs) {
	int sum = lhs;
	while (rhs > 0) {
	    sum = inc(sum);
	    rhs = dec(rhs);
	} // while
	return sum;
        //throw new UnsupportedOperationException();
    } // add

    public int sub(int lhs, int rhs) {
	int diff = lhs;
	while (rhs > 0) {
	    diff = dec(diff);
	    rhs = dec(rhs);
	} // while
	return diff;
        //throw new UnsupportedOperationException();
    } // sub

    public int mul(int lhs, int rhs) {
	if(rhs == 0) return 0;
	int prod = lhs;
	while (rhs > 1) {
	    prod = add(prod,lhs);
	    rhs = dec(rhs);
	} // while
	return prod;
        //throw new UnsupportedOperationException();
    } // mul

    public int div(int lhs, int rhs) {
        if(rhs == 0) throw new ArithmeticException();
        if((lhs == 0) || (lhs < rhs)) return 0;
        if(rhs == 1) return lhs;
	int quot = 0;
	while (lhs > 1) {
	    lhs = sub(lhs,rhs);
	    quot = inc(quot);
	} // while
	return quot;
    } // div

    public int fac(int n) {
	if(n < 2) return 1;
	int fact = n;
	while(n != 1){
	    n = dec(n);
	    fact = mul(fact,n);
	}
	return fact;
	    //throw new UnsupportedOperationException();
    } // fac

    public int pow(int lhs, int rhs) {
	if(lhs == 0) return 0;
	if(rhs == 0) return 1;
	int p = lhs;
	while(rhs > 1){
	    p = mul(p, lhs);
	    rhs = dec(rhs);
	}
	return p;
        //throw new UnsupportedOperationException();
    } // pow

} // IterativeMath
