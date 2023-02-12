package hu.opm_with_springboot.opm_with_springboot.Data.PasswordsTable;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class PasswordRecord {
    private final UUID id;
    @NotBlank
    private final String Owner; //idegen kulcs az opm_usernammel
    @NotBlank
    private final String Title;
    private final String Username;
    private final String Password;
    private final String WebPage;
    private final String Comment;

    public UUID getId() {
        return id;
    }

    public String getOwner() {
        return Owner;
    }

    public String getTitle() {
        return Title;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getWebPage() {
        return WebPage;
    }

    public String getComment() {
        return Comment;
    }

    public PasswordRecord(@JsonProperty("id") UUID id,
                          @JsonProperty("owner") String owner,
                          @JsonProperty("title") String title,
                          @JsonProperty("username") String username,
                          @JsonProperty("password") String password,
                          @JsonProperty("web_page") String webpage,
                          @JsonProperty("comment") String comment) {
        this.id = id;
        Owner = owner;
        Title = title;
        Username = username;
        Password = password;
        WebPage = webpage;
        Comment = comment;
    }

    public PasswordRecord(@JsonProperty("owner") String owner,
                          @JsonProperty("title") String title,
                          @JsonProperty("username") String username,
                          @JsonProperty("password") String password,
                          @JsonProperty("web_page") String webpage,
                          @JsonProperty("comment") String comment) {
        this.id = UUID.randomUUID();
        Owner = owner;
        Title = title;
        Username = username;
        Password = password;
        WebPage = webpage;
        Comment = comment;
    }

    public void printRecord() {
        System.out.printf("ID: %s, Owner: %s, Title: %s, Username: %s, Password: %s, Web Page: %s, Comment: %s %n",
                id, Owner, Title, Username, Password, WebPage, Comment);
    }
}