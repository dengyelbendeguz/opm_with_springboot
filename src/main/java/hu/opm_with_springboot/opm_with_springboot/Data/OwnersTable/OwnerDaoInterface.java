package hu.opm_with_springboot.opm_with_springboot.Data.OwnersTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface OwnerDaoInterface {
    int insertOwnerRecord(OwnerRecord ownerRecord);
    List<OwnerRecord> selectAllOwners();
    Optional<OwnerRecord> selectOwnerRecordByID(UUID id);
    int deleteOwnerRecordByID(UUID id);
    int updateOwnerRecordByID(OwnerRecord ownerRecord);
    int flushOwnerTable();
}
