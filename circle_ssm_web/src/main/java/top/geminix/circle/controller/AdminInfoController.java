package top.geminix.circle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.geminix.circle.domain.AdminInfo;
import top.geminix.circle.service.IAdminInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminInfoController {
    @Autowired
    IAdminInfoService adminInfoService;

    /**
     * 登录成功之后 需要进行权限控制吗？
     * 尝试 使用spring-security 进行登录拦截 具体参照ssm整合项目的操作
     */
    @Deprecated
    @RequestMapping("/loginDeprecated.do")
    public String queryAdminInfoByNameAndPassword(@RequestParam(required = true, name = "adminName") String adminName, @RequestParam(required = true, name = "adminPassword") String adminPassword) {
        AdminInfo adminInfo = adminInfoService.queryAdminInfoByNameAndPassword(adminName, adminPassword);
        if (adminInfo != null) {
            return "main";
        }
        return "404";
    }



    /**
     * 对之前的功能进行巩固 登录成功 把用户信息存到session中
     * @param request
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/adminLogin.do",method = RequestMethod.POST)
    public String adminLogin(HttpServletRequest request, HttpSession httpSession) {
        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");
        AdminInfo adminInfo = adminInfoService.queryAdminInfoByNameAndPassword(adminName, adminPassword);
        if (adminInfo != null) {
            String adminId = adminInfo.getAdminId();
            httpSession.setAttribute("adminId",adminId);
            return "main";
        }
        return "404";
    }

    /**
     * 退出登录做得不够好 建议使用spring-security进行拦截
     * @param request
     * @param httpSession
     * @return
     */
    @RequestMapping("adminLogout.do")
    public String adminLogout(HttpServletRequest request, HttpSession httpSession) {
        httpSession.removeAttribute("adminId");
        //返回到登录页面
//        return "main";
        return "redirect:adminLoginInterface.jsp";
    }

    /**
     * 参照代码 请删除
     * @param request
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loginIn(HttpServletRequest request, HttpSession httpSession) {
        String loginuser = request.getParameter("username");
        String pwd = request.getParameter("password");
//        JSONObject jsonObject = userFacade.loginIn(loginuser, pwd);
//        // 将用户保存到session内
//        if ("0".equals(jsonObject.getString("ecode"))) {//判断不用管
//            httpSession.setAttribute("username", loginuser);
//            httpSession.setAttribute("password", pwd);
//        }
//        return FastJsonConvert.convertObjectToJSON(jsonObject);
        return "main";
    }

}


