package dominio.classes;

import dominio.controladores.CtrlDomini;

import java.util.HashSet;
import java.util.Set;

public class Assignatura {

    // Atributs
    /**
     * Nom de l'assignatura
     */
    private String nom;
    /**
     * Numero d'hores de teoria
     */
    private int nHoresT;
    /**
     * Numero d'hores de laboratori
     */
    private int nHoresL;
    /**
     * Numero d'hores de problemes
     */
    private int nHoresP;

    // Número de grups
    /**
     * Numero de grups de teoria
     */
    private int nGrupsT;
    /**
     * Numero de grups de laboratori
     */
    private int nGrupsL;
    /**
     * Numero de grups de problemes
     */
    private int nGrupsP;

    // Grups de matí/tarda
    /**
     * Numero de grups que són de matí
     */
    private int nGrupsMati;

    // Agrupació de blocs
    /**
     * Numero d'hores seguides de teoria
     */
    private int horesBlocT;
    /**
     * Numero d'hores seguides de laboratori
     */
    private int horesBlocL;
    /**
     * Numero d'hores seguides de problemes
     */
    private int horesBlocP;

    /**
     * Numero maxim d'alumnes a hores de teoria
     */
    private int nAlumnesT;
    /**
     * Numero maxim d'alumnes a hores de laboratori
     */
    private int nAlumnesL;
    /**
     * Numero maxim d'alumnes a hores de problemes
     */
    private int nAlumnesP;

    /**
     * Quatrimestre de l'assignatura (nivell)
     */
    private int nivell;

    /**
     * Vector de correquisits de l'assignatura
     */
    private Set<String> correquisits = new HashSet<>();

    // Mètodes

    // Constructores

    /**
     * Constructora per defecte
     */

    public Assignatura() {

    }
    /**
     * Constructora amb inicialitzacio
     *
     * @param  nom nom de l'Assignatura
     * @param  nHoresT nombre d'hores de Teoria
     * @param  nHoresL nombre d'hores de Laboratori
     * @param  nHoresP nombre d'hores de Problemes
     * @param  nGrupsT nombre de grups de Teoria
     * @param  nGrupsL nombre de grups de Laboratori per cada grup de teoria
     * @param  nGrupsP nombre de grups de Problemes per cada grup de teoria
     * @param  nGrupsMati nombre de grups de mati
     * @param  nAlumnesT nombre d'alumnes dels grups de Teoria
     * @param  nAlumnesL nombre d'alumnes dels grups de Laboratori
     * @param  nAlumnesP nombre d'alumnes dels grups de Problemes
     * @param  horesBlocT nombre d'hores per bloc de teoria
     * @param  horesBlocL nombre d'hores per bloc de laboratori
     * @param  horesBlocP nombre d'hores per bloc de problemes
     * @param  nivell nivell de l'assignatura
     */
    // Constructora amb nivell
    public Assignatura(String nom,
                       int nHoresT, int nHoresL, int nHoresP,
                       int nGrupsT, int nGrupsL, int nGrupsP,
                       int nGrupsMati,
                       int nAlumnesT, int nAlumnesL, int nAlumnesP,
                       int horesBlocT, int horesBlocL, int horesBlocP,
                       int nivell) {

        this.nom = nom;

        // Quantitat d'hores
        this.nHoresT = nHoresT;
        this.nHoresL = nHoresL;
        this.nHoresP = nHoresP;

        // Quantitat de grups
        this.nGrupsT = nGrupsT;
        this.nGrupsL = nGrupsL; // Respecte el número de grups
        this.nGrupsP = nGrupsP; // Respecte el número de grups

        // Quantitat grups matí
        this.nGrupsMati = nGrupsMati;

        // Alumnes
        this.horesBlocT = horesBlocT;
        this.horesBlocL = horesBlocL;
        this.horesBlocP = horesBlocP;

        // Agrupació de les hores de classe amb blocs
        this.nAlumnesT = nAlumnesT;
        this.nAlumnesL = nAlumnesL;
        this.nAlumnesP = nAlumnesP;


        this.nivell = nivell;
    }

    /**
     * Constructora copia
     * @param as Assignatura a copiar
     */
    public Assignatura(Assignatura as) {

        this.nom = as.getNom();

        // Quantitat d'hores
        this.nHoresT = as.getnHoresT();
        this.nHoresL = as.getnHoresL();
        this.nHoresP = as.getnHoresP();

        // Quantitat de grups
        this.nGrupsT = as.getnGrupsT();
        this.nGrupsL = as.getnGrupsL(); // Respecte el número de grups
        this.nGrupsP = as.getnGrupsP(); // Respecte el número de grups

        // Quantitat grups matí
        this.nGrupsMati = as.getnGrupsMati();

        // Alumnes
        this.nAlumnesT = as.getnAlumnesT();
        this.nAlumnesL = as.getnAlumnesL();
        this.nAlumnesP = as.getnAlumnesP();

        // Agrupació de les hores de classe amb blocs
        this.horesBlocT = as.getHoresBlocT();
        this.horesBlocL = as.getHoresBlocL();
        this.horesBlocP = as.getHoresBlocP();

        this.nivell = as.getNivell();

    }

    // Consultores


    public String getNom() {
        return nom;
    }

    public int getnHoresT() {
        return nHoresT;
    }

    public int getnHoresL() {
        return nHoresL;
    }

    public int getnHoresP() {
        return nHoresP;
    }

    public int getnGrupsT() {
        return nGrupsT;
    }

    public int getnGrupsL() {
        return nGrupsL;
    }

    public int getnGrupsP() {
        return nGrupsP;
    }

    public int getnGrupsMati() {
        return nGrupsMati;
    }

    public int getHoresBlocT() {
        return horesBlocT;
    }

    public int getHoresBlocL() {
        return horesBlocL;
    }

    public int getHoresBlocP() {
        return horesBlocP;
    }

    public int getnAlumnesT() {
        return nAlumnesT;
    }

    public int getnAlumnesL() {
        return nAlumnesL;
    }

    public int getnAlumnesP() {
        return nAlumnesP;
    }

    public int getNivell() {
        return nivell;
    }

    //Corregir
    public ConjuntAssignatures getCorrequisits() {
        ConjuntAssignatures correquisits = new ConjuntAssignatures();
        for (String s : this.correquisits) {
            if (!CtrlDomini.getPlaEstudis().getConjuntAssignatures().existeixAssignatura(s)) {
                throw new IllegalArgumentException("L'assignatura anomenada " + s + " ha estat assignada correquisit, però no ha estat entrada");
            }
            correquisits.afegirAssignatura(CtrlDomini.getPlaEstudis().getConjuntAssignatures().getAssignatura(s));
        }
        return correquisits;
    }




    //Modificadores


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setnHoresT(int nHoresT) {
        this.nHoresT = nHoresT;
    }

    public void setnHoresL(int nHoresL) {
        this.nHoresL = nHoresL;
    }

    public void setnHoresP(int nHoresP) {
        this.nHoresP = nHoresP;
    }

    public void setnGrupsT(int nGrupsT) {
        this.nGrupsT = nGrupsT;
    }

    public void setnGrupsL(int nGrupsL) {
        this.nGrupsL = nGrupsL;
    }

    public void setnGrupsP(int nGrupsP) {
        this.nGrupsP = nGrupsP;
    }

    public void setnGrupsMati(int nGrupsMati) {
        this.nGrupsMati = nGrupsMati;
    }

    public void setHoresBlocT(int horesBlocT) {
        this.horesBlocT = horesBlocT;
    }

    public void setHoresBlocL(int horesBlocL) {
        this.horesBlocL = horesBlocL;
    }

    public void setHoresBlocP(int horesBlocP) {
        this.horesBlocP = horesBlocP;
    }

    public void setnAlumnesT(int nAlumnesT) {
        this.nAlumnesT = nAlumnesT;
    }

    public void setnAlumnesL(int nAlumnesL) {
        this.nAlumnesL = nAlumnesL;
    }

    public void setnAlumnesP(int nAlumnesP) {
        this.nAlumnesP = nAlumnesP;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public void setCorrequisits(Set<String> correquisits) {
        this.correquisits = correquisits;
    }
}
