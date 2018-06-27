import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("["+Thread.currentThread().getName()+"]:"+"Hi World!");
        System.out.println("测试分支合并");
        System.out.println("测试分支合并 feature-a");
        //git config --global push.default 'nothing'
        //提交feature-b
        //提交feature-b2 时间20.22

        List<File> list = new ArrayList<File>();


        list.add(new File("f504f83215fe71ba_11_audio.pcm"));
        list.add(new File("f504f83215fe71ba_1_audio.pcm"));
        list.add(new File("f504f83215fe71ba_111_audio.pcm"));
        for (File f: list){
            System.out.println(f.getName());
        }
        list.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String nameO1 = o1.getName();
                String nameO2 = o2.getName();
                long indexO1 = Long.parseLong(nameO1.substring(nameO1.indexOf("_") + 1,
                        nameO1.lastIndexOf("_")));
                long indexO2 = Long.parseLong(nameO2.substring(nameO2.indexOf("_") + 1,
                        nameO2.lastIndexOf("_")));
                long result = indexO1 - indexO2;
                if(result>0){
                    return 1;
                }else if(result<0){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        for (File f: list){
            System.out.println(f.getName());
        }
    }
}
