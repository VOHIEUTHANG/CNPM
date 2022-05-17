package ptithcm.controller;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ptithcm.dao.BaiVietDao;
import ptithcm.dao.NguoiDungDao;
import ptithcm.entity.BaiVietEntity;
import ptithcm.entity.NguoiDungEntity;
import ptithcm.entity.TaiKhoanEntity;
import ptithcm.service.UserService;
@Controller
@RequestMapping("/baiviet")
public class BaiVietController {
    @Autowired
    private UserService userService;
    @RequestMapping("/chitiet/{id}")
    public String chitiet(ModelMap model,@PathVariable("id") Long id){
        BaiVietDao bVietDao =new BaiVietDao();
        NguoiDungDao userDao = new NguoiDungDao();
        String username= userService.currentUserName();
        TaiKhoanEntity tk= userDao.findByUserName(username);
        if(tk != null) {
            model.addAttribute("user",tk.getNguoidung());
        }
        List<BaiVietEntity> b = bVietDao.getById(id);
        model.addAttribute("baiviet",b.get(0));
        return "Posts/chitiet";
    }
    @RequestMapping("/index")
    public String index(ModelMap model,HttpServletRequest request){
        BaiVietDao bVietDao =new BaiVietDao();
        NguoiDungDao userDao = new NguoiDungDao();
        List<BaiVietEntity> list = bVietDao.getAll();
        String username= userService.currentUserName();
        TaiKhoanEntity tk= userDao.findByUserName(username);
        if(tk != null) {
            model.addAttribute("user",tk.getNguoidung());
        }
        int page= ServletRequestUtils.getIntParameter( request,"p",0);

        PagedListHolder pagedListHolder =new PagedListHolder(list);
        pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);

        System.out.println(pagedListHolder);

        model.addAttribute("baiviet", pagedListHolder);
        return "Posts/trangchu";
    }
    
    
}
