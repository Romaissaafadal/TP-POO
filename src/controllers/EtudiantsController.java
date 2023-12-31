package controllers;

import M.Main;
import p.Etudiant;
import service.DB;
import service.EtudiantService;
import service.FilliereService;

public class EtudiantsController {
    public static void showMenu(){
        System.out.println("-------------------------[ étudiants ]---------------------------");


        System.out.println("1: Pour ajouter un étudiants");
        System.out.println("2: Pour afficher les étudiants");
        System.out.println("3: Pour modifier un étudiants");
        System.out.println("4: Pour supprimer un étudiants");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiant();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEtudiant(){
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail() );
            System.out.print(" | CodeApodée : " + etudiant.getCodeApogée() );
            System.out.print(" | Filliére : " + etudiant.getFilliere() );
            System.out.println("");
        }

    }
    public static void createEtudiant(){
        String nom = Main.getStringInput("Entrez l'intitulé :");
        String prenom = Main.getStringInput("Entrez l'intitulé :");
        String email = Main.getStringInput("Entrez l'intitulé :");
        int codeApogee = Main.getIntInput("Entrez l'intitulé :");
        FilieresController.showFilliere();
        int id = Main.getIntInput("Sélecionnez une filliére par id :");
        EtudiantService.addEtd(nom,prenom,email,codeApogee, FilliereService.getFiliereById(id));

        showEtudiant();
        showMenu();


    }
    public static void editEtudiant(){
        showEtudiant();
        int id = Main.getIntInput("Sélecionnez un etudiantt par id :");
        String nom = Main.getStringInput("Entrez l'intitulé :");
        String prenom = Main.getStringInput("Entrez l'intitulé :");
        String email = Main.getStringInput("Entrez l'intitulé :");
        int codeApogee = Main.getIntInput("Entrez l'intitulé :");
        FilieresController.showFilliere();
        int idEns = Main.getIntInput("Sélecionnez une filliére par id :");

        EtudiantService.updateEtd(id,nom,prenom,email,codeApogee, FilliereService.getFiliereById(id));

        showEtudiant();
        showMenu();
    }
    public static void destroyEtudiant(){
        showEtudiant();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        EtudiantService.deleteEtdById(id);
        showEtudiant();

    }
}
