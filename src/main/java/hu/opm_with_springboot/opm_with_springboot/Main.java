package hu.opm_with_springboot.opm_with_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        SpringApplication.run(Main.class, args);
        //hu.opm_with_springboot.opm_with_springboot.MainController mainController = new hu.opm_with_springboot.opm_with_springboot.MainController(new OwnerRecord("owner1Username", "owner1Password"),new MainGUI());
        //mainController.drawGui();

        /*String url = "jdbc:postgresql://localhost:5432/opm";
        String user = "postgres";
        String password = "szakdoga";

        PostgreOwnerDao ownerDAO = new PostgreOwnerDao(url, user, password);
        ownerDAO.emptyDBRecordTable();
        OwnerRecord ownerRecord1 = new OwnerRecord("master_user1", "master_password1");
        OwnerRecord ownerRecord2 = new OwnerRecord("master_user2", "master_password2");
        ownerRecord1.setId(ownerDAO.addDBRecord(ownerRecord1));
        ownerRecord2.setId(ownerDAO.addDBRecord(ownerRecord2));
        ArrayList<OwnerRecord> ownerRecords = ownerDAO.listDBRecords();
        for (OwnerRecord record: ownerRecords) {
            record.printRecord();
        }

        ownerDAO.deleteDBRecord(ownerRecord1.getId());
        ownerDAO.updateDBRecord(new OwnerRecord(ownerRecord2.getId(), ownerRecord2.getMasterUsername(),
                "new_master_password2"));

        System.out.println("Deleting and altering records:");
        ownerRecords = ownerDAO.listDBRecords();
        for (OwnerRecord record: ownerRecords) {
            record.printRecord();
        }*/

        /*PostgrePasswordDao pwDAO = new PostgrePasswordDao(url, user, password);
        pwDAO.emptyDBRecordTable();
        PasswordRecord record1 = new PasswordRecord("master_user1", "google account", "googleuser",
                "googlepassword", "google.com", "google comment");
        PasswordRecord record2 = new PasswordRecord("master_user1", "facebook account", "facebookuser",
                "facebookpassword", "facebook.com", "facebook comment");
        PasswordRecord record3 = new PasswordRecord("owner2", "cisco account", "ciscouser",
                "ciscopassword", "cisco.com", "cisco comment");
        record1.setId(pwDAO.addDBRecord(record1));
        record2.setId(pwDAO.addDBRecord(record2));
        record3.setId(pwDAO.addDBRecord(record3));

        pwDAO.deleteDBRecord(record1.getId());
        pwDAO.updateDBRecord(new PasswordRecord(
                record2.getId(),
                record2.getOwner(),
                record2.getTitle(),
                record2.getUsername(),
                "new_facebook_password",
                record2.getWebPage(),
                record2.getComment()));
        ArrayList<PasswordRecord> records = pwDAO.listDBRecords();
        for (PasswordRecord record: records) {
            record.printRecord();
        }*/
    }
}
