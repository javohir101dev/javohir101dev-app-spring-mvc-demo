package pdp.uz.repository.impl;

import org.springframework.stereotype.Repository;
import pdp.uz.domain.Limit;
import pdp.uz.repository.GenericRepository;
import pdp.uz.repository.LimitDao;

@Repository
public class LimitDaoImpl extends GenericRepository implements LimitDao {

    @Override
    public Limit findByOperationCode(String operationCode) {
        return (Limit) getSession().createQuery("from Limit t where t.operationCode = '" + operationCode + "'").getSingleResult();
    }
}
