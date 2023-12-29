package p;

public class Note {
    private int id ;
    private float note;
    private Etudiant etudiant;
    private Filliere filliere;

    public Note() {
    }

    public Note(float note, Etudiant etudiant, Filliere filliere) {
        this.note = note;
        this.etudiant = etudiant;
        this.filliere = filliere;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {

        this.note = note;
    }

    public Etudiant getEtudiant() {

        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {

        this.etudiant = etudiant;
    }

    public Filliere getFiliere() {

        return filliere;
    }

    public void setFiliere(Filliere filiere) {

        this.filliere = filiere;
    }
}

