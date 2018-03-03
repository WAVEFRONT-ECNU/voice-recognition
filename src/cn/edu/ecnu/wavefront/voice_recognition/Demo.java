package cn.edu.ecnu.wavefront.voice_recognition;

import java.util.Scanner;

public class Demo {

    // 手动输入存放地址
    public static String getFileDirectory() {
        String fileDirectory = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("File Directory:");
        fileDirectory = scanner.nextLine();
        return fileDirectory;
    }

    public static void main(String[] args) {
        LongFormASR lfa = new LongFormASR();
        JsonOperation jo = new JsonOperation(); //实例化

        String local_file = getFileDirectory(); //输入音频存放地址
        String taskID = lfa.audioUpload(local_file); //上传音频

        // 等待识别完成
        Boolean isFinished = false;
        while (isFinished != true) {
            isFinished = lfa.requestResultLoop(taskID);
        }

        String resultJSONData = lfa.getJSONResult(taskID); //获得返回结果
        String fixedJSONData = jo.fixJSON(resultJSONData); //修复JSON格式
        System.out.println(jo.getResultFromJSON(fixedJSONData)); //从JSON读取结果
    }
}
