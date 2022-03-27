package pdp.uz.repository;

import pdp.uz.domain.Commission;

public interface CommissionDao {
    Commission findByOperationCode(String operationCode);
}
