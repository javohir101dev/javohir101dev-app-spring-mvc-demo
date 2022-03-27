package pdp.uz.repository.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import pdp.uz.domain.Operation;
import pdp.uz.repository.GenericRepository;
import pdp.uz.repository.OperationDao;

@Repository
public class OperationDaoImpl extends GenericRepository implements OperationDao {

    @Override
    public void save(Operation operation) {
        Session session = getSession();
        session.saveOrUpdate(operation);
    }
}
