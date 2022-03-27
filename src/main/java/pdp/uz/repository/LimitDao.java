package pdp.uz.repository;

import pdp.uz.domain.Limit;

public interface LimitDao {
    Limit findByOperationCode(String operationCode);
}
