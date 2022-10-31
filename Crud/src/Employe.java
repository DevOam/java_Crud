import java.io.*;
import java.util.*;

public class Employe implements Serializable {
    String Matricule;
    String Nom;
    String Prenom;
    int Age;
    int Salaire;

    //constructeur
    public Employe(String Matricule, String Nom, String Prenom, int Age, int Salaire) {
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Age = Age;
        this.Salaire = Salaire;
    }

    public Employe() {

    }

    //getters && setters
    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getSalaire() {
        return Salaire;
    }

    public void setSalaire(int salaire) {
        Salaire = salaire;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "Matricule='" + Matricule + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Age=" + Age +
                ", Salaire=" + Salaire +
                '}';
    }

    File file = new File("employe.txt");
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    ListIterator lis = null;

    public Employe ajouter(String mat, String nm, String pm, int ag, int sal) {
        Employe n = new Employe(mat, nm, pm, ag, sal);
        return n;
    }

    public void modifier(String matri, String mat, String nm, String pm, int ag, int sal, List<Employe> f) throws IOException, ClassNotFoundException {
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            f = (List<Employe>) ois.readObject();
            ois.close();
            boolean found = false;
            ListIterator<Employe> li = f.listIterator();
            while (li.hasNext()) {
                Employe e = li.next();
                if (matri.equals(e.getMatricule())) {
                    li.set(new Employe(mat, nm, pm, ag, sal));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("verifiez le matrucule que vous avez entrez");
            } else {
                System.out.println("modification avec succes");
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(f);
                oos.close();
            }
        } else {
            System.out.println("fichier n'existe pas");
        }
    }

    public void supprimerUnEmploye(String mat, List<Employe> f) throws IOException, ClassNotFoundException {
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            f = (List<Employe>) ois.readObject();
            ois.close();
            boolean found = false;
            ListIterator<Employe> i = null;
            i = f.listIterator();
            while (i.hasNext()) {
                Employe e = i.next();
                if (mat.equals(e.getMatricule())) {
                    i.remove();
                    found = true;
                }
            }
            if (found == false) {
                System.out.println("verifiez le matrucule que vous avez entrez");
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(f);
                oos.close();
                System.out.println("supression avec succes");
            }
        } else {
            System.out.println("fichier n'existe pas");
        }
    }

    public void afficherUnEmploye(String mat, List<Employe> f) throws IOException, ClassNotFoundException {
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            f = (List<Employe>) ois.readObject();
            ois.close();
            boolean found = false;
            ListIterator<Employe> i = null;
            i = f.listIterator();
            while (i.hasNext()) {
                Employe e = i.next();
                if (mat.equals(e.getMatricule())) {
                    System.out.println(e);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("verifiez le matrucule que vous avez entrez");
            }
        } else {
            System.out.println("le fichier n'existe pas");
        }
    }

    public void afficherTousEmploye(List<Employe> f) throws IOException, ClassNotFoundException {
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            f = (List<Employe>) ois.readObject();
            ois.close();
            ListIterator<Employe> i = f.listIterator();
            while (i.hasNext()) {
                Employe e = i.next();
                System.out.println(e);
            }
        } else {
            System.out.println("fichier n'existe pas");
        }
    }

    public void lesEmployeSup_10000(List<Employe> f) throws IOException, ClassNotFoundException {
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            f = (List<Employe>) ois.readObject();
            ois.close();
            int compteur = 0;
            ListIterator<Employe> i = f.listIterator();
            while (i.hasNext()) {
                Employe e = i.next();
                if (e.getSalaire() >= 10000) {
                    compteur++;
                }
            }
            System.out.println("le nombre des employes qui ont un saliare > 10000 est :" + compteur);
        } else {
            System.out.println("fichier n'existe pas");
        }
    }

    public void employerPlusAge(List<Employe> f) throws IOException, ClassNotFoundException {
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            f = (List<Employe>) ois.readObject();
            ois.close();
            boolean found = false;
            ListIterator<Employe> i = null;
            int max = getAge();
            i = f.listIterator();
            while (i.hasNext()) {
                Employe e = i.next();
                if (e.getAge() > max) {
                    max = e.getAge();
                    found = true;
                }
            }
            System.out.println("l'age maximal est : " + max);
            if (!found) {
                System.out.println("verifiez le matrucule que vous avez entrez");
            }
        } else {
            System.out.println("le fichier n'existe pas");
        }
    }

    public void employerpetitAge(List<Employe> f) throws IOException, ClassNotFoundException {
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            f = (List<Employe>) ois.readObject();
            ois.close();
            boolean found = false;
            ListIterator<Employe> i = null;
            int min = f.get(0).getAge();
            i = f.listIterator();
            while (i.hasNext()) {
                Employe e = i.next();
                if (e.getAge() < min) {
                    min = e.getAge();
                    found = true;
                }
            }
            System.out.println("l'employe qui a l'age minimal est : " + min);
            if (!found) {
                System.out.println("verifiez le matrucule que vous avez entrez");
            }
        } else {
            System.out.println("le fichier n'existe pas");
        }
    }
//



    public void quitter() {
        System.out.println("merci pour votre participation, au revoir");
    }
}
