package ptithcm.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ptithcm.entity.BaiVietEntity;
import ptithcm.entity.NguoiDungEntity;
import ptithcm.entity.TaiKhoanEntity;
import ptithcm.entity.TenQuyenEntity;
import ptithcm.hibernate.HibernateUtil;

public class BaiVietDao {
	Session session ;
    public List < BaiVietEntity > getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from BaiVietEntity", BaiVietEntity.class).list();
        }
    }
    public List<BaiVietEntity> getById(Long id) {
        try  {
			session= HibernateUtil.getSessionFactory().openSession();
            String hql="from BaiVietEntity where mabaiviet = "+ String.valueOf(id);
            Query query =session.createQuery(hql);
            return query.list();
        }
		catch(Exception e){
			return null;
		}
		finally{
			session.close();
		}
		
    }
	public  Integer UpdateBaiViet (BaiVietEntity bv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(bv);
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

    public Integer insertBaiViet (BaiVietEntity bv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			bv.setTinhtrang(Boolean.FALSE);
			bv.setAn(Boolean.FALSE);
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
	public NguoiDungEntity getNguoidung(Long id) { 
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	String hql = "FROM NguoiDungEntity where maND =:id";
	Query query = session.createQuery(hql); query.setParameter("id", id); 
	NguoiDungEntity list = (NguoiDungEntity) query.list().get(0); 
	return list; }
	public boolean SetAn(BaiVietEntity bv){
		session= HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		boolean a= !bv.getAn();
		bv.setAn(a);
		try {  
		   session.update(bv);
           t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return false;
		}
		finally{
			session.close();
		}
		return true;
	}
	 
}
