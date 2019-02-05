package crm.controller.UserController;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username!=null&&username!="")
        {
            return true;
        }
        else {
            response.sendRedirect(request.getContextPath()+"/user/index");
        }
        return false;
    }
}
