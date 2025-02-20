import java.util.Scanner;
import java.util.Random;

public class Puissance4 {

    public static final int LIGNES = 6;
    public static final int COLONNES = 7;
    public static char[][] grille = new char[LIGNES][COLONNES];
    public static char joueur = 'J';  // 'J' pour le joueur humain, 'R' pour l'ordinateur
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    // Mode PvP (Player vs Player)
    public static void modePvP() {
        initialiserGrille();
        boolean enCours = true;

        while (enCours) {
            afficherGrille();

            if (joueur == 'J') {
                jouerJoueur();
            } else {
                jouerJoueur();
            }

            if (verifierAlignement(4, joueur)) {
                afficherGrille();
                System.out.println("Joueur " + joueur + " a gagné !");
                enCours = false;
            } else if (grilleRemplie()) {
                afficherGrille();
                System.out.println("Match nul !");
                enCours = false;
            }

            // Change de joueur
            if (joueur == 'R') {
                joueur = 'J';
            } else {
                joueur = 'R';
            }
        }
    }

    // Mode PvC (Player vs Computer)
    public static void modePvC() {
        initialiserGrille();
        boolean enCours = true;

        while (enCours) {
            afficherGrille();

            if (joueur == 'J') {
                jouerJoueur();
            } else {
                jouerOrdinateur();
            }

            if (verifierAlignement(4, joueur)) {
                afficherGrille();
                System.out.println("Joueur " + joueur + " a gagné !");
                enCours = false;
            } else if (grilleRemplie()) {
                afficherGrille();
                System.out.println("Match nul !");
                enCours = false;
            }

            // Change de joueur
            if (joueur == 'R') {
                joueur = 'J';
            } else {
                joueur = 'R';
            }
        }
    }

    // Mode PvC1 (Player vs Computer with different AI behavior)
    public static void modePvC1() {
        initialiserGrille();
        boolean enCours = true;

        while (enCours) {
            afficherGrille();

            if (joueur == 'J') {
                jouerJoueur();
            } else {
                jouerOrdinateur1();
            }

            if (verifierAlignement(4, joueur)) {
                afficherGrille();
                System.out.println("Joueur " + joueur + " a gagné !");
                enCours = false;
            } else if (grilleRemplie()) {
                afficherGrille();
                System.out.println("Match nul !");
                enCours = false;
            }

            // Change de joueur
            if (joueur == 'R') {
                joueur = 'J';
            } else {
                joueur = 'R';
            }
        }
    }

    // Méthodes communes à tous les modes
    public static void initialiserGrille() {
        
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                grille[i][j] = ' ';
            }
        }
    }

    public static void afficherGrille() {
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String RESET = "\u001B[0m";
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                char jeton = grille[i][j];
                if (jeton == 'J') {
                    System.out.print(YELLOW+ jeton + " \u001B[0m"+RESET);
                } else if (jeton == 'R') {
                    System.out.print(RED+ jeton + " \u001B[0m"+RESET);
                } else {
                    System.out.print(BLUE +"▄ "+ RESET);
                }
            }
            System.out.println();
        }
    }

    public static void jouerJoueur() {
        int colonne = -1;
        boolean saisieValide = false;

        while (!saisieValide) {
            System.out.println("\nJoueur " + joueur + ", choisissez une colonne (1-7): ");
            try {
                colonne = Integer.parseInt(scanner.nextLine()) - 1;
                if (colonne >= 0 && colonne < COLONNES && grille[0][colonne] == ' ') {
                    saisieValide = true;
                } else {
                    System.out.println("Choix invalide. La colonne est pleine ou hors limites.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un chiffre entre 1 et 7.");
            }
        }

        placerJeton(colonne);
    }

    public static void jouerOrdinateur() {
        System.out.println("\nL'ordinateur joue...");
        int colonne = choisirColonneIA();
        placerJeton(colonne);
    }

    public static void jouerOrdinateur1() {
        System.out.println("\nL'ordinateur joue...");
        int colonne = choisirColonneIA1();
        placerJeton(colonne);
    }

    public static void placerJeton(int colonne) {
        for (int i = LIGNES - 1; i >= 0; i--) {
            if (grille[i][colonne] == ' ') {
                grille[i][colonne] = joueur;
                break;
            }
        }
    }

    public static boolean grilleRemplie() {
        for (int j = 0; j < COLONNES; j++) {
            if (grille[0][j] == ' ') {
                return false;
            }
        }
        return true;
    }

    // Méthode IA pour PvC
    public static int choisirColonneIA() {
        int colonne = contrerAlignement(3, 'J');
        if (colonne == -1) colonne = contrerAlignement(2, 'J');
        if (colonne == -1) {
            do {
                colonne = random.nextInt(COLONNES);
            } while (grille[0][colonne] != ' ');
        }
        return colonne;
    }

    // Méthode IA différente pour PvC1
    public static int choisirColonneIA1() {
        // Exemple de stratégie différente
        int colonne = random.nextInt(COLONNES);
        while (grille[0][colonne] != ' ') {
            colonne = random.nextInt(COLONNES);
        }
        return colonne;
    }

    public static int contrerAlignement(int alignement, char joueur) {
        for (int j = 0; j < COLONNES; j++) {
            for (int i = LIGNES - 1; i >= 0; i--) {
                if (grille[i][j] == ' ') {
                    grille[i][j] = joueur;
                    if (verifierAlignement(alignement, joueur)) {
                        grille[i][j] = ' ';
                        return j;
                    }
                    grille[i][j] = ' ';
                    break;
                }
            }
        }
        return -1;
    }

    public static boolean verifierAlignement(int alignement, char joueur) {
        return verifierAlignementHorizontal(alignement, joueur) ||
                verifierAlignementVertical(alignement, joueur) ||
                verifierAlignementDiagonalDeGaucheDroite(alignement, joueur) ||
                verifierAlignementDiagonalDeDroiteGauche(alignement, joueur);
    }

    public static boolean verifierAlignementHorizontal(int alignement, char joueur) {
        for (int i = 0; i < LIGNES; i++) {
            int count = 0;
            for (int j = 0; j < COLONNES; j++) {
                if (grille[i][j] == joueur) {
                    count++;
                    if (count == alignement) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public static boolean verifierAlignementVertical(int alignement, char joueur) {
        for (int j = 0; j < COLONNES; j++) {
            int count = 0;
            for (int i = 0; i < LIGNES; i++) {
                if (grille[i][j] == joueur) {
                    count++;
                    if (count == alignement) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public static boolean verifierAlignementDiagonalDeGaucheDroite(int alignement, char joueur) {
        for (int i = 0; i < LIGNES - 3; i++) {
            for (int j = 0; j < COLONNES - 3; j++) {
                if (grille[i][j] == joueur &&
                        grille[i+1][j+1] == joueur &&
                        grille[i+2][j+2] == joueur &&
                        grille[i+3][j+3] == joueur) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verifierAlignementDiagonalDeDroiteGauche(int alignement, char joueur) {
        for (int i = 0; i < LIGNES - 3; i++) {
            for (int j = 3; j < COLONNES; j++) {
                if (grille[i][j] == joueur &&
                        grille[i+1][j-1] == joueur &&
                        grille[i+2][j-2] == joueur &&
                        grille[i+3][j-3] == joueur) {
                    return true;
                }
            }
        }
        return false;
    }
}
