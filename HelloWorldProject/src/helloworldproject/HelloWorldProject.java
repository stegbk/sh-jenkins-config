/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldproject;

import java.util.ArrayList;

/**
 *
 * @author keithstegbauer
 */
public class HelloWorldProject {

    private static HelloWorldProject theInstance = null;
    private ArrayList primes = new ArrayList();
    private static boolean print_debug = true;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int testNum = (int)Math.round(Math.random() * (Integer.MAX_VALUE/10000));
        testNum = testNum + 2;
        System.out.println("Hello world!");
        System.out.println("Checking " + testNum);
        print_debug = false;
        getInstance().computePrimesLessThan(testNum + 1);
        getInstance().printCurrentPrimeList();
        if (getInstance().checkSinglePrimeAgainstList(testNum)) {
            System.out.println(testNum + "\tis prime");
        } else {
            System.out.println(testNum + "\tis NOT prime");
        }
    }
    
    public static HelloWorldProject getInstance() {
        if (theInstance == null) {
            theInstance = new HelloWorldProject();
        }
        return theInstance;
    }
    
    private boolean checkPrimeWithCurrentList(int testNum) {
        for (int i = 0; i < primes.size(); i++) {
            
            if ((testNum % (int)primes.get(i)) == 0) {
                return false;
            }
        }
        return true;        
    }
    
    private boolean checkSinglePrimeAgainstList(int testNum) {
        return primes.indexOf(testNum) != -1;
    }
    
    private boolean checkPrimeAdd(int testNum) {
        boolean result;
        result = checkPrimeWithCurrentList(testNum);
        if (result) {
            primes.add(testNum);
        }
        return result;
    }
    
    private void computePrimesLessThan(int testNum) {
        for (int i = 2; i < testNum; i++) {
            checkPrimeAdd(i);
        }
    }
    
    private void printCurrentPrimeList() {
        if (print_debug) {
            for (int i = 0; i < primes.size(); i++) {
                System.out.println("The prime at " + i + "\tis\t" + primes.get(i));
            }
        }
    }
}
