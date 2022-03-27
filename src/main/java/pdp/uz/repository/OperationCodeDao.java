package pdp.uz.repository;

import pdp.uz.domain.OperationCode;

public interface OperationCodeDao {
    OperationCode findByName(String name);
}
