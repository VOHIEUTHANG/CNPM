package ptithcm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ptithcm.entity.ChiTietBaiVietEntity;
import ptithcm.entity.VideoEntity;
import ptithcm.hibernate.HibernateUtil;

public class VideoDao {
    public  Integer Insert(VideoEntity bv){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(bv);
            t.commit();
        }
        catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return 0;
        }
        finally {
            session.close();
        }
        return 1;
    }
    public  Integer DeleteVideo(VideoEntity bv){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(bv);
            t.commit();
        }
        catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return 0;
        }
        finally {
            session.close();
        }
        return 1;
    }
}
