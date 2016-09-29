package my.learning_java.sandbox;


public class Prime {
    public static boolean isPrime(int n) {
        for(int i = 2; i < n; i++ ){ //i++ или i = i + 1 или  i += 1, i++ инкремент(увеличение на 1), i-- дикремент(уменьшение на 1)
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeFast(int n) {
        int m = (int) Math.sqrt(n);
        for(int i = 2; i < m; i++ ){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhile(int n) {
        int i = 2;
        while (i < n && n % i != 0){
            i ++;
        }
        return i == n;
    }

    public static boolean isPrime(long n) {
        for(long i = 2; i < n; i++ ){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
