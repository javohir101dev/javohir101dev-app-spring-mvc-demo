package pdp.uz.repository.impl;

import org.springframework.stereotype.Repository;
import pdp.uz.domain.OperationCode;
import pdp.uz.repository.GenericRepository;
import pdp.uz.repository.OperationCodeDao;

@Repository
public class OperationCodeDaoImpl extends GenericRepository implements OperationCodeDao {

    @Override
    public OperationCode findByName(String name) {
        return (OperationCode) getSession().createQuery("from OperationCode t where t.name = '" + name + "'").getSingleResult();
    }
}
