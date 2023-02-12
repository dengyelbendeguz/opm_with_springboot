package hu.opm_with_springboot.opm_with_springboot.Data.PasswordsTable;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PostgresPasswordDao implements PasswordDaoInterface {
    private final JdbcTemplate jdbcTemplate;

    public PostgresPasswordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPasswordRecord(PasswordRecord passwordRecord) {
        String INSERT_PASSWORD_RECORD = "INSERT INTO passwords (id, owner, title, username, password, web_page, comment) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(INSERT_PASSWORD_RECORD, passwordRecord.getId(), passwordRecord.getOwner(), passwordRecord.getTitle(), passwordRecord.getUsername(), passwordRecord.getPassword(), passwordRecord.getWebPage(), passwordRecord.getComment());
    }

    @Override
    public List<PasswordRecord> selectAllPasswords() {
        String SELECT_ALL_PASSWORDS = "SELECT * FROM passwords";
        return jdbcTemplate.query(SELECT_ALL_PASSWORDS, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String owner = resultSet.getString("owner");
            String title = resultSet.getString("title");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String web_page = resultSet.getString("web_page");
            String comment = resultSet.getString("comment");
            return new PasswordRecord(id, owner, title, username, password, web_page, comment);
        });
    }

    @Override
    public Optional<PasswordRecord> selectPasswordRecordByID(UUID id) {
        String SELECT_PASSWORD_BY_ID = "SELECT * FROM passwords WHERE id = ?";
        PasswordRecord passwordRecord = jdbcTemplate.queryForObject(SELECT_PASSWORD_BY_ID, new Object[]{id}, (resultSet, i) -> {
            String owner = resultSet.getString("owner");
            String title = resultSet.getString("title");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String web_page = resultSet.getString("web_page");
            String comment = resultSet.getString("comment");
            return new PasswordRecord(id, owner, title, username, password, web_page, comment);
        });
        return Optional.ofNullable(passwordRecord);
    }

    @Override
    public int updatePasswordRecordByID(UUID id, PasswordRecord passwordRecord) {
        String UPDATE_PASSWORD = "UPDATE passwords SET owner = ?, title = ?, username = ?, password = ?, web_page = ?, comment = ? WHERE id = ?";
        return jdbcTemplate.update(UPDATE_PASSWORD, passwordRecord.getOwner(), passwordRecord.getTitle(), passwordRecord.getUsername(), passwordRecord.getPassword(), passwordRecord.getWebPage(), passwordRecord.getComment(), passwordRecord.getId());
    }

    @Override
    public int deletePasswordRecordByID(UUID id) {
        String DELETE_PASSWORD = "DELETE FROM passwords WHERE id = ?";
        return jdbcTemplate.update(DELETE_PASSWORD);
    }

    @Override
    public int flushPasswordTable() {
        String FLUSH_TABLE = "DELETE FROM passwords";
        return jdbcTemplate.update(FLUSH_TABLE);
    }

}
