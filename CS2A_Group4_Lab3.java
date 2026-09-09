import java.util.Scanner;
public class CS2A_Group4_Lab3
{
    static int count = 0;
    public static void main(){
        Scanner sc = new Scanner (System.in);
        int array [] = null;

        int size = size (sc);
        System.out.print(" ");
        array = insert (sc, array, size);

        while (true){
            array = menu(sc, array);
        }
    }
    
    public static int size (Scanner sc){
        int size;
        System.out.print("Enter Array Size (Between 5 - 15): ");

        while (!sc.hasNextInt()){
                System.out.println();
                System.out.print("Invalid input! Please pick between 5 - 15: ");
                sc.next(); 
        }

        size = sc.nextInt();

        while (size <= 5 || size >= 15){
            System.out.println(" ");
            System.out.print("Invalid input! Please pick between 5 - 15: ");
            while (!sc.hasNextInt()){
                System.out.println();
                System.out.print("Invalid input! Please pick between 5 - 15: ");
                sc.next(); 
            }
            size = sc.nextInt();
        }

        if (size > 5 && size < 15){
            System.out.print("Array with " + size + " slots successfully created!");
            System.out.println();
        }
        return size;
    }
    
    public static int [] insert (Scanner sc, int [] arr, int arraySize){
        count = 0;
        arr = new int[arraySize];
        
        System.out.println();
        System.out.print("Enter " + arraySize + " elements: ");
        
        while(count < arraySize){            
            while (!sc.hasNextInt()) {
                System.out.println();
                System.out.print("Invalid input! Please pick an integer: ");
                sc.next();
            }
            
            int element = sc.nextInt();
                
            arr[count] = element;
            count++;
                
            if (count >= arraySize){
                System.out.println("Array is now full! Press any key to continue...");
                sc.nextLine();
                sc.nextLine();
                clear();
                return arr;
                }
            }
        return arr;
    }
    
    public static int [] menu (Scanner sc, int [] arr){
        int choice = 0;
        header("Sorting Algorithms", 50);
        header("Menu", 50);
        System.out.println(" ");
        System.out.println("[1] Bubble Sort");
        System.out.println("[2] Selection Sort");
        System.out.println("[3] Insertion Sort");
        System.out.println("[4] Exit");
        System.out.print("Enter Your Choice: ");

        while (!sc.hasNextInt()) {
                System.out.println();
                System.out.print("Invalid input! Please pick from 1 - 4: ");
                sc.next();
        }
        
        choice = sc.nextInt();
        
        while (choice > 4 || choice < 1) {
            System.out.println();
            System.out.print("Input is out of range! Only enter integers 1 - 4: ");
            choice = sc.nextInt();
        }
        
        switch (choice){
            case 1:
            one (sc, arr);
            break;
            case 2:
            two (sc, arr);
            break;
            case 3:
            three (sc, arr);
            break;
            case 4:
            char again;
            do {
                System.out.print("\nTry Again Y/N? ");
                again = sc.next().charAt(0);
                if (again == 'Y' || again == 'y') {
                    clear();
                    int size = size(sc);
                    arr = insert (sc, arr, size);
                    break;
                } else if (again == 'N' || again == 'n') {
                    System.out.print("\nProgram Terminated. Goodbye!");
                    System.exit(0);
                } else {
                    System.out.print("\nOnly Y or N are acccepted.");
                }
            } while (again != 'Y' && again != 'y');
            break;
        }
        return arr;
    }
    
    public static void one (Scanner sc, int [] arr){
        clear();
        arr = copyArray(arr);
        int labelWidth = ("Sorted Array:").length() + 1;
        int width = labelWidth + (5 * arr.length);
        
        header("Bubble Sort", width);
        
        System.out.print("Initial Array:");
        printArray(arr);
        System.out.println();
        System.out.print(String.format("%" + width + "s", "").replace(' ', '-'));

        long startTime = System.nanoTime();
    
        int n = arr.length;
        boolean swapped = false;
        int iteration = 0;
        int indexOfLastUnsortedElement = n;
    
        do {
        swapped = false;
        iteration++;

        for (int i = 0; i < indexOfLastUnsortedElement - 1; i++){
            
            int leftElement = arr[i];
            int rightElement = arr[i+1];

         
            if (leftElement > rightElement){
                arr[i] = rightElement;
                arr[i+1] = leftElement;
                swapped = true;

                
            }
        }

        indexOfLastUnsortedElement--;

        System.out.println(" ");
        printRow("Iteration " + iteration + ": ", arr, labelWidth);

        if (stopIteration(arr)) {
                    break;
            }

    } while (swapped);

        long endTime = System.nanoTime();

        long executionTime
            = (endTime - startTime) / 1000000;
        
        System.out.println(" ");
        System.out.println(String.format("%" + width + "s", "").replace(' ', '-'));
        printRow("Sorted Array: ", arr, labelWidth);
        System.out.println(" ");
        System.out.println(String.format("%" + width + "s", "").replace(' ', '-'));

        System.out.println("Sorting took " + executionTime + "ms");
    
        System.out.println(" ");
        System.out.print("Press Any Key to Continue..."); 
        sc.nextLine();
        sc.nextLine();
        clear();
        System.out.println(" ");
    }
    
    public static void two (Scanner sc, int [] arr) {
        clear();
        arr = copyArray(arr);
        int labelWidth = ("Sorted Array:").length() + 1;
        int width = labelWidth + (5 * arr.length);
        
        header("Selection Sort", width);
    
        System.out.print("Initial Array:");
        printArray(arr);
        System.out.println();
        System.out.print(String.format("%" + width + "s", "").replace(' ', '-'));

        long startTime = System.nanoTime();
    
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++){
            int min = i;    
                
            if (stopIteration(arr)) {
                    break;
            }
                    
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                        min = j;
                }
            }
                    
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
                    
            System.out.println(" ");
            printRow("Iteration " + (i+1) + ": ", arr, labelWidth);
        }

        long endTime = System.nanoTime();

        long executionTime
            = (endTime - startTime) / 1000000;
        
        System.out.println(" ");
        System.out.println(String.format("%" + width + "s", "").replace(' ', '-'));
        printRow("Sorted Array: ", arr, labelWidth);
        System.out.println(" ");
        System.out.println(String.format("%" + width + "s", "").replace(' ', '-'));

        System.out.println("Sorting took " + executionTime + "ms");
    
        System.out.println(" ");
        System.out.print("Press Any Key to Continue..."); 
        sc.nextLine();
        sc.nextLine();
        clear();
        System.out.println(" ");
    }
    
    public static void three (Scanner sc, int [] arr) {
        clear();
        arr = copyArray(arr);
        int labelWidth = ("Sorted Array:").length() + 1;
        int width = labelWidth + (5 * arr.length);
        
        header ("Insertion Sort", width);
        
        System.out.print("Initial Array:");
        printArray(arr);
        System.out.println();
        System.out.print(String.format("%" + width + "s", "").replace(' ', '-'));

        long startTime = System.nanoTime();
        
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
            
            System.out.println(" ");
            printRow("Iteration " + i + ": ", arr, labelWidth);
            if (stopIteration(arr)) {
                break;
            }
        }

        long endTime = System.nanoTime();

        long executionTime
            = (endTime - startTime) / 1000000;
        
        System.out.println(" ");
        System.out.println(String.format("%" + width + "s", "").replace(' ', '-'));
        System.out.print("Sorted Array: ");
        printArray(arr);
        System.out.println(" ");
        System.out.println(String.format("%" + width + "s", "").replace(' ', '-'));
        System.out.println(" ");

        System.out.println("Sorting took " + executionTime + "ms");

        System.out.print("Press any key to continue...");
        sc.nextLine();
        sc.nextLine();
        clear();
        System.out.println(" ");
    }
    
    public static boolean stopIteration (int [] arr) {
        int n = arr.length;
        for (int k = 0; k < n - 1; k++) {
            if (arr[k] > arr[k + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static void printRow (String label, int [] arr, int labelWidth){
            System.out.printf("%-" + labelWidth + "s", label);
            printArray(arr);
    }

    public static int [] copyArray (int [] arr){
        int [] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void printArray (int [] arr){
        System.out.print(" ");
        for (int i = 0; i < arr.length; i++){
            System.out.printf("%4d", arr[i]);
            if (i < arr.length - 1){
                System.out.print(",");
            }
        }
    }

    public static void header (String text, int width) {
        String line = String.format("%" + width + "s", "").replace(' ', '-');
        int padding = (width - text.length()) / 2;
    
        System.out.println(line);
        System.out.println(String.format("%" + padding + "s%s", "", text));
        System.out.println(line);
    }
    
    public static void clear() {
        try {
            new ProcessBuilder ("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Unable to clear screen.");
        }
    }
}