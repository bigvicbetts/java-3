package lambda_streams;

import java.math.BigInteger;
import java.util.*;
import java.util.function.*;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        // Part I :complete the static class methods that have been set up in this Numbers class java file.
        // Use streams to compute the results whenever possible.
        System.out.println(nums);

        // Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda
        // functions directly inside the method calls, or defined them first, then pass them into the methods.
        // Give them the same names as the static methods, but add the word 'lambda' in front of every lambda
        // function:
        /* e.g.

        added(() -> {});

        OR

        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});

        OR

        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...


*/
        IntPredicate lambdaIsOdd = (int i) ->  (i % 2 != 0);
        System.out.println(lambdaIsOdd.test(3));

        IntPredicate lambdaIsEven = (int i) ->  (i % 2 == 0);
        System.out.println(lambdaIsEven.test(3));

        IntPredicate lambdaIsPrime = (int i) -> {
            for (int x = 2; x <= i/2; x++) {
                if (i % x == 0) {
                    return false;
                }
            }
            return true;
        };
        System.out.println(lambdaIsPrime.test(31));

        IntSupplier lambdaAdded = () -> nums.stream().mapToInt(e -> e).sum();
        System.out.println(lambdaAdded.getAsInt());

        IntSupplier lambdaSubtracted = () -> {
            int initial = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                initial -= nums.get(i);
            }
            return initial;
        };
        System.out.println(lambdaSubtracted.getAsInt());

        Supplier<BigInteger> lambdaMultiplied = () -> nums.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
        System.out.println(lambdaMultiplied.get());

        BinaryOperator<Integer> lambdaDivided = (i, j) -> i/j;
        System.out.println(lambdaDivided.apply(4, 2));

        IntSupplier lambdaFindMax = () -> nums.stream().mapToInt(value -> value).max().orElseThrow(NoSuchElementException::new);
        System.out.println(lambdaFindMax.getAsInt());

        IntSupplier lambdaFindMin = () -> nums.stream().min(Comparator.comparing(Integer::intValue)).orElseThrow(NoSuchElementException::new);
        System.out.println(lambdaFindMin.getAsInt());

        BinaryOperator<Integer> lambdaCompare = (i, j) -> {
            if (i > j) {
                return 1;
            }
            else if (j > i) {
                return -1;
            }
            return 0;
        };
        System.out.println(lambdaCompare.apply(2, 2));

        IntFunction<Integer> lambdaAppend = (i) -> {
            ArrayList<Integer> nums2 = new ArrayList<>();
            nums2.addAll(nums);
            nums2.add(i);
            nums = nums2;
            return i;
        };
        System.out.println(lambdaAppend.apply(27));

        // The code below was to test out the implementation of each method first.
        // The lambda expression were written AFTER the methods and were simply
        // to translate the methods written below into lambda expressions.
        System.out.println(isOdd(2));
        System.out.println(isEven(2));
        System.out.println(isPrime(19));
        System.out.println(added());
        System.out.println(subtracted());

        // This value will be different than the one calculated on line 67 because I added
        // a value of 27 to the nums List on line 96.
        System.out.println(multipled());
        System.out.println(divided(4,2));
        System.out.println(findMax());
        System.out.println(findMin());
        System.out.println(compare(0, 0));
        System.out.println(append(27));

    }

    static boolean isOdd(int i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        if (i % 2 != 0) {
            return true;
        }
        return false;
    }

    static boolean isEven(int i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        if (i % 2 == 0) {
            return true;
        }
        return false;
    }

    static boolean isPrime(int i) {
        // determine if the value at the index i is a prime number.  return true if yes, return false if
        // no.

        for (int x = 2; x <= i/2; x++) {
            if (i % x == 0) {
                return false;
            }
        }
        return true;
    }

    static int added() {
        // add all the elements in the list.  return the sum.
        return nums.stream().mapToInt(e -> e).sum();
    }

    static int subtracted() {
        // subtract all the elements in the list. return the remainder.
        int initial = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            initial -= nums.get(i);
        }
        return initial;
    }

    static BigInteger multipled() {
        // multiply all the elements in the list. and return the product.
       return nums.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }

    static int divided(int i, int j) {
        // should divide two numbers (per Amir in help channel)

        return i/j;
    }

    static int findMax() {
         // return the maximum value in the list.
        return nums.stream().mapToInt(value -> value).max().orElseThrow(NoSuchElementException::new);
    }

    static int findMin() {
        // return the minimum value in the list.
        return nums.stream().min(Comparator.comparing(Integer::intValue)).orElseThrow(NoSuchElementException::new);
    }

    static int compare(int i, int j) {
        // compare the values stored in the array at index position i and j.
        // if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two
        // values are equal, return 0.
        if (i > j) {
            return 1;
        }
        else if (j > i) {
            return -1;
        }
        return 0;
    }

    static int append(int n) {
        // add a new value to the values list. return that value after adding it to the list.
        ArrayList<Integer> nums2 = new ArrayList<>();
        for (int item : nums) {
            nums2.add(item);
        }
        nums2.add(n);
        nums = nums2;
        return n;

    }

}
