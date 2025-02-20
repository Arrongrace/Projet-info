import java.util.Scanner;



public class menu{


    public static void menu() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

       // Code ANSI pour le texte en couleur
        final String BLUE = "\u001B[34m";
        final String YELLOW = "\u001B[33m";
        final String DARKER_PURPLE_8BIT = "\u001B[38;5;54m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String PINK = "\u001B[38;5;13m";
        // Réinitialisation des couleurs
        final String RESET = "\u001B[0m";
        
    

       System.out.println(BLUE + " ________  ___  ___  ___  ________   ________  ________  ________   ________  _______           ________  ___  ___  ________  _________  ________  _______      ");
       System.out.println("|\\   __  \\|\\  \\|\\  \\|\\  \\|\\   ____\\ |\\   ____\\|\\   __  \\|\\   ___  \\|\\   ____\\|\\  ___ \\         |\\   __  \\|\\  \\|\\  \\|\\   __  \\|\\___   ___\\\\   __  \\|\\  ___ \\     ");
       System.out.println("\\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\ \\  \\___|_\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\  \\___|\\ \\   __/|        \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\|\\  \\ \\   __/|    ");
       System.out.println(" \\ \\   ____\\ \\  \\\\\\  \\ \\  \\ \\_____  \\\\ \\_____  \\ \\   __  \\ \\  \\\\ \\  \\ \\  \\    \\ \\  \\_|/__       \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\   __  \\   \\ \\  \\ \\ \\   _  _\\ \\  \\_|/__  ");
       System.out.println("  \\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\|____|\\  \\\\|____|\\  \\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\____\\ \\  \\_|\\ \\       \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\  \\   \\ \\  \\ \\ \\  \\\\  \\\\ \\  \\_|\\ \\ ");
       System.out.println("   \\ \\__\\    \\ \\_______\\ \\__\\____\\_\\  \\ ____\\_\\  \\ \\__\\ \\__\\ \\__\\\\ \\__\\ \\_______\\ \\_______\\       \\ \\_____  \\ \\_______\\ \\__\\ \\__\\   \\ \\__\\ \\ \\__\\\\ _\\\\ \\_______\\");
       System.out.println("    \\|__|     \\|_______|\\|__|\\_________\\\\_________\\|__|\\|__|\\|__| \\|__|\\|_______|\\|_______|        \\|___| \\__\\|_______|\\|__|\\|__|    \\|__|  \\|__|\\|__|\\|_______|");
       System.out.println("                            \\|_________\\|_________|                                                      \\|__|                                                  " + RESET);

        int choix;
        do {
            System.out.print("\n Tapez "+ PINK +"1"+ RESET +" pour "+ YELLOW +"PvP"+ RESET +"               Tapez "+ PINK +"2"+ RESET +" pour "+ GREEN +"PvC facile"+ RESET +"                Tapez "+ PINK +"3"+ RESET +" pour "+ DARKER_PURPLE_8BIT +"PvC difficile"+ RESET +"              Tapez "+ PINK +"4"+ RESET +" pour "+ RED +"quitter"+ RESET +"               "+ PINK +"Choisir"+ RESET +" :");
            choix = Integer.parseInt(scanner.nextLine());
            switch (choix) {
                case 1:
                    Puissance4.modePvP();
                    break;

                case 2:
                    Puissance4.modePvC1();
                    break;

                case 3:
                    Puissance4.modePvC();
                     break;
                     
                case 4:
                    System.out.println("au revoir !");
                    break;
                default:
                    System.out.println("choix impossible !");
            }
        } while (choix != 4);
        scanner.close();
    }

}
