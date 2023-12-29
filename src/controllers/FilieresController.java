package controllers;

import M.Main;
import p.Filliere;
import service.*;

public class FilieresController {
    public static void showMenu(){
        System.out.println("-------------------------[ Filliéres ]---------------------------");


        System.out.println("1: Pour ajouter une filliére");
        System.out.println("2: Pour afficher les filliéres");
        System.out.println("3: Pour modifier une filliére");
        System.out.println("4: Pour supprimer une filliére");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createFilliere();
                break;
            case 2:
                showFilliere();
                break;
            case 3:
                editFilliere();
                break;
            case 4:
                destroyFilliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showFilliere(){
        for (Filliere filliere : DB.filieres) {
            System.out.print("Id : " + filliere.getId());
            System.out.print(" | Intitulé : " + filliere.getIntitule());
            System.out.print(" | Departement : " + filliere.getDepartement() );
            System.out.print(" | responsable : " + filliere.getResponsable() );
            System.out.println("");
        }
    }
    public static void createFilliere(){
        String Intitule = Main.getStringInput("Entrez l'intitulé :");
        DepartementsController.showDepartements();
        int id_dep = Main.getIntInput("Sélecionnez un departement par id :");
        EnseignantsController.showEnseignants();
        int id_ens = Main.getIntInput("Sélecionnez un enseignant par id :");
        FilliereService.addFiliere(Intitule, EnseigService.getEnsById(id_ens),DepServices.getDeptById(id_dep));

        showFilliere();
        showMenu();


    }
    public static void editFilliere(){
        showFilliere();
        int id = Main.getIntInput("Sélecionnez une filliere par id :");
        String Intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id_ens = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementsController.showDepartements();
        int id_dep = Main.getIntInput("Sélecionnez un departement par id :");
        FilliereService.updateFiliere(id,Intitule, EnseigService.getEnsById(id_ens),DepServices.getDeptById(id_dep));
        showFilliere();
        showMenu();
    }
    public static void destroyFilliere(){
        showFilliere();
        int id = Main.getIntInput("Sélecionnez une filliere par id :");
        FilliereService.deleteFiliereById(id);
        showFilliere();

    }
}

