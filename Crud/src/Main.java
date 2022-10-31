import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employe constr = new Employe();
        List<Employe> c = new ArrayList<Employe>();
        Scanner choix = new Scanner(System.in);
        File file = new File("employe.txt");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator lis = null;
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            c = (List<Employe>) ois.readObject();
            ois.close();
        } else {
            System.out.println("fichier n'existe pas");
        }
        int s;
        do {
            System.out.println("donner votre choix : " +
                    "\n\t1-  Ajouter un nouvel employé" +
                    "\n\t2-  Modifier un employé" +
                    "\n\t3-  Supprimer un employé" +
                    "\n\t4-  Afficher un employé" +
                    "\n\t5-  Afficher tous les employés" +
                    "\n\t6-  Calculer le nombre des employés ayant un salaire qui dépasse 10000" +
                    "\n\t7-  Afficher l’employé le plus âgé " +
                    "\n\t8-  Afficher l’employé le moins âgé" +
                    "\n\t9-  Quitter");
            System.out.println("donner votre choix :");
            s = choix.nextInt();
            switch (s) {
                case 1:

                    System.out.println("Combien d'employes voulez vous entrez :");
                    int comt = choix.nextInt();
                    for (int i = 0; i < comt; i++) {
                        Scanner n = new Scanner(System.in);
                        String mat, nom, pre;
                        int age, sal;
                        System.out.println("Entrez votre matricule");
                        mat = n.nextLine();
                        System.out.println("Entrez votre nom");
                        nom = n.nextLine();
                        System.out.println("Entrez votre prenom");
                        pre = n.nextLine();
                        System.out.println("Entrez votre age");
                        age = n.nextInt();
                        System.out.println("Entrez votre salaire");
                        sal = n.nextInt();
                        //methode 1
                        c.add(constr.ajouter(mat, nom, pre, age, sal));
                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(c);
                        oos.close();
                        //methode 2
//                            c.add(new Employe(mat, nom, pre, age, sal));
                    }
                    break;
                case 2:
                    Scanner modi = new Scanner(System.in);
                    String ma_tri, newMatricule, newNom, newPrenom;
                    int newAge, newSalaire;
                    System.out.println("donnez matricule d'employer que vous voulez modifier");
                    ma_tri = modi.nextLine();
                    System.out.println("Entrez votre nouvelle matricule");
                    newMatricule = modi.nextLine();
                    System.out.println("Entrez votre nouvelle nom");
                    newNom = modi.nextLine();
                    System.out.println("Entrez votre nouvelle prenom");
                    newPrenom = modi.nextLine();
                    System.out.println("Entrez votre nouvelle age");
                    newAge = modi.nextInt();
                    System.out.println("Entrez votre nouvelle salaire");
                    newSalaire = modi.nextInt();
                    constr.modifier(ma_tri, newMatricule, newNom, newPrenom, newAge, newSalaire, c);
                    break;
                case 3:
                    System.out.println("donnez matricule d'employer que vous voulez supprimer");
                    Scanner sup = new Scanner(System.in);
                    String m = sup.nextLine();
                    constr.supprimerUnEmploye(m, c);
                    break;
                case 4:
                    System.out.println("donnez matricule d'employer que vous cherchez");
                    Scanner s1 = new Scanner(System.in);
                    String matri = s1.nextLine();
                    constr.afficherUnEmploye(matri, c);
                    break;
                case 5:
                    constr.afficherTousEmploye(c);
                    break;
                case 6:
                    constr.lesEmployeSup_10000(c);
                    break;
                case 7:
                    constr.employerPlusAge(c);
                    break;
                case 8:
                    constr.employerpetitAge(c);
                    break;
                case 9:
                    constr.quitter();
                    break;
            }
        } while (s < 9);

    }
}