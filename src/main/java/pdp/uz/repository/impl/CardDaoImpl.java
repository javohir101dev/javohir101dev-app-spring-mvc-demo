package pdp.uz.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pdp.uz.domain.Card;
import pdp.uz.repository.CardDao;

import java.util.List;

@Repository
public class CardDaoImpl implements CardDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Card> getCardList() {
        Session session = sessionFactory.getCurrentSession();
        List<Card> list = session.createNativeQuery("select * from cards t where t.is_active = true").list();
        return list;
    }
}
