package ptithcm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ptithcm.entity.ThongBaoEntity;
import ptithcm.hibernate.HibernateUtil;

public class ThongBaoDao {
    public Integer InsertTB(ThongBaoEntity tb){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(tb);
            t.commit();
        }
        catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return 0;
        }
        finally {
            session.close();
            return 1;
        }

    }
}
