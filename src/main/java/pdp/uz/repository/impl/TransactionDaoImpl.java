package pdp.uz.repository.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import pdp.uz.domain.Transaction;
import pdp.uz.repository.GenericRepository;
import pdp.uz.repository.TransactionDao;

@Repository
public class TransactionDaoImpl extends GenericRepository implements TransactionDao {

    @Override
    public void save(Transaction transaction) {
        Session session = getSession();
        session.saveOrUpdate(transaction);
    }
}
