package ptithcm.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ptithcm.service.Interface.IUserService;

@Component
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
    public UserService(){
        super();
    }

}
