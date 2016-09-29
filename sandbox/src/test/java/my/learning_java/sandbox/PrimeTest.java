package my.learning_java.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTest {
    @Test
    public void testPrimes(){
        Assert.assertTrue(Prime.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimesFast(){
        Assert.assertTrue(Prime.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test (enabled = false) // отключенный тест
    public void testPrimesLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Prime.isPrime(n));
    }

    @Test
    public void testNotPrimes(){
        Assert.assertFalse(Prime.isPrime(Integer.MAX_VALUE - 2));
    }

}
