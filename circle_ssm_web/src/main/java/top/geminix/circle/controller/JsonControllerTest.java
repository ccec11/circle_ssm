package top.geminix.circle.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.geminix.circle.domain.BadWordInfo;
import top.geminix.circle.domain.CircleInfo;
import top.geminix.circle.service.IBadWordInfoService;

import java.util.HashMap;
import java.util.List;

@Controller
public class JsonControllerTest {
    @Autowired
    private IBadWordInfoService badWordInfoService;

    @RequestMapping("/getJson.do")
    @ResponseBody
    public List<BadWordInfo> getJson() {
        List<BadWordInfo> allBadWord = badWordInfoService.getAllBadWord();
//        Gson gson = new Gson();
//        String json = gson.toJson(allBadWord);
        return allBadWord;
    }

    @RequestMapping("/getMap.json")
    @ResponseBody
    public HashMap<String, String> getMap() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hello", "你好");
        return hashMap;
    }


}
