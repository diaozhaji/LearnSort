import java.util.LinkedList;
import java.util.List;

public class Hello {

    public static void main(String args[]) {
        System.out.println("hello world");
//
//        if (args.length != 3) {
//            throw new RuntimeException("输入参数错误");
//        }
//
//        System.out.println("输入文件名:" + args[0]);
//        System.out.println("输出文件名:" + args[1]);
//        System.out.println("文件工作目录:" + args[2]);
//
//
//        //生成一个字符串列表，用来测试
//        List<String> l = new LinkedList<String>();
//        String[] s = new String[]{"ab", "ab", "abcd", "dfdwd", "adsfae bgbreqe ", "123"};
//
//
//        System.out.print("LinkedList<String> before sorting: ");
//        for (int j = 0; j < s.length; j++) {
//            l.add(s[j]);
//            System.out.print(s[j] + " ");
//        }
//        System.out.println();
//        QuickSort.sort(l);
//        System.out.print("LinkedList<String> after sorting:\n");
//        for (String ts : l) {
//            System.out.print(ts + "\n");
//        }
//
        int[] src = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

        src = Sort.selectSort(src);

        for (int i : src) {
            System.out.println(i);
        }

    }


}
