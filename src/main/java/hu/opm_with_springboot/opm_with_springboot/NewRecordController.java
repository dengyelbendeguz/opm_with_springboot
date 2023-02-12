package hu.opm_with_springboot.opm_with_springboot;


import hu.opm_with_springboot.opm_with_springboot.Data.OwnersTable.OwnerRecord;
import hu.opm_with_springboot.opm_with_springboot.Data.PasswordsTable.PasswordRecord;
import hu.opm_with_springboot.opm_with_springboot.GUI.NewRecordGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewRecordController {
    NewRecordGUI newRecordGUI;
    JFrame frameNRGUI;
    OwnerRecord ownerRecord;

    public NewRecordController(OwnerRecord ownerRecord){
        newRecordGUI = new NewRecordGUI();
        frameNRGUI = new JFrame("OPM");
        this.ownerRecord = ownerRecord;
    }

    public void runGUI(){
        frameNRGUI.setContentPane(newRecordGUI.getPanelMain());
        frameNRGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNRGUI.pack();
        frameNRGUI.setVisible(true);
        newRecordGUI.getbSaveRecord().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newRecordGUI.getTaAccountName().getText().isEmpty()
                && !newRecordGUI.getTaUsername().getText().isEmpty()
                && !newRecordGUI.getPtaPassword().getText().isEmpty()){
                    PasswordRecord newPasswordRecord = new PasswordRecord(
                            ownerRecord.getMasterUsername(),
                            newRecordGUI.getTaAccountName().getText(),
                            newRecordGUI.getTaUsername().getText(),
                            newRecordGUI.getPtaPassword().getText(),
                            newRecordGUI.getTaWebPage().getText(),
                            newRecordGUI.getTaComment().getText()
                    );
                    JOptionPane.showMessageDialog(null, "nice");
                    //TODO. create and save db record here
                    //akkor hozza létre, ha owner és cím nem egyezik meg
                    newPasswordRecord.printRecord();
                }else {
                    JOptionPane.showMessageDialog(null, "Please fill out the required fields!");
                }

            }
        });
    }
}
