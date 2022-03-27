package pdp.uz.repository;

import pdp.uz.domain.Transaction;

public interface TransactionDao {
    void save(Transaction transaction);
}
