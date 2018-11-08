// Marc Casellas

package Dominio;

import java.util.*;

public class CtrlPresentacioAula {

    private VistaAula vAula;
    private CtrlDominiAula cdAula;

    ////////////////////////////////////////////////////////////////////
    ///// CONSTRUCTORES
    ////////////////////////////////////////////////////////////////////

    CtrlPresentacioAula (CtrlDominiAula c) {
        vAula = new VistaAula();
        cdAula = c;
    }

    ////////////////////////////////////////////////////////////////////
    ///// MENU
    ////////////////////////////////////////////////////////////////////

    public void gestioAules() throws Exception {

        int accio = -1;
        while (accio !=VistaAula.getNumOpcionsMenu()) {
            accio = vAula.getOpcioMenu();

            switch (accio) {
                case 1:
                    llistarAules();
                    break;
                case 2:
                    afegirAula();
                    break;
                case 3:
                    modificarAula();
                    break;
                case 4:
                    eliminarAula();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }
    }

    ////////////////////////////////////////////////////////////////////
    ///// CONSULTORES
    ////////////////////////////////////////////////////////////////////

    private void llistarAules() throws Exception {
        vAula.mostrarMissatge("- Llistar Aules");

        Vector<String> dades = cdAula.llistarAules();
        vAula.llistarAules(dades);
    }

    ////////////////////////////////////////////////////////////////////
    ///// MODIFICADORES
    ////////////////////////////////////////////////////////////////////

    private void afegirAula() throws Exception {
        vAula.mostrarMissatge("- Afegir Aula");

        String id = vAula.getID();
        int capacitat = vAula.getCapacitat();
        int tipus = vAula.getTipus();

        Vector<String> dades = new Vector<String>();
        dades.add(id);
        dades.add((new Integer(capacitat)).toString());
        String tipusAula = tipus == 1 ? "Teoria" : "Laboratori";
        dades.add(tipusAula);

        int codiError = cdAula.afegirAula(id, dades);

        switch (codiError) {
            case 0:
                vAula.mostrarMissatge("Aula afegida");
                break;
            case 1:
                vAula.mostrarError("L'aula ja existeix");
                break;
            case 2:
                vAula.mostrarError("Error d'inconsistència");
                break;
            default:
                vAula.mostrarError("Error impossible " + codiError);
                break;
        }
    }

    private void modificarAula() throws Exception {
        vAula.mostrarMissatge("- Modificar Aula");

        String id = vAula.getID();

        Vector<String> aula = cdAula.getAula(id);

        vAula.mostrarMissatge("Paràmetre a modificar:");

        int accio = -1;
        String modificar = null;
        while (accio != VistaAula.getNumOpcionsModificar()) {
            vAula.modificarAules(aula);

            accio = vAula.getOpcioModificar();

            switch (accio) {
                case 1:
                    modificar = vAula.getID();
                    break;
                case 2:
                    int capacitat = vAula.getCapacitat();
                    modificar = String.valueOf(capacitat);
                    break;
                case 3:
                    int tipus = vAula.getTipus();
                    modificar = tipus == 1 ? "Teoria" : "Laboratori";
                    break;
                default:
                    break;
            }
        }

        aula.set(accio-1, modificar);

        cdAula.modificarAula(id, aula);
    }

    private void eliminarAula() throws Exception {
        vAula.mostrarMissatge("- Eliminar Aula");

        String id = vAula.getID();

        int codiError = cdAula.eliminarAula(id);

        switch (codiError) {
            case 0:
                vAula.mostrarMissatge("Aula eliminada");
                break;
            case 1:
                vAula.mostrarMissatge("No existeix l'aula");
                break;
            default:
                vAula.mostrarError("Error impossible " + codiError);
                break;
        }
    }
}