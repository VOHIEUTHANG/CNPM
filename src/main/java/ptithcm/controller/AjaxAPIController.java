package ptithcm.controller;
import com.nimbusds.oauth2.sdk.Response;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ptithcm.Object.User;
import ptithcm.dao.*;
import ptithcm.entity.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.UUID;


import ptithcm.hibernate.HibernateUtil;
import ptithcm.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/api")
public class AjaxAPIController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ServletContext context;
    @Autowired
    UserService userService ;
    private Session session;
    public String getFileExtension(String fileName){
        String filelEx;
        int dotIndex = fileName.lastIndexOf(".");
        return fileName.substring(dotIndex);
    }

    public String writeFile(MultipartFile fileParam, String currentPath) throws IOException {
        UUID uniqueKey = UUID.randomUUID();
        byte[] bytes = fileParam.getBytes();
        String fileExtension = getFileExtension(fileParam.getOriginalFilename());
        Path path = Paths.get(context.getRealPath("//Storage//" + currentPath + "//")  + uniqueKey +  fileExtension);
        Files.write(path, bytes);
        return uniqueKey.toString()+fileExtension;
    }

    @RequestMapping("/dangky")
    public String getForm(){
        return "/user/signup-page";
    }

    @RequestMapping(value = "/post-upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;multipart/form-data")
    @ResponseBody
    public String getThongTin(@RequestParam("images") MultipartFile[] files,@RequestParam("video") MultipartFile video,HttpServletRequest req) throws IOException {JSONObject data= new JSONObject(req.getParameter("info"));
        NguoiDungDao userDao = new NguoiDungDao();
        String username= userService.currentUserName();
        TaiKhoanEntity tk= userDao.findByUserName(username);
        NguoiDungEntity currentUser = tk.getNguoidung();

        List<AnhEntity> anh =new ArrayList<>();
        BaiVietEntity bv =new BaiVietEntity();
        ChiTietBaiVietEntity ct= new ChiTietBaiVietEntity();
        BaiVietDao bvD =new BaiVietDao();
        bv.setTieude(data.getString("title"));
        bv.setDiachi(data.getString("street"));
        bv.setDientich(Integer.valueOf(data.getString("area")));
        Double roundPrice  = (double) Math.round( Float.valueOf(data.getString("price")) * 10) / 10;
        bv.setGia(Float.valueOf(String.valueOf(roundPrice)));
        ct.setMota(data.getString("description"));
        ct.setPhuongxa(data.getString("wards"));
        ct.setQuanhuyen(data.getString("district"));
        ct.setTinhtp(data.getString("province"));
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Timestamp timestampEnd = new Timestamp(date.getTime());
        ct.setThoigianbatdau(timestamp);
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestampEnd);
        cal.add(Calendar.DAY_OF_WEEK, 15);
        timestampEnd.setTime(cal.getTime().getTime());
        ct.setThoigianketthuc(timestampEnd);
        bv.setNguoidung(currentUser);
        int result = bvD.insertBaiViet(bv);
        if(result == 1){
            List <BaiVietEntity> postList =  bvD.getAll();
            System.out.println(postList.size());
            BaiVietEntity currentPost = postList.get(postList.size()-1);

            AnhDao anhDao =new AnhDao();
            VideoDao videoDao = new VideoDao();
            ChiTietBaiVietDao ctbv= new ChiTietBaiVietDao();

            ct.setMabaiviet(currentPost.getMabaiviet());
            ct.setBaiviet(currentPost);

            for(MultipartFile file: files){
                AnhEntity a = new AnhEntity();
                a.setLinkanh("Storage/Images/"+ writeFile(file,"Images"));
                a.setBaiviet(currentPost);
                anhDao.Insert(a);
                anh.add(a);
            }
            VideoEntity vd = new VideoEntity();
            vd.setBaiviet(currentPost);
            vd.setLinkvideo("Storage/Videos/"+ writeFile(video,"Videos"));

            videoDao.Insert(vd);
            ctbv.Insert(ct);

        }else{
            System.out.println("Error !");
        }

        return data.toString();
    }

    @RequestMapping(value = "/post-upload-no-video", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;multipart/form-data")
    @ResponseBody
    public String Test(@RequestParam("images") MultipartFile[] files,HttpServletRequest req) throws IOException {
        NguoiDungDao userDao = new NguoiDungDao();
        String username= userService.currentUserName();
        TaiKhoanEntity tk= userDao.findByUserName(username);
        NguoiDungEntity currentUser = tk.getNguoidung();
        List<AnhEntity> anh =new ArrayList<>();
        JSONObject data= new JSONObject(req.getParameter("info"));
        BaiVietEntity bv =new BaiVietEntity();
        ChiTietBaiVietEntity ct= new ChiTietBaiVietEntity();
        BaiVietDao bvD =new BaiVietDao();
        bv.setTieude(data.getString("title"));
        bv.setDiachi(data.getString("street"));
        bv.setDientich(Integer.valueOf(data.getString("area")));
        Double roundPrice  = (double) Math.round( Float.valueOf(data.getString("price")) * 10) / 10;
        bv.setGia(Float.valueOf(String.valueOf(roundPrice)));
        ct.setMota(data.getString("description"));
        ct.setPhuongxa(data.getString("wards"));
        ct.setQuanhuyen(data.getString("district"));
        ct.setTinhtp(data.getString("province"));
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Timestamp timestampEnd = new Timestamp(date.getTime());
        ct.setThoigianbatdau(timestamp);
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestampEnd);
        cal.add(Calendar.DAY_OF_WEEK, 15);
        timestampEnd.setTime(cal.getTime().getTime());
        ct.setThoigianketthuc(timestampEnd);
        bv.setNguoidung(currentUser);
        int result = bvD.insertBaiViet(bv);
        if(result == 1){
            List <BaiVietEntity> postList =  bvD.getAll();
            System.out.println(postList.size());
            BaiVietEntity currentPost = postList.get(postList.size()-1);
            AnhDao anhDao =new AnhDao();
            ChiTietBaiVietDao ctbv= new ChiTietBaiVietDao();

            ct.setMabaiviet(currentPost.getMabaiviet());
            ct.setBaiviet(currentPost);

            for(MultipartFile file: files){
                AnhEntity a = new AnhEntity();
                a.setLinkanh("Storage/Images/"+ writeFile(file,"Images"));
                a.setBaiviet(currentPost);
                anhDao.Insert(a);
                anh.add(a);
            }
            ctbv.Insert(ct);

        }else{
            System.out.println("Error !");
        }
        return data.toString();
    }

    @RequestMapping(value = "/post-user-general", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;multipart/form-data")
    @ResponseBody
    public String getUserInfo(@RequestParam("avatar") MultipartFile imageFile,HttpServletRequest req) throws IOException {
        String path = writeFile(imageFile,"Images");
        JSONObject data= new JSONObject(req.getParameter("userInfo"));
        String fullName = data.getString("fullName");
        String address = data.getString("address");
        String phoneNumber = data.getString("phoneNumber");
        String email = data.getString("email");
         return req.getParameter("userInfo").toString();
    }

    @RequestMapping(value = "/post-user-general-no-avatar", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;multipart/form-data")
    @ResponseBody
    public  String getUserInfoNoAvatar(HttpServletRequest req){
        JSONObject data= new JSONObject(req.getParameter("userInfo"));
        String fullName = data.getString("fullName");
        String address = data.getString("address");
        String phoneNumber = data.getString("phoneNumber");
        String email = data.getString("email");
        return req.getParameter("userInfo").toString();
    }

    @RequestMapping(value = "/post-user-change-password", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;multipart/form-data")
    @ResponseBody
    public String getUserInfo(HttpServletRequest req) throws IOException {
        JSONObject data= new JSONObject(req.getParameter("password"));
        String password = data.getString("password");
        String newPassword = data.getString("newPassword");
        System.out.println(password);
        System.out.println(newPassword);
        return req.getParameter("password").toString();
    }


    @RequestMapping(value = "/post-user-signup", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;multipart/form-data")
    @ResponseBody
    public String getAccountInfo(HttpServletRequest req) throws IOException {
        JSONObject data= new JSONObject(req.getParameter("account-info"));
        String fullName = data.getString("fullname");
        String password = data.getString("password");
        String email = data.getString("email");
        String phoneNumber = data.getString("phoneNumber");
        String username = data.getString("username");
        System.out.println(fullName);
        System.out.println(password);
        return req.getParameter("account-info").toString();
    }

    @GetMapping("/user-data")
    public User getUser(){
        NguoiDungDao userDao = new NguoiDungDao();
        String username= userService.currentUserName();
        TaiKhoanEntity tk= userDao.findByUserName(username);
        NguoiDungEntity currUser = tk.getNguoidung();
        User user = new User();
        user.setDiachi(currUser.getDiachi());
        user.setEmail(currUser.getEmail());
        user.setLinkanhdaidien(currUser.getLinkanhdaidien());
        user.setSdt(currUser.getSdt());
        user.setTenND(currUser.getTenND());
        return user;
    }

    @RequestMapping(value = "/post-hide-post", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;multipart/form-data")
    @ResponseBody
    public String setHide(HttpServletRequest req) throws IOException {
        JSONObject data= new JSONObject(req.getParameter("id"));
        NguoiDungDao userDao = new NguoiDungDao();
        String username= userService.currentUserName();
        TaiKhoanEntity tk= userDao.findByUserName(username);
        BaiVietEntity post =new BaiVietEntity();
        String ID = data.getString("id");
        BaiVietDao bvD =new BaiVietDao();
        post = bvD.getById(Long.parseLong(ID)).get(0);
            if(tk.getNguoidung().getMaND()== post.getNguoidung().getMaND())
                if(bvD.SetAn(post))
                    return "1";
            return "0";
    }
    public Integer test(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        int result =0;
        try {
            String hql = "select count (*) FROM BaiVietEntity where maND=:id ";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            result = query.getFirstResult();
        }
        catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            return 0;
        }
        finally {
            session.close();
            return result;
        }

    }

}

