package ptithcm.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import ptithcm.dao.NguoiDungDao;
import ptithcm.entity.NguoiDungEntity;
import ptithcm.entity.TaiKhoanEntity;
import ptithcm.hibernate.HibernateUtil;
import ptithcm.service.Interface.IUserService;

@Service
public class UserService implements IUserService {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    // Lấy user name đã đăng đăng nhập
    public String currentUserName() {
        Authentication authentication = this.getAuthentication();
        return authentication.getName();
    }
    public String Signup( JSONObject data,BCryptPasswordEncoder passwordEncoder)
    {
        String fullName = data.getString("fullname");
        String password = data.getString("password");
        String email = data.getString("email");
        String phoneNumber = data.getString("phoneNumber");
        String username = data.getString("username");
        String address = data.getString("address");
        NguoiDungDao nguoiDungDao =new NguoiDungDao();
        TaiKhoanEntity tk =new TaiKhoanEntity();
        NguoiDungEntity nguoiDung =new NguoiDungEntity();
        nguoiDung.setDiachi(address);
        nguoiDung.setEmail(email);
        nguoiDung.setTenND(fullName);
        nguoiDung.setSdt(phoneNumber);
        tk.setTenDN(username);
        tk.setMatkhau(passwordEncoder.encode(password));
        int checkES=nguoiDungDao.checkEmailSdt(email,phoneNumber);
        if(checkES==2) {
            return "Số điện thoại hoặc email đã được sử dụng";
        }
        if(checkES==0)
        return "Có lỗi xảy ra, hãy thử lại sau";
         int checkNgd= nguoiDungDao.insertTk(tk);
        if(checkNgd==2){
            return "Tên đăng nhập đã bị trùng";
        }
        if(checkNgd==0){

        }
        nguoiDung.setTaikhoan(this.find(username));
        if(nguoiDungDao.insert(nguoiDung)==0)
            return "Có lỗi xảy ra, hãy thử lại sau";
        return "Thành công";
    }
    public UserService(){
        super();
    }
    public TaiKhoanEntity find(String name){
        TaiKhoanEntity tk= new TaiKhoanEntity();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql="from TaiKhoanEntity AS tk where  tk.tenDN = :name";
            tk = session.createQuery(hql,TaiKhoanEntity.class).setParameter("name", name).uniqueResult();
            return tk;
        } catch(Exception e){
            return null;
        }
    }

}
