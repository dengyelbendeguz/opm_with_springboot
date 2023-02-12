package hu.opm_with_springboot.opm_with_springboot.Data.PasswordsTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PasswordDaoInterface {
    int insertPasswordRecord(PasswordRecord passwordRecord);
    List<PasswordRecord> selectAllPasswords();
    Optional<PasswordRecord> selectPasswordRecordByID(UUID id);
    int deletePasswordRecordByID(UUID id);
    int updatePasswordRecordByID(UUID id, PasswordRecord passwordRecord);
    int flushPasswordTable();
}
