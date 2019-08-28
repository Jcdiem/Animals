package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final FileOutput outFile = new FileOutput("animals.txt");
    private final FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        ArrayList<Talkable> zoo = new ArrayList<>();

        // Lines to Replace
        zoo.add(new Dog(true, "Pete"));
        zoo.add(new Cat(9, "Anne Belly"));
        zoo.add(new Student(19, "Joe John Johnson"));
        Scanner keyboard = new Scanner(System.in);
        int age=0;
        int deadmice=0;
        boolean friendly=true;
        String creature;
        System.out.print("Please enter the name (NA to end): ");
        String name = keyboard.nextLine();
        while (!name.trim().equals("NA")){
            System.out.print("(S)tudent, (D)og, or (C)at");
            creature = keyboard.nextLine();
            switch(creature.toUpperCase().charAt(0)){
                case 'S':
                    System.out.print("What is the student's age?");
                    String str = keyboard.nextLine();
                    try{
                        age = Integer.parseInt(str);
                    }
                    catch (Exception e) {
                        System.out.print("Invalid age defaulted to 18.");
                        age=18;
                    }
                    zoo.add(new Student(age, name));
                    break;

                case 'C':
                    System.out.print("How many mice has the cat eaten?");
                    str = keyboard.nextLine();
                    try {
                        deadmice = Integer.parseInt(str);
                    }
                    catch(Exception e) {
                        System.out.print("Errornous mouse defaulted to 0");
                        deadmice = 0;
                    }
                    zoo.add(new Cat(deadmice, name));
                    break;

                case 'D':
                    System.out.print("Is your dog friendly");
                    str = keyboard.nextLine();
                    friendly = (str.toUpperCase().charAt(0) == 'Y')?true:false;
                    zoo.add(new Dog(friendly, name));
                }
            System.out.print("Please enter the name (NA to end): ");
            name = keyboard.nextLine();
            }

//        boolean isDone = false;
//        boolean tFriendly;
//        int miceEat;
//        while(!isDone) {
//            System.out.println("(S)tudent, (D)og, or (C)at?");
//            String anType = scan.nextLine();
//            if(!(anType.equals("S") || anType.equals("D") || anType.equals("C"))){
//                System.out.println("Try again");
//            }
//            else if (anType.equals("D")){
//                System.out.println("Is it friendly? (Y/N)");
//                String tIn = scan.nextLine();
//                if (tIn.equals("Y")){
//                    tFriendly = true;
//                }
//                else if (tIn.equals("N")){
//                    tFriendly = false;
//                }
//                else{
//                    System.out.println("Rest in peace, try again");
//                }
//            }
//            else if (anType.equals("C")){
//                System.out.println("How many mice has it eaten?");
//                String tIn = scan.nextLine();
//            }
//        }
        // End Lines to Replace

        for (Talkable thing : zoo) { //Prints items in array
            printOut(thing);
        }
        outFile.fileClose(); //Signifies the file as not being open

        System.out.println("\n*** Reading/printing entire file using fileRead method\n");

        inFile.fileRead(); //Reads the entire file
        inFile.fileClose(); //Marks file as closed

        System.out.println("\n*** Reading/printing one line at a time using fileReadLine method\n");

        FileInput indata = new FileInput("animals.txt"); //Setting in
        String line; //Empty string
        while ((line = indata.fileReadLine()) != null) { //While not empty line
            System.out.println(line); //Print current line until line-break
        }
    }

    public void printOut(Talkable p) { //Print out full thingy
        System.out.println(p.getName() + " says = " + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
    }
}
