package hu.opm_with_springboot.opm_with_springboot.Data.OwnersTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class OwnerRecord {
    private final UUID id;
    @NotBlank
    private final String MasterUsername;
    @NotBlank
    private final String MasterPassword;
    //private String Salt;

    public UUID getId() {
        return id;
    }

    public String getMasterUsername() {
        return MasterUsername;
    }

    public String getMasterPassword() {
        return MasterPassword;
    }

    public OwnerRecord(@JsonProperty("id") UUID id,
                       @JsonProperty("master_username") String masterUsername,
                       @JsonProperty("master_password")String masterPassword){
        this.id = id;
        MasterUsername = masterUsername;
        MasterPassword = masterPassword;
    }
    public OwnerRecord(@JsonProperty("master_username") String masterUsername,
                       @JsonProperty("master_password")String masterPassword){
        this.id = UUID.randomUUID();
        MasterUsername = masterUsername;
        MasterPassword = masterPassword;
    }

    public void printRecord() {
        System.out.printf("ID: %s, Master Username: %s, Master Password: %s%n", id, MasterUsername, MasterPassword);
    }
}