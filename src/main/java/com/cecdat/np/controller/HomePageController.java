package com.cecdat.np.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cecdat.np.entity.StHospitcalKeyIndicatorM;
import com.cecdat.np.service.FactHospitalKpiDService;
import com.cecdat.np.service.StHospitcalInfoService;
import com.cecdat.np.service.StHospitcalKeyIndicatorMService;
import com.cecdat.np.service.TotalCostService;
import com.cecdat.np.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by roy on 2018/6/25.
 */
@Controller
@Slf4j
public class HomePageController {

    @Autowired
    private StHospitcalInfoService stHospitcalInfoService;

    @Autowired
    private StHospitcalKeyIndicatorMService stHospitcalKeyIndicatorMService;

    @Autowired
    private FactHospitalKpiDService hospitalKpiDService;
    @Autowired
    private TotalCostService costService;

    @GetMapping("/api/areaReceivedPayments/echart.json")
    @ResponseBody
    public JSONObject getAreaReceivedPaymentData() {
        JSONObject jsonObject = hospitalKpiDService.HospitalCodeForCharts();
        jsonObject.put("RGBColor", Util.getRandomColor());
        return jsonObject;
    }

    @GetMapping("/api/medicalRate/echart.json")
    @ResponseBody
    public JSONObject getInHospitalRateData() {
        JSONObject jsonObject = costService.getHosFeeRate("in");
        jsonObject.put("RGBColor", Util.getRandomColor());
        return jsonObject;
    }

    @GetMapping("/api/areaReceived/echart.json")
    @ResponseBody
    public JSONObject getOutHospitalRateData() {
        JSONObject jsonObject = costService.getHosFeeRate("out");
        jsonObject.put("RGBColor", Util.getRandomColor());
        return jsonObject;
    }

    @GetMapping("api/hospitalsProportion")
    @ResponseBody
    public JSONObject getHospitalsProportion(){
        JSONObject jsonObject = new JSONObject();
        int total = stHospitcalInfoService.getTotalHospitalData();
        int topThree = stHospitcalInfoService.getTopThreeHospitalData();
        jsonObject.put("total", total);
        jsonObject.put("percent", topThree / total * 100);
        jsonObject.put("name", "三甲医院数据");
        JSONArray color = new JSONArray();
        color.add("#40E0D0");
        color.add("#F0FFFF");
        jsonObject.put("color",color);
        return jsonObject;
    }

    @GetMapping("api/datasProportion")
    @ResponseBody
    public JSONObject getDatasProportion(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", 296445716);
        jsonObject.put("percent", 100);
        JSONArray color = new JSONArray();
        color.add("#38a8da");
        color.add("#d4effa");
        jsonObject.put("color",color);
        jsonObject.put("name", "福州市数据占比");
        return jsonObject;
    }


    @GetMapping("api/chargeDistribution")
    @ResponseBody
    public JSONObject getChargeDistribution(){
        JSONObject jsonObject = new JSONObject();
        List<Map<String, Object>> systemData = stHospitcalKeyIndicatorMService.getSystemData();
        Map<String, Object> data = new HashMap<String, Object>();
        for(Map<String, Object> ele : systemData){
            data.put(((String)ele.get("name")).toUpperCase(), ele.get("total"));
        }
        String[] arr = {"HIS","LIS","PACS","EMR"};
        JSONArray legendData = new JSONArray();
        JSONArray seriesData = new JSONArray();
        for(String ele : arr){
            legendData.add(ele);
            JSONObject jo = new JSONObject();
            if(data.containsKey(ele)){
                jo.put("value", data.get(ele));
                jo.put("name", ele);
            }else {
                jo.put("value", 0);
                jo.put("name", ele);
            }
            seriesData.add(jo);
        }
        jsonObject.put("legendData",legendData);
        jsonObject.put("seriesData",seriesData);
        jsonObject.put("title","医院数据占比图");
        return jsonObject;
    }


    @GetMapping("api/yearNum")
    @ResponseBody
    public JSONObject getYearNum(){
        JSONObject jsonObject = new JSONObject();
        List<Map<String, Object>> collectionData = stHospitcalKeyIndicatorMService.getCollectionData();
        List<Object> data = new ArrayList<Object>();
        for(Map<String, Object> map : collectionData){
            data.add(map.get("total"));
        }
        JSONArray xData = new JSONArray();
        for(int i = 1; i < 13; i++){
            xData.add(i + "月");
        }
        String[] names = {"数据采集量"};
        JSONArray legendData = new JSONArray();
        JSONArray sData = new JSONArray();
        for(String name : names){
            legendData.add(name);
            JSONObject jo = new JSONObject();
            jo.put("name",name);
            jo.put("type","line");
            jo.put("smooth",true);
            JSONArray joArray = new JSONArray();
            for(int j = 0; j < xData.size(); j++){
                if(j < data.size()){
                    joArray.add(data.get(j));
                }else {
                    joArray.add(0);
                }
                //joArray.add(new Random().nextInt(30));
            }
            jo.put("data",joArray);
            sData.add(jo);
        }
        JSONArray color = new JSONArray();
        color.add("#87CEFA");
        jsonObject.put("color",color);

        jsonObject.put("xData",xData);
        jsonObject.put("sData",sData);
        jsonObject.put("legendData",legendData);
        jsonObject.put("title","数据采集量");

        return jsonObject;

    }



    @GetMapping("api/quarterSum")
    @ResponseBody
    public JSONObject getQuarterSum(){
        JSONObject jsonObject = new JSONObject();
        List<Map<String, Object>> controlData = stHospitcalKeyIndicatorMService.getControlData();
        List<Object> data = new ArrayList<Object>();
        for(Map<String, Object> map : controlData){
            data.add(map.get("total"));
        }
        JSONArray xData = new JSONArray();
        for(int i = 1; i < 13; i++){
            xData.add(i + "月");
        }
        String[] names = {"数据开放量"};
        JSONArray legendData = new JSONArray();
        JSONArray sData = new JSONArray();
        for(String name : names){
            legendData.add(name);
            JSONObject jo = new JSONObject();
            jo.put("name",name);
            jo.put("type","line");
            jo.put("smooth",true);
            JSONArray joArray = new JSONArray();
            for(int j = 0; j < xData.size(); j++){
                if(j < data.size()){
                    joArray.add(data.get(j));
                }else {
                    joArray.add(0);
                }
            }
            jo.put("data",joArray);
            sData.add(jo);
        }

        JSONArray color = new JSONArray();
        color.add("#C71585");

        jsonObject.put("xData",xData);
        jsonObject.put("sData",sData);
        jsonObject.put("legendData",legendData);
        jsonObject.put("title","数据开放量");
        jsonObject.put("color",color);


        return jsonObject;

    }


    @GetMapping("/api/homemap/echart.json")
    @ResponseBody
    public JSONObject getHomeMapData() {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = getHomeMapDataFun();
        jsonObject.put("data", data);
        return jsonObject;
    }

    private JSONArray getHomeMapDataFun() {
        JSONArray jsonArray = null;
        /*String str = "[{\"id\":4,\"area_code\":\"350102\",\"area_name\":\"鼓楼区\",\"hospital_name\":\"福州市中医院\",\"latitude\":26.096274,\"longitude\":119.308964,\"num\":147316},\n" +
                "{\"id\":8,\"area_code\":\"350103\",\"area_name\":\"台江区\",\"hospital_name\":\"福州市第一医院\",\"latitude\":26.065826,\"longitude\":119.319233,\"num\":1033},\n" +
                "{\"id\":9,\"area_code\":\"350103\",\"area_name\":\"仓山区\",\"hospital_name\":\"福州市第二医院\",\"latitude\":26.052373,\"longitude\":119.32719,\"num\":298380},\n" +
                "{\"id\":13,\"area_code\":\"350111\",\"area_name\":\"晋安区\",\"hospital_name\":\"福州市第八医院\",\"latitude\":26.113855,\"longitude\":119.3288,\"num\":433496},\n" +
                "{\"id\":14,\"area_code\":\"350111\",\"area_name\":\"台江区\",\"hospital_name\":\"福州市第六医院\",\"latitude\":26.071341,\"longitude\":119.320908,\"num\":122136}]";
        */

        String str = "[{\"id\":3,\"area_code\":\"350102\",\"area_name\":\"鼓楼区\",\"hospital_name\":\"福州市传染病医院(孟超肝胆)\",\"latitude\":26.091194,\"longitude\":119.287613,\"num\":226910},\n" +
                "{\"id\":4,\"area_code\":\"350102\",\"area_name\":\"鼓楼区\",\"hospital_name\":\"福州市中医院\",\"latitude\":26.096274,\"longitude\":119.308964,\"num\":61136},\n" +
                "{\"id\":5,\"area_code\":\"350102\",\"area_name\":\"鼓楼区\",\"hospital_name\":\"福建省福州儿童医院\",\"latitude\":26.078809,\"longitude\":119.310852,\"num\":82704},\n" +
                "{\"id\":6,\"area_code\":\"350102\",\"area_name\":\"鼓楼区\",\"hospital_name\":\"福州市第七医院\",\"latitude\":26.085073,\"longitude\":119.307143,\"num\":184598},\n" +
                "{\"id\":7,\"area_code\":\"350102\",\"area_name\":\"鼓楼区\",\"hospital_name\":\"福州市皮肤病防治院\",\"latitude\":26.091187,\"longitude\":119.2905,\"num\":457173},\n" +
                "{\"id\":8,\"area_code\":\"350103\",\"area_name\":\"台江区\",\"hospital_name\":\"福州市第一医院\",\"latitude\":26.065826,\"longitude\":119.319233,\"num\":271054},\n" +
                "{\"id\":9,\"area_code\":\"350103\",\"area_name\":\"仓山区\",\"hospital_name\":\"福州市第二医院\",\"latitude\":26.052373,\"longitude\":119.32719,\"num\":472740},\n" +
                "{\"id\":10,\"area_code\":\"350104\",\"area_name\":\"仓山区\",\"hospital_name\":\"福建省福州结核病防治院\",\"latitude\":26.031624,\"longitude\":119.303627,\"num\":195164},\n" +
                "{\"id\":11,\"area_code\":\"350104\",\"area_name\":\"仓山区\",\"hospital_name\":\"福建省福州神经精神病防治院(四院)\",\"latitude\":26.031767,\"longitude\":119.297431,\"num\":239677},\n" +
                "{\"id\":12,\"area_code\":\"350105\",\"area_name\":\"马尾区\",\"hospital_name\":\"马尾区医院(福州经济技术开发区医院)\",\"latitude\":26.000284,\"longitude\":119.463891,\"num\":454534},\n" +
                "{\"id\":13,\"area_code\":\"350111\",\"area_name\":\"晋安区\",\"hospital_name\":\"福州市第八医院\",\"latitude\":26.113855,\"longitude\":119.3288,\"num\":105558},\n" +
                "{\"id\":14,\"area_code\":\"350111\",\"area_name\":\"台江区\",\"hospital_name\":\"福州市第六医院\",\"latitude\":26.071341,\"longitude\":119.320908,\"num\":258630},\n" +
                "{\"id\":15,\"area_code\":\"350111\",\"area_name\":\"鼓楼区\",\"hospital_name\":\"福州市妇幼保健院\",\"latitude\":26.079119,\"longitude\":119.326752,\"num\":433518},\n" +
                "{\"id\":16,\"area_code\":\"350111\",\"area_name\":\"晋安区\",\"hospital_name\":\"福州市晋安区医院\",\"latitude\":26.074336,\"longitude\":119.342631,\"num\":140500},\n" +
                "{\"id\":17,\"area_code\":\"350121\",\"area_name\":\"闽侯县\",\"hospital_name\":\"闽侯县人民医院\",\"latitude\":25.903253,\"longitude\":119.383132,\"num\":367110},\n" +
                "{\"id\":18,\"area_code\":\"350121\",\"area_name\":\"闽侯县\",\"hospital_name\":\"闽侯县医院\",\"latitude\":26.152866,\"longitude\":119.167055,\"num\":372899},\n" +
                "{\"id\":19,\"area_code\":\"350122\",\"area_name\":\"连江县\",\"hospital_name\":\"连江县医院\",\"latitude\":26.200608,\"longitude\":119.542557,\"num\":131914},\n" +
                "{\"id\":20,\"area_code\":\"350122\",\"area_name\":\"连江县\",\"hospital_name\":\"连江县中医院\",\"latitude\":26.209086,\"longitude\":119.542153,\"num\":176476},\n" +
                "{\"id\":21,\"area_code\":\"350123\",\"area_name\":\"罗源县\",\"hospital_name\":\"福建省罗源县医院\",\"latitude\":26.492159,\"longitude\":119.555158,\"num\":131062},\n" +
                "{\"id\":22,\"area_code\":\"350123\",\"area_name\":\"罗源县\",\"hospital_name\":\"罗源县中医院\",\"latitude\":26.491956,\"longitude\":119.552859,\"num\":47467},\n" +
                "{\"id\":23,\"area_code\":\"350123\",\"area_name\":\"罗源县\",\"hospital_name\":\"罗源县妇幼保健院\",\"latitude\":26.492256,\"longitude\":119.551063,\"num\":345529},\n" +
                "{\"id\":24,\"area_code\":\"350124\",\"area_name\":\"闽清县\",\"hospital_name\":\"福建省闽清精神病防治院\",\"latitude\":26.223786,\"longitude\":118.877617,\"num\":367748},\n" +
                "{\"id\":25,\"area_code\":\"350124\",\"area_name\":\"闽清县\",\"hospital_name\":\"闽清县中医院\",\"latitude\":26.231188,\"longitude\":118.870002,\"num\":331573},\n" +
                "{\"id\":26,\"area_code\":\"350124\",\"area_name\":\"闽清县\",\"hospital_name\":\"闽清县六都医院\",\"latitude\":26.114428,\"longitude\":118.778613,\"num\":74319},\n" +
                "{\"id\":27,\"area_code\":\"350124\",\"area_name\":\"闽清县\",\"hospital_name\":\"闽清县医院\",\"latitude\":26.224499,\"longitude\":118.877428,\"num\":453897},\n" +
                "{\"id\":28,\"area_code\":\"350125\",\"area_name\":\"永泰县\",\"hospital_name\":\"福建省永泰县医院\",\"latitude\":25.872741,\"longitude\":118.935048,\"num\":446394},\n" +
                "{\"id\":29,\"area_code\":\"350125\",\"area_name\":\"永泰县\",\"hospital_name\":\"永泰县中医院\",\"latitude\":25.868211,\"longitude\":118.939793,\"num\":49964},\n" +
                "{\"id\":30,\"area_code\":\"350181\",\"area_name\":\"福清市\",\"hospital_name\":\"福清市医院\",\"latitude\":25.735229,\"longitude\":119.352193,\"num\":322587},\n" +
                "{\"id\":31,\"area_code\":\"350181\",\"area_name\":\"福清市\",\"hospital_name\":\"福清市第二医院\",\"latitude\":25.617233,\"longitude\":119.466894,\"num\":446512},\n" +
                "{\"id\":32,\"area_code\":\"350181\",\"area_name\":\"福清市\",\"hospital_name\":\"福清市妇幼保健院\",\"latitude\":25.713828,\"longitude\":119.356184,\"num\":470535},\n" +
                "{\"id\":33,\"area_code\":\"350181\",\"area_name\":\"福清市\",\"hospital_name\":\"福清市皮肤病防治院\",\"latitude\":25.730041,\"longitude\":119.373832,\"num\":375600},\n" +
                "{\"id\":34,\"area_code\":\"350181\",\"area_name\":\"福清市\",\"hospital_name\":\"福清市中医院\",\"latitude\":25.731382,\"longitude\":119.390437,\"num\":476902},\n" +
                "{\"id\":35,\"area_code\":\"350181\",\"area_name\":\"福清市\",\"hospital_name\":\"福清市第三医院\",\"latitude\":25.705716,\"longitude\":119.319619,\"num\":494282},\n" +
                "{\"id\":36,\"area_code\":\"350182\",\"area_name\":\"长乐市\",\"hospital_name\":\"长乐市中医院\",\"latitude\":25.963391,\"longitude\":119.531304,\"num\":27517},\n" +
                "{\"id\":37,\"area_code\":\"350182\",\"area_name\":\"长乐市\",\"hospital_name\":\"长乐市妇幼保健院\",\"latitude\":25.966593,\"longitude\":119.520213,\"num\":73730},\n" +
                "{\"id\":38,\"area_code\":\"350182\",\"area_name\":\"长乐市\",\"hospital_name\":\"长乐市第二医院\",\"latitude\":25.985179,\"longitude\":119.624739,\"num\":233336},\n" +
                "{\"id\":39,\"area_code\":\"350182\",\"area_name\":\"长乐市\",\"hospital_name\":\"长乐市医院\",\"latitude\":25.965318,\"longitude\":119.526777,\"num\":394856}]";
        jsonArray = JSONArray.parseArray(str);
        return jsonArray;
    }

}
