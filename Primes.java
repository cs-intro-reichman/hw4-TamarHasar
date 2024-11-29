public class Primes {
    public static void main(String[] args) {
        int primeUpToNum = Integer.parseInt(args[0]); 
        sieveOfEratosthenes(primeUpToNum);
    }

    public static void sieveOfEratosthenes(int primeUpToNum) {
        boolean[] primes = new boolean[primeUpToNum + 1];

        for (int i = 2; i <= primeUpToNum; i ++) {
            primes[i] = true;
        }

        int primeToMultiply = 2; 
        while (primeToMultiply * primeToMultiply <= primeUpToNum) { 

            if (primes[primeToMultiply]) {  

                int multiple = primeToMultiply * primeToMultiply;
                while (multiple <= primeUpToNum) { 
                    primes[multiple] = false;
                    multiple += primeToMultiply;  
                }

            }
            primeToMultiply++; 
        }

        int counter = 0;
        System.out.println("Prime numbers up to " + primeUpToNum + ":");
        for (int i = 2; i <= primeUpToNum; i++) {
            if (primes[i]) {
                System.out.println(i);
                counter++;
            }
        }

        double primePercent = (double) counter / primeUpToNum * 100;
        System.out.println("There are " + counter + " primes between 2 and " + primeUpToNum + " (" + (int) primePercent + "% are primes).");
    }

}