package presentacio.CarregarDades;

import dominio.controladores.CtrlPresentacio;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class vistaCarregarDades extends JFrame{

    private JLabel titol = new JLabel("Carregar Dades");

    private JButton carregarDirectori = new JButton("Carregar per carpeta");
    private JButton carregarAssignaturesButton = new JButton("Carregar fitxer assignatures");
    private JButton carregarAulesButton = new JButton("Carregar fitxer aules");
    private JButton carregarPlaEstudisButton = new JButton("Carregar fitxer pla estudis");

    private JButton endarrereButton = new JButton("Endarrere");


    public vistaCarregarDades() {

        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        // Títol

        titol.setBounds(100,50,200,30);
        add(titol);

        // Carregar Directori

        carregarDirectori.setBounds(50, 110, 200, 30);
        add(carregarDirectori);

        // Carregar Assignatures

        carregarAssignaturesButton.setBounds(50, 150, 200, 30);
        add(carregarAssignaturesButton);

        // Carregar Aules

        carregarAulesButton.setBounds(50, 190, 200, 30);
        add(carregarAulesButton);

        // Carregar Pla Estudis

        carregarPlaEstudisButton.setBounds(50, 230, 200, 30);
        add(carregarPlaEstudisButton);

        // Botó Endarrere

        endarrereButton.setBounds(50,270,200,30);
        add(endarrereButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ActionListener listenerDirectori = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                chooser.setDialogTitle("Selecciona la carpeta que conté el set de dades");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/data/dades"));
                int returnValue = chooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooser.getSelectedFile();
                    System.out.println("Carpeta escollida: " + arxiu.getAbsolutePath());
                    CtrlPresentacio.carregarDirectori(arxiu.getAbsolutePath());
                }
            }
        };

        ActionListener carregarAssignatures = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooserAssig = new JFileChooser();
                chooserAssig.setDialogTitle("Seleccionar Assignatures");
                chooserAssig.setCurrentDirectory(new File(System.getProperty("user.dir") + "/data/dades"));
                int returnValue = chooserAssig.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooserAssig.getSelectedFile();
                    CtrlPresentacio.carregarDadesAssignatures(arxiu.getAbsolutePath());
                }
            }
        };

        ActionListener carregarAules = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooserAules = new JFileChooser();;
                chooserAules.setDialogTitle("Seleccionar Aules");
                chooserAules.setCurrentDirectory(new File(System.getProperty("user.dir") + "/data/dades"));
                int returnValue = chooserAules.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooserAules.getSelectedFile();
                    CtrlPresentacio.carregarDadesAules(arxiu.getAbsolutePath());
                }
            }
        };


        ActionListener carregarPlaEstudis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooserPlaEstudis = new JFileChooser();;
                chooserPlaEstudis.setDialogTitle("Seleccionar Pla Estudis");
                chooserPlaEstudis.setCurrentDirectory(new File(System.getProperty("user.dir") + "/data/dades"));
                int returnValue = chooserPlaEstudis.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File arxiu = chooserPlaEstudis.getSelectedFile();
                    CtrlPresentacio.carregarDadesPlaEstudis(arxiu.getAbsolutePath());
                }
            }
        };

        ActionListener vistaPrincipal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacio.inicialitzarPresentacio();
                setVisible(false);
            }

        };

        carregarDirectori.addActionListener(listenerDirectori);
        carregarAssignaturesButton.addActionListener(carregarAssignatures);
        carregarAulesButton.addActionListener(carregarAules);
        carregarPlaEstudisButton.addActionListener(carregarPlaEstudis);
        endarrereButton.addActionListener(vistaPrincipal);

    }

}
