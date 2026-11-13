/**
 * Utility Class for generating the lowest set of twin primes between two numbers
 * @author Amanda Migliori
 */
public class TwinPrimeGenerator {

    /**
     * Brute force method for finding a set of twin primes between 2 bounds
     * @param min lower bound of searching
     * @param max upper bound for searching
     * @return the Maximum of a set of twin primes found between the given bounds, or 0 if no twin primes exist between the 2
     */
    public static int generateTwinPrime(int min, int max) {

        if(min%2 ==0) {
            min++;
        }
        for(int i = min+2; i < max; i = i+2) {
            if(isPrime(i) && isPrime(i-2)) {
                return i;
            }
        }


        return 0;
    }

    /**
     * private method for determining if a number is prime
     * @param number number to question
     * @return boolean true or false based on if it is prime or not
     */
    private static boolean isPrime(int number) {
        boolean prime = true;

        if ((number%2) == 0) {
            return false;
        }

        for (int i = (number/2);i > 2; i--) {
            if ((number % i) == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
