package cn.edu.ecnu.wavefront.voice_recognition;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonOperation {
    // JSON操作

    // JSON格式修复（去除首尾方括号）
    public String fixJSON(String resultJSONData) {
        String fixedJSONData = resultJSONData;
        if (fixedJSONData.startsWith("[")) {
            fixedJSONData = fixedJSONData.substring(1);
        }
        if (fixedJSONData.endsWith("]")) {
            fixedJSONData = fixedJSONData.substring(0, fixedJSONData.length() - 1);
        }
        return fixedJSONData;
    }

    // 从JSON中提取结果
    public String getResultFromJSON(String fixedJSONData) {
        JSONObject resultJSON = null;
        String resultStr = "";
        try {
            resultJSON = new JSONObject(fixedJSONData);
            System.out.println(resultJSON);
            resultStr = resultJSON.getString("onebest");
            System.out.println(resultStr);
        } catch (JSONException e) {
            // 获取异常结果
            System.out.println(e.getMessage());
        }

        return resultStr;
    }

}
