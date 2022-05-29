package ptithcm.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ptithcm.dao.BaiVietDao;
import ptithcm.dao.NguoiDungDao;
import ptithcm.entity.BaiVietEntity;
import ptithcm.entity.TaiKhoanEntity;
import ptithcm.service.UserService;
@Controller
@RequestMapping("/baiviet")
public class BaiVietController {
    boolean isFilter = false;
    String provinceGl,districtGl,priceFromGl,priceToGl,areaFromGl,areaToGl;

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
        model.addAttribute("linkvideo",b.get(0).getChitietbaiviet().getLinkVideo());

        return "Posts/DetailPage";
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

        model.addAttribute("baiviet", pagedListHolder);
        return "Posts/Home";
    }
    @RequestMapping(value = "/post-filter",method = RequestMethod.POST, produces = "text/html;charset=UTF-8;multipart/form-data")
    @ResponseBody
    public String getFilterValue(HttpServletRequest request)throws IOException {
        JSONObject data= new JSONObject(request.getParameter("filterValues"));
        if(data!=null){
            isFilter = true;
            provinceGl = data.getString("tinh");
            districtGl = data.getString("huyen");
            priceFromGl = data.getString("giaTu");
            priceToGl = data.getString("giaDen");
            areaFromGl = data.getString("dienTichTu");
            areaToGl = data.getString("dienTichDen");
        }
        return "success";
    }

    @RequestMapping("/index/filter")
    public String getFilterPage(ModelMap model,HttpServletRequest request){
        BaiVietDao bVietDao =new BaiVietDao();
        NguoiDungDao userDao = new NguoiDungDao();
        List<BaiVietEntity> list = bVietDao.getAll();
        String username= userService.currentUserName();
        TaiKhoanEntity tk= userDao.findByUserName(username);
        if(tk != null) {
            model.addAttribute("user",tk.getNguoidung());
        }
        if(isFilter){
            List<BaiVietEntity> listFilter = bVietDao.getFilterPost(provinceGl,districtGl,priceFromGl,priceToGl,areaFromGl,areaToGl);
            list = listFilter;
        }else{
            System.out.println("Not filter page!");
        }

        int page= ServletRequestUtils.getIntParameter( request,"p",0);

        PagedListHolder pagedListHolder =new PagedListHolder(list);
        pagedListHolder.setPage(page);
        pagedListHolder.setMaxLinkedPages(5);
        pagedListHolder.setPageSize(5);

        model.addAttribute("baiviet", pagedListHolder);
        return "Posts/HomeFilter";
    }
    
}
