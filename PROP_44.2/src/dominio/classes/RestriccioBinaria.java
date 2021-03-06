package dominio.classes;

import dominio.controladores.CtrlDomini;
import dominio.controladores.CtrlDominiGenerarHorari;

import java.util.*;

public class RestriccioBinaria {

    public static HashSet<Sessio> arestesCorrequisits(Sessio s) {
        HashSet<Sessio> resultat = new HashSet<>();
        for (Assignatura correq : s.getAssignatura().getCorrequisits().getAssignatures())
            resultat.addAll(CtrlDominiGenerarHorari.getSessionsByIdAssig(correq.getNom()));

        return resultat;
    }

    public static HashSet<Sessio> arestesSessio(Sessio s) {
        HashSet<Sessio> resultat = new HashSet<>();
        for (Sessio sessio : CtrlDominiGenerarHorari.getSessionsByIdAssig(s.getAssignatura().getNom()))
            if ((s.getTipus() == sessio.getTipus()) && (s.getIdGrup() == sessio.getIdGrup()))
                resultat.add(sessio);
        return resultat;
    }

    public static HashSet<Sessio> arestesNivell(Sessio s) {
        HashSet<Sessio> resultat = new HashSet<>();

        int NivellSessio = CtrlDomini.getPlaEstudis().getConjuntAssignatures().getAssignatura(s.getAssignatura().getNom()).getNivell();

        // Iterem per totes les assignatures del mateix nivell que s
        for (Assignatura a : CtrlDomini.getPlaEstudis().getConjuntAssignatures().getAssigsByNivell(NivellSessio)) {
            // Iterem per totes les sessions de totes les assignatures del nivell de s
            for (Sessio sAssig : CtrlDominiGenerarHorari.getSessionsByIdAssig(a.getNom())) {
                if (s != sAssig) {
                    // Si la sessió s és de teoria
                    if (s.getTipus().equals(Enumeracio.TipusSessio.TEORIA)) {
                        // Si es de teoria no es pot solapar amb el mateix grup T/L [10,11]
                        if ((s.getIdGrup()/10) == (sAssig.getIdGrup()/10)) {
                            resultat.add(sAssig);
                        }
                    }
                    // Si és de LAB o PROB
                    else {
                        if (sAssig.getTipus().equals(Enumeracio.TipusSessio.TEORIA)) {
                            if ((s.getIdGrup()/10) == (sAssig.getIdGrup()/10)) {
                                resultat.add(sAssig);
                            }
                        }
                        else {
                            if (s.getIdGrup() == sAssig.getIdGrup()) {
                                resultat.add(sAssig);
                            }
                        }
                    }
                }

            }
        }
        return resultat;
    }
    //public static boolean valida()

    public static boolean validaSolucio(Horari h, Sessio s, UAH uah) {

        // Comprovem si la UAH ja ha estat assignada previament a una altra sessio
        if (h.existeixUAH(s, uah)) {
            return false;
        }
        int compt = 0;
        for (UAH uah2 : h.getAssignacio().get(s))
            if (uah2 == uah) ++compt;
        if (compt > 1) return false;

        switch (s.getTipus()) {
            case TEORIA:
                if (uah.getAula().getCapacitat() < s.getAssignatura().getnAlumnesT()) return false;
                break;
            case LABORATORI:
                if (uah.getAula().getCapacitat() < s.getAssignatura().getnAlumnesL()) return false;
                break;
            case PROBLEMES:
                if (uah.getAula().getCapacitat() < s.getAssignatura().getnAlumnesP()) return false;
                break;
            default:
                break;
        }

        // Les Sessions que tenen conflicte amb s
        for(Sessio sessioConflicte : GeneradorHorari.getG().getArestes().get(s)) {
            // Si la solució té un valor assignat per una sessió conflictiva (s)
            if (h.getAssignacio().containsKey(sessioConflicte)) {
                for (UAH uahConflicte : h.getAssignacio().get(sessioConflicte)) {
                    if (coincideixenUAH(uah, uahConflicte)) return false;
                }
            }
        }
        return true;
    }

    public static boolean coincideixenUAH (UAH a, UAH b) {
        return ((a.getDia() == b.getDia()) && (a.getHora() == b.getHora()));
    }
}