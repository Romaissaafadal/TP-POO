package controllers;
import M.Main;
import p.Enseignant;
import service.DB;
import service.DepServices;
import service.EnseigService;

public class EnseignantsController {
    public static void showMenu(){
        System.out.println("-------------------------[ Enseignants ]---------------------------");


        System.out.println("1: Pour ajouter un Enseignant");
        System.out.println("2: Pour afficher les Enseignants");
        System.out.println("3: Pour modifier un Enseignant");
        System.out.println("4: Pour supprimer un Enseignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );
            System.out.print(" | Grade : " + enseignant.getGrade() );
            System.out.print(" | Departement : " + enseignant.getDepartement() );
            System.out.println("");
        }
    }
    public static void createEnseignant(){
        String nom = Main.getStringInput("Entrez l'intitulé :");
        String prenom = Main.getStringInput("Entrez l'intitulé :");
        String email = Main.getStringInput("Entrez l'intitulé :");
        String grade = Main.getStringInput("Entrez l'intitulé :");

        EnseignantsController.showEnseignants();

        int id = Main.getIntInput("Sélecionnez enseignat  par id :");
        EnseigService.addEns(nom,prenom,email,grade,DepServices.getDeptById(id));
        showEnseignants();
        showMenu();


    }


    public static void editEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez l'intitulé :");
        String prenom = Main.getStringInput("Entrez l'intitulé :");
        String email = Main.getStringInput("Entrez l'intitulé :");
        String grade = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un departement par id :");

        EnseigService.updateEns(id,nom,prenom,email,grade,DepServices.getDeptById(id));

        showEnseignants();
        showMenu();

    }
    public static void destroyEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseigService.deleteEnsById(id);
        showEnseignants();

    }
}

