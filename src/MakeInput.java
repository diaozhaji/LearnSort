import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MakeInput {


    public static void main(String args[]) {


        String novel = "58458-0.txt";


        String fileDir = "/Users/apple/Downloads/sort/";

        File f = new File(fileDir);
        if (!f.exists()) {
            f.mkdirs();
        }
        String fileOutput = fileDir + "input.txt";
        String dirOutput = fileDir + "temp/";

        f = new File(fileOutput);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        List<String> l = readFileByLines(fileDir + novel, fileOutput);

        Collections.sort(l);
        System.out.print("LinkedList<String> after sorting:\n");
        for (String ts : l) {
            System.out.print(ts + "\n");
            appendMethodB(ts + "\n", fileOutput);
        }

//        splitDataToSaveFile(10000, fileOutput, dirOutput);


    }

    public static List<String> readFileByLines(String fileName, String outputName) {
        List<String> l = new LinkedList<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            String[] strs;
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
//                if (!tempString.equals("")) {
//                    strs = tempString.split(" ");
//                    for (int i = 0; i < strs.length; i++) {
//                        l.add(strs[i].trim());
//                        appendMethodB(outputName, strs[i].trim() + "\n");
//
//                    }
//                }
                l.add(tempString);

                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return l;
    }


    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按行分割文件
     *
     * @param rows                为多少行一个文件
     * @param sourceFilePath      为源文件路径
     * @param targetDirectoryPath 文件分割后存放的目标目录
     */
    public static void splitDataToSaveFile(int rows, String sourceFilePath,
                                           String targetDirectoryPath) {
        long start1 = System.currentTimeMillis();

        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetDirectoryPath);
        if (!sourceFile.exists() || rows <= 0 || sourceFile.isDirectory()) {
            return;
        }
        if (targetFile.exists()) {
            if (!targetFile.isDirectory()) {
                return;
            }
        } else {
            targetFile.mkdirs();
        }
        try {

            InputStreamReader in = new InputStreamReader(new FileInputStream(sourceFilePath), "utf-8");
            BufferedReader br = new BufferedReader(in);

            BufferedWriter bw = null;
            String str = "";
            String tempData = br.readLine();
            int i = 1, s = 0;
            long start2 = System.currentTimeMillis();
            while (tempData != null) {
                str += tempData + "\r\n";
                if (i % rows == 0) {
                    bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                            targetFile.getAbsolutePath() + "/" + sourceFile.getName() + "_" + (s + 1) + ".txt"), "utf-8"), 1024);

                    bw.write(str);
                    bw.close();

                    str = "";
                    start2 = System.currentTimeMillis();
                    s += 1;
                }
                i++;
                tempData = br.readLine();
            }
            if ((i - 1) % rows != 0) {

                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                        targetFile.getAbsolutePath() + "/" + sourceFile.getName() + "_" + (s + 1) + ".txt"), "utf-8"), 1024);
                bw.write(str);
                bw.close();
                br.close();

                s += 1;
            }
            in.close();

        } catch (Exception e) {
        }

    }
}
