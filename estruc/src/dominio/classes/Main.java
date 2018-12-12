package Dominio;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.security.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import JSON.JSONArray;
import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;



public class Main {

    private static inout io = new inout();

    /////////////////////////////////////////////////////////////////
    /// GENERAR HORARI
    /////////////////////////////////////////////////////////////////

    private static void menuGenerarHorari() throws Exception {

        int accio = -1;

        while (accio != 0) {
            escriureMenuPrincipal();
            accio = io.readint();

            switch (accio) {
                case 1:
                    carregarDades();
                    break;
                case 2:
                    CtrlDomini.generarHorari();
                    break;
                case 3:
                    CtrlDomini.guardarHorari();
                    break;
                case 4:
                    CtrlDomini.llegirHorari();
                    break;
                default:
                    break;
            }
        }

    }

    private static void carregarAules(String dataPath) {
        JSONParser parser = new JSONParser();


        try {
            JSONArray arrayAules = (JSONArray) parser.parse(new FileReader(dataPath + "aules.json"));

            for (int i = 0; i < arrayAules.size(); i++) {

                Aula a = new Aula();

                JSONObject jsonObject = (JSONObject) arrayAules.get(i);

                String id = (String) jsonObject.get("id");
                Integer capacitat = (int) (long) jsonObject.get("capacitat");
                String tipus = (String) jsonObject.get("tipus");

                Enumeracio.TipusAula tAula = tipus.equals("TEORIA") ? Enumeracio.TipusAula.TEORIA : Enumeracio.TipusAula.LABORATORI;

                a.setId(id);
                a.setCapacitat(capacitat);
                a.setTipus(tAula);

                PlaEstudis.getConjuntAules().afegirAula(a);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void carregarAssignatures(String dataPath) {
        JSONParser parser = new JSONParser();
        try {

            JSONArray arrayAssignatures = (JSONArray) parser.parse(new FileReader(dataPath + "assignatures.json"));

            for (int i = 0; i < arrayAssignatures.size(); i++) {

                Assignatura a = new Assignatura();

                JSONObject jsonObject = (JSONObject) arrayAssignatures.get(i);

                a.setNom((String) jsonObject.get("nom"));

                a.setNivell((int) (long) jsonObject.get("nivell"));

                a.setnHoresT((int) (long) jsonObject.get("nHoresT"));
                a.setnHoresL((int) (long) jsonObject.get("nHoresL"));
                a.setnHoresP((int) (long) jsonObject.get("nHoresP"));

                a.setnGrupsT((int) (long) jsonObject.get("nGrupsT"));
                a.setnGrupsL((int) (long) jsonObject.get("nGrupsL"));
                a.setnGrupsP((int) (long) jsonObject.get("nGrupsP"));

                a.setnGrupsMati((int) (long) jsonObject.get("nGrupsMati"));

                a.setnAlumnesT((int) (long) jsonObject.get("nAlumnesT"));
                a.setnAlumnesL((int) (long) jsonObject.get("nAlumnesL"));
                a.setnAlumnesP((int) (long) jsonObject.get("nAlumnesP"));

                a.setHoresBlocT((int) (long) jsonObject.get("horesBlocT"));
                a.setHoresBlocL((int) (long) jsonObject.get("horesBlocL"));
                a.setHoresBlocP((int) (long) jsonObject.get("horesBlocP"));

                JSONArray arrayCorrequisits = (JSONArray) jsonObject.get("correquisits");

                Set<String> setCore = new HashSet<>();

                for (Object co : arrayCorrequisits) {
                    setCore.add(co.toString());
                }

                a.setCorrequisits(setCore);

                PlaEstudis.afegirAssignatura(a);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void carregarPlaEstudis(String dataPath) {
        JSONParser parser = new JSONParser();
        try {


            JSONObject plaEstudisOjbect = (JSONObject) parser.parse(new FileReader(dataPath + "plaEstudis.json"));

            PlaEstudis.setHoraInici((int) (long) plaEstudisOjbect.get("horaInici"));
            PlaEstudis.setHoraFi((int) (long) plaEstudisOjbect.get("horaFi"));
            PlaEstudis.setHoraCanviFranja((int) (long) plaEstudisOjbect.get("horaCanviFranja"));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void carregarDades() throws Exception {
        String dataPath = new String();
        io.writeln("- Selecciona el conjunt de dades que vols carregar");
        io.writeln("");
        String folder = new String();
        folder = io.readname();
        dataPath = "./Dades/" + folder + "/";

        PlaEstudis.reset();

        carregarAules(dataPath);
        carregarAssignatures(dataPath);
        carregarPlaEstudis(dataPath);
    }




    private static void escriureMenuPrincipal() throws Exception {
        io.writeln("////////////////////////////");
        io.writeln("// MENÚ PRINCIPAL");
        io.writeln("////////////////////////////");
        io.writeln("");
        io.writeln("1] Carregar Set De Dades");
        io.writeln("2] Generar Horari");
        io.writeln("3] Guardar Horari");
        io.writeln("4] Carregar Horari");
        io.writeln("0] Sortir de l'aplicació");
    }

    private void escriureError(int nError) throws Exception {
        switch (nError){
            case 1:
                io.writeln("Error: Indica una de les opcions!");
                break;
        }
    }

    public static void main(String[] args) throws Exception {

        menuGenerarHorari();
    }
}