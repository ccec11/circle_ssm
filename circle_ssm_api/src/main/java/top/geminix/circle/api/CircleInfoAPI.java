package top.geminix.circle.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.domain.LabelInfo;
import top.geminix.circle.service.ICircleInfoService;
import top.geminix.circle.service.IUserInfoService;

import java.util.List;

/**
 * 返回的全部是JSON，用于安卓端 获取JSON数据
 */
@RestController
@RequestMapping("/api/circle")
public class CircleInfoAPI {
    @Autowired
    private ICircleInfoService circleInfoService;
    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping("getCategory.do")
    @ResponseBody
    public List<LabelInfo> getAllLabelCategory() {
        List<LabelInfo> allLabelCategory = circleInfoService.getAllLabelCategory();

        return allLabelCategory;
    }
    @RequestMapping("getByCategory.do")
    @ResponseBody
    public List<CircleInfo> getCircleInfoByCategory(@RequestParam(required = true,name = "sortId") Integer sortId) {

        List<CircleInfo> circleInfoList = circleInfoService.getCircleInfoByCategory(sortId);
        return circleInfoList;
    }

}
