package ptithcm.dao;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ptithcm.entity.BaiVietEntity;
import ptithcm.entity.TaiKhoanEntity;
import ptithcm.entity.TenQuyenEntity;
import ptithcm.hibernate.HibernateUtil;
public class NguoiDungDao {
	Session session;
    public TaiKhoanEntity findByUserName(String user_name){
        TaiKhoanEntity tk= new TaiKhoanEntity();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql="from TaiKhoanEntity AS tk where  tk.tenDN = :name";
            tk = session.createQuery(hql,TaiKhoanEntity.class).setParameter("name", user_name).uniqueResult();
            return tk;
        } catch(Exception e){
            return null;
        }
    }
	//retrun 2 bị trùng tên đăng nhập ,1 thành công, 0 thất bại
    public Integer insertUser (TaiKhoanEntity tk) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		if(this.findByUserName(tk.getTenDN())!=null)
		 return 2;
		try {
			tk.setTinhtrang(true);
			tk.setQuyen(this.getTenQuyen(2));
			session.save(tk);
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
    public TenQuyenEntity getTenQuyen(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "FROM TenQuyenEntity where maquyen =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		TenQuyenEntity list = (TenQuyenEntity) query.list().get(0);
		return list;
	}
    public Long getMaND(String username){
		TaiKhoanEntity tk = this.findByUserName(username);
        if(tk!=null){
          return tk.getNguoidung().getMaND();
		}
     return 0L;
	}
	public List<BaiVietEntity> getAllBaiviet(String username){
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String hql ="FROM BaiVietEntity where nguoidung.maND=:id";
			Query query = session.createQuery(hql);
			query.setParameter("id",this.getMaND(username));
			 return (List<BaiVietEntity>) query.list();
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		finally{
			session.close();
		}
  
	}
}
