import java.util.*;

import com.maximet.sqlcda.db.Bdd;
import com.maximet.sqlcda.model.User;
import com.maximet.sqlcda.repository.UserRepository;

public class Main {

    //Sign
    public static void sign(Scanner scanner) {
        System.out.println("-------Sign-------");
        System.out.println("|Sign| - Veuillez entrer votre premier nombre : ");
        int n1 = scanner.nextInt();
        System.out.println("|Sign| - Veuillez entrer votre second nombre : ");
        int n2 = scanner.nextInt();

        if(n1 < 0 || n2 < 0){
            System.out.println("Le produit est négatif !");
        } else {
            System.out.println("Le produit est positif !");
        }
    }

    //SignOrNul
    public static void signOrNul(Scanner scanner) {
        System.out.println("-------SignOrNul-------");
        System.out.println("|SignOrNul| - Veuillez entrer votre premier nombre : ");
        int n1 = scanner.nextInt();
        System.out.println("|SignOrNul| - Veuillez entrer votre second nombre : ");
        int n2 = scanner.nextInt();

        if(n1 < 0 || n2 < 0){
            System.out.println("Le produit est négatif !");
        } else if(n1 == 0 || n2 == 0) {
            System.out.println("Le produit est nul !");
        } else {
            System.out.println("Le produit est positif !");
        }
    }

    //Catégorie
    public static void category(Scanner scanner){
        System.out.println("-------Catégorie-------");
        System.out.println("|Catégorie| - Veuillez entrer votre âge : ");
        int age = scanner.nextInt();

        switch(age){
            case 1,2,3,4,5:
                System.out.println("Trop jeune !");
                break;
            case 6,7:
                System.out.println("Poussin");
                break;
            case 8,9:
                System.out.println("Pupille");
                break;
            case 10,11:
                System.out.println("Minime");
                break;
            default:
                if(age <= 0) {
                    System.out.println("T'es comme le poisson ! T'es pané MDRRRR xD'!");
                }
                else {
                    System.out.println("Cadet");
                }
                break;
        }
    }

    public static String heure(Scanner scanner){
        System.out.println("-------Heure-------");
        System.out.println("|Heure| - Veuillez entrer l'heure : ");
        int heure = scanner.nextInt();
        System.out.println("|Heure| - Veuillez entrer les minutes : ");
        int minute = scanner.nextInt();

        minute++;

        if(minute >= 60){
            minute = 0;
            heure++;
        }

        if(heure >= 24){
            heure = 0;
        }

        return "Dans une minute, il sera " + heure + " heure(s) " + minute;
    }

    public static String seconde(Scanner scanner){
        System.out.println("-------Heure-------");
        System.out.println("|Heure| - Veuillez entrer l'heure : ");
        int heure = scanner.nextInt();
        System.out.println("|Heure| - Veuillez entrer les minutes : ");
        int minute = scanner.nextInt();
        System.out.println("|Heure| - Veuillez entrer les secondes : ");
        int seconde = scanner.nextInt();

        seconde++;

        if(seconde >= 60){
            seconde = 0;
            minute++;
        }

        if(minute >= 60){
            minute = 0;
            heure++;
        }

        if(heure >= 24){
            heure = 0;
        }

        return "Dans une seconde, il sera " + heure + " heure(s) " + minute + " minute(s) " + seconde;
    }


    public static double photocopie(Scanner scanner){

        double facture = 0;
        int i = 0;

        System.out.println("-------Photocopie-------");
        System.out.println("|Photocopie| - Veuillez entrer le nombre de photocopie à imprimer : ");
        int photocopie = scanner.nextInt();

        while (i < photocopie) {
            if(i < 10)
                facture+=0.10;
            else if (i < 30)
                facture+=0.09;
            else
                facture+=0.08;

            i++;
        }

        return (double) Math.round(100 * facture) / 100;
    }

    public static int minTab(int[] tab){

        int min = tab[0];

        for(int i = 0; i < tab.length; i++){
            if(tab[i] < min)
                min = tab[i];
        }

        System.out.println("-------minTab-------");
        return min;
    }

    public static int maxTab(int[] tab){

        int max = tab[0];

        for(int i = 0; i < tab.length; i++){
            if(tab[i] > max)
                max = tab[i];
        }

        System.out.println("-------maxTab-------");
        return max;
    }

    public static float averageTab(int[] tab){

        float moy = 0;

        for(int i = 0; i < tab.length; i++){
            moy += (float) tab[i]/tab.length;
        }

        System.out.println("-------averageTab-------");
        return moy;
    }

    public static float averageList(int n){
        Scanner scanner = new Scanner(System.in);
        List<Integer> notes = new ArrayList<Integer>();
        float moyenne = 0;

        for(int i = 0; i < n; i++) {
            System.out.println("Entrer une nouvelle note : ");
            notes.add(scanner.nextInt());
        }

        for(int note :  notes){
            moyenne += (float) note/n;
        }

        return moyenne;
    }

    public static void averageMap(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien d'élèves voulez-vous rentrer ? : ");
        int nb_eleve = scanner.nextInt();

        Map<String, Integer> notes = new HashMap<String, Integer>();

        for(int i = 0; i < nb_eleve; i++){
            System.out.println("Entrer le prénom de l'élève : ");
            String prenom = scanner.next();
            System.out.println("Entrer la note de l'élève : ");
            int note = scanner.nextInt();
            notes.put(prenom, note);
            System.out.println(notes.get(prenom));
        }

        int min = Collections.min(notes.values());
        int max = Collections.max(notes.values());

        for (Map.Entry<String, Integer> entry : notes.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("L'élève avec la meilleure note est " + entry.getKey() + " avec la note : " + entry.getValue());
            }
            if (entry.getValue() == min) {
                System.out.println("L'élève avec la pire note est " + entry.getKey() + " avec la note : " + entry.getValue());
            }
        }
    }

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        //Substraction
        /*
        int i = 2;
        int j = 3;
        System.out.println("La soustraction est égale à : " + (i-j));
        */

        //Multiplication
        /*
        int k = 5;
        System.out.println("La multiplication est égale à : " + (i*j*k));
        */

        //Average
        /*
        int l = 2;
        System.out.println("La moyenne est égale à : " + (float) (i+j+k+l)/4);
        */

        //Square
        /*
        System.out.println("-------Carré-------");
        System.out.println("|Carré| - Veuillez entrer un nombre : ");
        int nbr = scanner.nextInt();
        System.out.println("Carré de " + nbr + " = " + (int) Math.pow(nbr, 2));
        */

        //Sum
        /*
        System.out.println("-------Somme-------");
        System.out.println("|Somme| - Veuillez entrer votre premier nombre : ");
        int nb1 = scanner.nextInt();
        System.out.println("|Somme| - Veuillez entrer votre second nombre : ");
        int nb2 = scanner.nextInt();
        System.out.println("Somme de " + nb1 + " + " + nb2 + " = " + (nb1+nb2));
        */


        //Average
        /*
        System.out.println("-------Moyenne-------");
        System.out.println("|Moyenne| - Veuillez entrer votre premier nombre : ");
        int nbr1 = scanner.nextInt();
        System.out.println("|Moyenne| - Veuillez entrer votre deuxième nombre : ");
        int nbr2 = scanner.nextInt();
        System.out.println("|Moyenne| - Veuillez entrer votre troisième nombre : ");
        int nbr3 = scanner.nextInt();
        System.out.println("Moyenne de " + nbr1 + ", " + nbr2 + ", " + nbr3 + " = " + (float) (nbr1+nbr2+nbr3)/3);
        */


        //Sign
        //sign(scanner);

        //SignOrNul
        //signOrNul(scanner);

        //Catégorie
        //category(scanner);

        //Heure
        //System.out.println(heure(scanner));

        //Seconde
        //System.out.println(seconde(scanner));

        //Photocopie
        //System.out.println("La facture s'élève à : " + photocopie(scanner) + "€");

        int [] tab = {10,33,56,89,7,11,2,16};
        //minTab
        //System.out.println("L'élément minimum du tableau est : " + minTab(tab));
        //maxTab
        //System.out.println("L'élément maximum du tableau est : " + maxTab(tab));
        //averageTab
        //System.out.println("La moyenne du tableau est : " + averageTab(tab));


        //averageList
        /*
        System.out.println("-------Notes-------");
        System.out.println("Veuillez entrer le nombre de notes que vous voulez entrez : ");
        System.out.println("La moyenne de la classe est de : " + averageList(scanner.nextInt()));
         */

        //averageHashMap
        //System.out.println("-------NotesHashMap-------");
        //averageMap();

        Bdd.getConnexion();
        User user1 = new User("Maxime", "Thubert", "thubert.maxime.pro@gmail.com", "1234");
        User user2 = new User("Kévin", "Lionnet", "kevin.lionnet@gmail.com", "1234");
        User user3 = new User("Quentin", "Petit", "quentin.petit@gmail.com", "1234");
        User user4 = new User("Florian", "Nickels", "florian.nickels@gmail.com", "1234");
        User user5 = new User("Lucile", "Zilbermann", "lucile.zilbermann@gmail.com", "1234");
        //UserRepository.save(user1);
        //System.out.println(UserRepository.findByEmail(user1.getEmail()));
        //System.out.println(UserRepository.findByEmail("ofrofk"));
        //System.out.println(UserRepository.findByEmail(user1.getEmail()));
        System.out.println(UserRepository.update(new User("Maxime", "Thubert", "thubert.maxime.pro@gmail.com", "1234"), "thubert.maxime.pro@gmail.com"));
        System.out.println(UserRepository.findAll());

    }
}
