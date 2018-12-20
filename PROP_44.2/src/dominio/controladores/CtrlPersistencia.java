package dominio.controladores;

// Repàs
import dominio.classes.*;

import java.util.Map;

public class CtrlPersistencia {

    private static CtrlPersistencia instance = new CtrlPersistencia();

    private static CtrlDomini ctrlDomini = CtrlDomini.getInstance();
    private static CtrlPersistenciaCarregarDades ctrlPersistenciaCarregarDades =
            CtrlPersistenciaCarregarDades.getInstance();
    private static CtrlPersistenciaGuardarHorari ctrlPersistenciaGuardarHorari =
            CtrlPersistenciaGuardarHorari.getInstance();
    private static CtrlPersistenciaCarregarHorari ctrlPersistenciaCarregarHorari =
            CtrlPersistenciaCarregarHorari.getInstance();

    private CtrlPersistencia() {}

    public static CtrlPersistencia getInstance() {
        return instance;
    }


    // [ Opció 1 ] : Carregar Dades
    ////////////////////////////////

    public static String[][] carregarAules(String path) {
        return ctrlPersistenciaCarregarDades.carregarAules(path);
    }

    public static String[][] carregarAssignatures(String path) {
        return ctrlPersistenciaCarregarDades.carregarAssignatures(path);
    }

    public static String[] carregarPlaEstudis(String path) {
        return ctrlPersistenciaCarregarDades.carregarPlaEstudis(path);
    }

    // [ Opció 3 ] : Guardar Horari
    ////////////////////////////////

    public static void guardarHorari(Map<String, Matriu> ultimHorari, String nomFitxer) {
        ctrlPersistenciaGuardarHorari.guardarHorari(ultimHorari, nomFitxer);
    }

    // [ Opció 4 ] : Carregar Horari
    ////////////////////////////////

    public static Map<String, Matriu> llegirHorari(String path) {
        Map<String, Matriu> horari = CtrlPersistenciaCarregarHorari.llegirHorari(path);
        return horari;
    }

}