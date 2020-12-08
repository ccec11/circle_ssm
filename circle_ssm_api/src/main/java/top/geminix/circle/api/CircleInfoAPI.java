package top.geminix.circle.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.geminix.circle.service.ICircleInfoService;
import top.geminix.circle.service.IUserInfoService;

/**
 * 返回的全部是JSON，用于安卓端 获取JSON数据
 */
@RestController
@RequestMapping("/circle")
public class CircleInfoAPI {
    @Autowired
    private ICircleInfoService circleInfoService;
    @Autowired
    private IUserInfoService userInfoService;


}
