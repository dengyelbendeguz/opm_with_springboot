package hu.opm_with_springboot.opm_with_springboot;

import hu.opm_with_springboot.opm_with_springboot.Data.OwnersTable.OwnerRecord;
import hu.opm_with_springboot.opm_with_springboot.GUI.MainGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    MainGUI mainGUI;
    OwnerRecord owner;

    public MainController(OwnerRecord owner, MainGUI mainGUI){
        this.owner = owner;
        this.mainGUI = mainGUI;
    }
    public void drawGui(){
        JFrame frame = new JFrame("OPM");
        frame.setContentPane(mainGUI.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        mainGUI.getbNewRecord().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewRecordController newRecordController = new NewRecordController(owner);
                newRecordController.runGUI();
            }
        });
    }
}