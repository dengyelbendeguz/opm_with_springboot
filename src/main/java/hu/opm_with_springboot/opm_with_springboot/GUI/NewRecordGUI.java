package hu.opm_with_springboot.opm_with_springboot.GUI;

import javax.swing.*;

public class NewRecordGUI {
    private JPanel panelMain;

    public JPanel getPanelButtons() {
        return panelButtons;
    }

    public JButton getbSaveRecord() {
        return bSaveRecord;
    }

    public JPanel getPanelUsername() {
        return panelUsername;
    }

    public JTextArea getTaUsername() {
        return taUsername;
    }

    public JButton getbCopyUsername() {
        return bCopyUsername;
    }

    public JPanel getPanelGeneratePassword() {
        return panelGeneratePassword;
    }

    public JButton getbGeneratePassword() {
        return bGeneratePassword;
    }

    public JTextField getTfGeneratedPassword() {
        return tfGeneratedPassword;
    }

    public JButton getbCopyGeneratedPassword() {
        return bCopyGeneratedPassword;
    }

    public JPanel getPanelPassword() {
        return panelPassword;
    }

    public JPasswordField getPtaPassword() {
        return ptaPassword;
    }

    public JButton getbShowPassword() {
        return bShowPassword;
    }

    public JButton getbCopyPassword() {
        return bCopyPassword;
    }

    public JPanel getPanelWebPage() {
        return panelWebPage;
    }

    public JTextArea getTaWebPage() {
        return taWebPage;
    }

    public JButton getbCopyWebPage() {
        return bCopyWebPage;
    }

    public JLabel getLabelRecordTitle() {
        return labelRecordTitle;
    }

    public JTextArea getTaAccountName(){
        return taAccountName;
    }

    public JTextArea getTaComment(){
        return taComment;
    }

    private JPanel panelButtons;
    private JButton bSaveRecord;
    private JPanel panelUsername;
    private JTextArea taUsername;
    private JButton bCopyUsername;
    private JPanel panelGeneratePassword;
    private JButton bGeneratePassword;
    private JTextField tfGeneratedPassword;
    private JButton bCopyGeneratedPassword;
    private JPanel panelPassword;
    private JPasswordField ptaPassword;
    private JButton bShowPassword;
    private JButton bCopyPassword;
    private JPanel panelWebPage;
    private JTextArea taWebPage;
    private JButton bCopyWebPage;
    private JLabel labelRecordTitle;
    private JTextArea taAccountName;
    private JTextArea taComment;
    private JPanel panelComment;

    public JPanel getPanelMain(){
        return panelMain;
    }
}
