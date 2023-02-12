package hu.opm_with_springboot.opm_with_springboot.Data.OwnersTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PostgresOwnerDao implements OwnerDaoInterface {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresOwnerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertOwnerRecord(OwnerRecord ownerRecord) {
        String INSERT_OWNER_RECORD = "INSERT INTO owners (id, master_user, master_password) VALUES (?, ?, ?)";
        return jdbcTemplate.update(INSERT_OWNER_RECORD, ownerRecord.getId(), ownerRecord.getMasterUsername(), ownerRecord.getMasterPassword());
    }

    @Override
    public List<OwnerRecord> selectAllOwners() {
        String SELECT_ALL_OWNER = "SELECT * FROM  owners";
        return jdbcTemplate.query(SELECT_ALL_OWNER, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String masterUser = resultSet.getString("master_user");
            String masterPassword = resultSet.getString("master_password");
            return new OwnerRecord(id, masterUser, masterPassword);
        });
    }

    @Override
    public Optional<OwnerRecord> selectOwnerRecordByID(UUID id) {
        String SELECT_OWNER_BY_ID = "SELECT * FROM  owners WHERE id = ?";
        OwnerRecord ownerRecord = jdbcTemplate.queryForObject(SELECT_OWNER_BY_ID, new Object[]{id}, (resultSet, i) -> {
            String masterUser = resultSet.getString("master_user");
            String masterPassword = resultSet.getString("master_password");
            return new OwnerRecord(id, masterUser, masterPassword);
        });
        return Optional.ofNullable(ownerRecord);
    }

    @Override
    public int updateOwnerRecordByID(OwnerRecord ownerRecord) {
        String UPDATE_OWNER = "UPDATE owners SET master_user = ?, master_password = ? WHERE id = ?";
        return jdbcTemplate.update(UPDATE_OWNER, ownerRecord.getMasterUsername(), ownerRecord.getMasterPassword(), ownerRecord.getId());
    }

    @Override
    public int deleteOwnerRecordByID(UUID id) {
        String DELETE_OWNER = "DELETE FROM owners WHERE id = ?";
        return jdbcTemplate.update(DELETE_OWNER, id);
    }

    @Override
    public int flushOwnerTable() {
        String FLUSH_TABLE = "DELETE FROM owners";
        return jdbcTemplate.update(FLUSH_TABLE);
    }
}
