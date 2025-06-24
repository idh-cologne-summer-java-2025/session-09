package SortAlgorthms;

import java.util.Arrays;
import java.util.Random;

public class SortDemo {

	public static void main(String[] args) {
        int[] smallArray = generateRandomArray(5);
        int[] largeArray = generateRandomArray(100000);

        System.out.println("Unsortiertes kleines Array: " + Arrays.toString(smallArray));

        // Alle Verfahren am kleinen Array demonstrieren
        runAndPrint("Bubble Sort", smallArray, SortAlgorithms::bubbleSort);
        runAndPrint("Selection Sort", smallArray, SortAlgorithms::selectionSort);
        runAndPrint("Insertion Sort", smallArray, SortAlgorithms::insertionSort);
        runAndPrint("Merge Sort", smallArray, SortAlgorithms::mergeSort);
        runAndPrint("Quick Sort", smallArray, SortAlgorithms::quickSort);
        
        // Nur Zeitmessung für großes Array
        System.out.println("\n== Zeitmessung mit 100k Zufallszahlen ==");
        runAndTime("Merge Sort", smallArray, SortAlgorithms::mergeSort);
        runAndTime("Quick Sort", smallArray, SortAlgorithms::quickSort);
        runAndTime("Insertion Sort", largeArray, SortAlgorithms::insertionSort);
        runAndTime("Selection Sort", largeArray, SortAlgorithms::selectionSort);
        runAndTime("Bubble Sort", largeArray, SortAlgorithms::bubbleSort);
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }

    // Wird benötigt, um direkt auf die entsprechende Methode zu referenzieren
    // Seit Java 8 kann man Methoden wie Daten behandeln 
    // – man kann sie in Variablen speichern und an andere Methoden übergeben.
    interface SortAlgorithm {
        void sort(int[] array);
    }

    public static void runAndPrint(String name, int[] original, SortAlgorithm algorithm) {
        int[] copy = Arrays.copyOf(original, original.length);
        algorithm.sort(copy);
        System.out.println(name + ": " + Arrays.toString(copy));
    }

    public static void runAndTime(String name, int[] original, SortAlgorithm algorithm) {
        int[] copy = Arrays.copyOf(original, original.length);
        long start = System.currentTimeMillis();
        algorithm.sort(copy);
        long end = System.currentTimeMillis();
        System.out.println(name + " dauerte " + (end - start) + " ms");
    }

    
}
