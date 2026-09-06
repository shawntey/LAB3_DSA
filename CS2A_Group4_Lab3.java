import java.util.Scanner;
public class CS2A_Group4_Lab3
{
    static int count = 0;
    public static void main(){
        Scanner sc = new Scanner (System.in);
        int array [] = null;
        int choice = 0;

        int size = size (sc);
        System.out.print(" ");
        array = insert (sc, array, size);

        while (true){
            choice = menu(sc, choice, array);
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

        while (size < 5 || size > 15){
            System.out.println(" ");
            System.out.print("Invalid input! Please pick between 5 - 15: ");
            while (!sc.hasNextInt()){
                System.out.println();
                System.out.print("Invalid input! Please pick between 5 - 15: ");
                sc.next(); 
            }
            size = sc.nextInt();
        }

        if (size >= 5 && size <= 15){
            System.out.print("Array with " + size + " slots successfully created!");
            System.out.println();
        }
        return size;
    }
    
    public static int [] insert (Scanner sc, int [] array, int size){
        if (array == null){
            array = new int [size];
        }
        System.out.println();
        System.out.print("Enter " + size + " elements: ");
        
        while(count < size){            
            while (!sc.hasNextInt()) {
                System.out.println();
                System.out.print("Invalid input! Please pick between 5 - 15: ");
                sc.next();
            }
            
            int element = sc.nextInt();
                
            array[count] = element;
            count++;
                
            if (count >= size){
                System.out.println("Array is now full! Press any key to continue...");
                sc.nextLine();
                sc.nextLine();
                clear();
                return array;
                }
            }
        return array;
    }
    
    public static int menu (Scanner sc, int choice, int [] array){
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
            one (sc, array);
            break;
            case 2:
            two (sc, array);
            break;
            case 3:
            three (sc, array);
            break;
            case 4:
            System.out.print("\nProgram terminated. Goodbye!");
            System.exit(0);
            break;
        }
        return choice;
    }
    
    public static void one (Scanner sc, int [] array){
        clear();
        header("Bubble Sort", 50);
        int [] arr = copyArray(array);
    
        int labelWidth = ("Sorted Array:").length() + 1;
    
        System.out.print("Initial Array:");
        printArray(arr);
        System.out.println();
        System.out.print(String.format("%50s", "").replace(' ', '-'));
    
        int n = arr.length;
    
        for (int iteration = 1; iteration <= n - 1; iteration++){
            for (int i = 0; i < n - 1 - (iteration - 1); i++){
                int leftElement = arr[i];
                int rightElement = arr[i+1];
             
                if (leftElement > rightElement){
                    arr[i] = rightElement;
                    arr[i+1] = leftElement;
                }
            }
            
            System.out.println(" ");
            printRow("Iteration " + iteration + ": ", arr, labelWidth);
            
            if (stopIteration(arr)) {
                        break;
                }
        }
    
        System.out.println(" ");
        System.out.println(String.format("%50s", "").replace(' ', '-'));
        printRow("Sorted Array: ", arr, labelWidth);
        System.out.println(" ");
        System.out.println(String.format("%50s", "").replace(' ', '-'));
    
        System.out.println(" ");
        System.out.print("Press Any Key to Continue..."); 
        sc.nextLine();
        sc.nextLine();
        clear();
        System.out.println(" ");
    }
    
    public static void two (Scanner sc, int [] array) {
        clear();
        header("Selection Sort", 50);
        int [] arr = copyArray(array);
    
        int labelWidth = ("Sorted Array:").length() + 1;
    
        System.out.print("Initial Array:");
        printArray(arr);
        System.out.println();
        System.out.print(String.format("%50s", "").replace(' ', '-'));
    
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
        
        System.out.println(" ");
        System.out.println(String.format("%50s", "").replace(' ', '-'));
        printRow("Sorted Array: ", arr, labelWidth);
        System.out.println(" ");
        System.out.println(String.format("%50s", "").replace(' ', '-'));
    
        System.out.println(" ");
        System.out.print("Press Any Key to Continue..."); 
        sc.nextLine();
        sc.nextLine();
        clear();
        System.out.println(" ");
    }
    
    public static void three (Scanner sc, int [] array) {
        clear();
        header ("Insertion Sort", 50);
        int [] arr = copyArray(array);
        
        int labelWidth = ("Sorted Array:").length() + 1;
        
        System.out.print("Initial Array:");
        printArray(arr);
        System.out.println();
        System.out.print(String.format("%50s", "").replace(' ', '-'));
        
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
        
        System.out.println(" ");
        System.out.println(String.format("%50s", "").replace(' ', '-'));
        System.out.print("Sorted Array: ");
        printArray(arr);
        System.out.println(" ");
        System.out.println(String.format("%50s", "").replace(' ', '-'));
        System.out.println(" ");
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
    
    public static void printRow (String label, int [] array, int labelWidth){
            System.out.printf("%-" + labelWidth + "s", label);
            printArray(array);
    }

    public static int [] copyArray (int [] array){
        int [] copy = new int[array.length];
        for (int i = 0; i < array.length; i++){
            copy[i] = array[i];
        }
        return copy;
    }

    public static void printArray (int [] array){
        System.out.print(" ");
        for (int i = 0; i < array.length; i++){
            System.out.printf("%4d", array[i]);
            if (i < array.length - 1){
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