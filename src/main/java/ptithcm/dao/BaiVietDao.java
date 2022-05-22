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
    public List < BaiVietEntity > getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from BaiVietEntity", BaiVietEntity.class).list();
        }
		catch(Exception e){
		return null;
	}
		finally{
		session.close();
	}
	}

	public List < BaiVietEntity > getAllForParticularUser(String id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM BaiVietEntity WHERE MaND = " + id;
			System.out.println(hql);
			return session.createQuery(hql, BaiVietEntity.class).list();
		}
		catch(Exception e){
			System.out.println("Insert Post Failure !");
			return null;
		}
		finally{
			session.close();
		}

	}

    public List<BaiVietEntity> getById(Long id) {
		Session session= HibernateUtil.getSessionFactory().openSession();
        try  {
            String hql="from BaiVietEntity where mabaiviet = "+ String.valueOf(id);
            Query query = session.createQuery(hql);
            return query.list();
        }
		catch(Exception e){
			return null;
		}
		finally{
			session.close();
		}
		
    }
	public  int UpdateBaiViet (BaiVietEntity bv){
		Session session = HibernateUtil.getSessionFactory().openSession();
		BaiVietEntity updatePost = (BaiVietEntity) session.merge(bv);
		Transaction t = session.beginTransaction();
		try {
			session.update(updatePost);
			t.commit();
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		}
		finally {
			session.close();
			System.out.println(" Update Post Finally!");
		}
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
		try {
	session.beginTransaction();
	String hql = "FROM NguoiDungEntity where maND =:id";
	Query query = session.createQuery(hql); query.setParameter("id", id); 
	NguoiDungEntity list = (NguoiDungEntity) query.list().get(0); 
	return list;

	}
		catch(Exception e){
		return null;
	}
		finally{
		session.close();
	}}
	public boolean SetAn(BaiVietEntity bv){
		Session session= HibernateUtil.getSessionFactory().openSession();
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
