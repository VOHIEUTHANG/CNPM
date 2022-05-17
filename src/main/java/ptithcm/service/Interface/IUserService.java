package ptithcm.service.Interface;

import org.springframework.security.core.Authentication;

public interface IUserService {
    public Authentication getAuthentication();
    public String currentUserName();
}
