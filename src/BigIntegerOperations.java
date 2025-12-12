import java.math.BigInteger;
import java.util.Random;

public class BigIntegerOperations {
    //Task 2.1
    //Assumes n!=null
    //Returns the sum of positive integers smaller than n
    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum = null;
        // ---------------write your code BELOW this line only! ------------------
        if (n == null)
            throw new IllegalArgumentException("n is null");
        sum = new BigInteger("0");
        BigInteger current = new BigInteger("1");
        if (n.max(current).equals(n))
            while (!current.equals(n)) {
                sum = sum.add(current);
                current = current.add(BigInteger.ONE);
            }
        // ---------------write your code ABOVE this line only! ------------------
        return sum;
    }

    //Task 2.2
    //Assumes n>=0
    //prints n pseudo-random numbers
    public static void printRandoms(int n){
        // ---------------write your code BELOW this line only! ------------------
        if (n < 0)
            throw new IllegalArgumentException("n is negative");
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            System.out.println(random.nextInt());
        }
        // ---------------write your code ABOVE this line only! ------------------
    }

    //Task 2.3
    // Assumes n!=null and n>=0
    //Returns true iff n is a prime number
    public static boolean isPrime(BigInteger n){
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------
        if ((n == null) || (n.compareTo(BigInteger.ZERO) < 0))
            throw new IllegalArgumentException("n is invalid");
        BigInteger divider = new BigInteger("2");
        boolean isPrime = false;
        if (n.compareTo(divider) >= 0) {
            isPrime = true;
            while ((isPrime) && (n.compareTo(divider.pow(2)) >= 0)) {
                if (n.mod(divider).equals(BigInteger.ZERO))
                    isPrime = false;
                divider = divider.add(BigInteger.ONE);
            }
        }
        ans = isPrime;
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 2.4
    //Assumes n>1
    //Returns a randomly chosen prime number, smaller than 2^n
    public static BigInteger randomPrime(int n){
        BigInteger myRand = null;
        // ---------------write your code BELOW this line only! ------------------
        if (n <= 1)
            throw new IllegalArgumentException("n has to be greater than 1");
        boolean isPrime = false;
        while (!isPrime) {
            Random random = new Random();
            myRand = new BigInteger(n, random);
            isPrime = isPrime(myRand);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return myRand;
    }

    //Task 2.5
    // No assumptions
    //Returns false if primes==null, or is not sorted, or includes duplicates, or includes a composite number
    public static boolean isValidPrimesArray(BigInteger[] primes) {
        boolean isValid = true; // Assume the array is valid initially
        // ---------------write your code BELOW this line only! ------------------
        if (primes == null)
            isValid = false;
        else if (primes.length > 0) {
            BigInteger prev = primes[0];
            isValid = isPrime(prev);
            for (int i = 1; (i < primes.length) && (isValid); i++) {
                isValid = ((isPrime(primes[i])) && (primes[i].compareTo(prev) > 0));
                prev = primes[i];
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return isValid;
    }


    //Task 2.6
    //Assumes primes != null, n !=null, and n>1. 'primes' is sorted, and includes only unique prime numbers.
    //Returns true iff n can be expressed as a product of prime numbers from primes
    public static boolean canFactorizeToTarget(BigInteger[] primes, BigInteger n) {
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------
        if ((n == null) || (n.compareTo(BigInteger.ONE) <= 0) || (!isValidPrimesArray(primes)))
            throw new IllegalArgumentException("input is invalid");
        ans = canFactorizeToTarget(primes, n, BigInteger.ZERO, 0);
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Helper for task 2.6
    //Assumes primes != null, n !=null, n>1 and currentI >= 0. 'primes' is sorted, and includes only unique prime numbers.
    //Returns true iff n can be expressed as a product of prime numbers from primes
    public static boolean canFactorizeToTarget(BigInteger[] primes, BigInteger n, BigInteger remain, int currentI) {
        boolean ans = false;
        if (remain.equals(BigInteger.ZERO)) {
            ans = n.compareTo(BigInteger.ONE) == 0;
            if ((n.compareTo(BigInteger.ONE) > 0) && (currentI < primes.length)) {
                BigInteger currentB = primes[currentI];
                boolean firstC = canFactorizeToTarget(primes, n.divide(currentB), n.remainder(currentB), currentI);
                boolean secondC = canFactorizeToTarget(primes, n.divide(currentB), n.remainder(currentB), currentI + 1);
                boolean thirdC = canFactorizeToTarget(primes, n, remain, currentI + 1);
                ans = firstC ||  secondC || thirdC;
            }
        }
        return ans;
    }


    //Task 2.7
    //Assumes primes != null, n !=null, and n>1. 'primes' is sorted, and includes only unique prime numbers.
    //If n can be expressed as a product of prime numbers from primes, it prints the numbers in the factorization
    public static void printFactorization(BigInteger[] primes, BigInteger n) {
        // ---------------write your code BELOW this line only! ------------------
        if ((n == null) || (n.compareTo(BigInteger.ONE) <= 0) || (!isValidPrimesArray(primes)))
            throw new IllegalArgumentException("input is invalid");
        if (canFactorizeToTarget(primes, n))
            printFactorization(primes, n, BigInteger.ZERO, 0, "");
        // ---------------write your code ABOVE this line only! ------------------
    }

    //Helper for task 2.7
    //Assumes primes != null, n !=null, n>1 and currentI >= 0. 'primes' is sorted, and includes only unique prime numbers.
    //If n can be expressed as a product of prime numbers from primes, it prints the numbers in the factorization
    public static void printFactorization(BigInteger[] primes, BigInteger n, BigInteger remain, int currentI, String ans) {
        if (remain.equals(BigInteger.ZERO))
            if ((n.compareTo(BigInteger.ONE) > 0) && (currentI < primes.length)) {
                BigInteger currentB = primes[currentI];
                BigInteger dividedN = n.divide(currentB);
                BigInteger remainderN = n.remainder(currentB);
                if ((dividedN.equals(BigInteger.ONE)) && (remainderN.equals(BigInteger.ZERO)))
                    System.out.println(ans + currentB);
                else {
                    printFactorization(primes, dividedN, remainderN, currentI, ans + currentB + ",");
                    printFactorization(primes, n, remain, currentI + 1, ans);
                }
            }
    }

}
