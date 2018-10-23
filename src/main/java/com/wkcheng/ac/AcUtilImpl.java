//package com.wkcheng.ac;
//
///**
// * @author created by wkcheng@iflytek.com at 2018/7/23 14:24
// * @desc https://blog.csdn.net/shadowsick/article/details/8891939
// */
//
//
//import org.apache.commons.lang.StringUtils;
//
//import java.util.List;
//
///**
// * AC多模匹配敏感字符工具类实现类
// *
// * @author shadow
// * @email 124010356@qq.com
// * @create 2012.04.28
// */
//public class AcUtilImpl implements AcUtil {
//
//    public String contrast(String filters, String word, String regex) {
//
//        if (null == filters || "".equals(filters) || null == word
//                || "".equals(word))
//            return "";
//
//        AhoCorasick ac = new AhoCorasick();
//        String[] strings = StringUtils.split(filters, regex);
//        for (String string : strings)
//            ac.add(string.getBytes(), string);
//        ac.prepare();
//        return matching(ac, word);
//    }
//
//    public String contrast(String[] filters, String word) {
//
//        if (null == filters || filters.length <= 0 || null == word
//                || "".equals(word))
//            return "";
//
//        AhoCorasick ac = new AhoCorasick();
//        for (int i = 0, len = filters.length; i < len; i++) {
//            ac.add(filters[i].getBytes(), filters[i]);
//        }
//        ac.prepare();
//        return matching(ac, word);
//    }
//
//    public String contrast(List<String> filters, String word) {
//
//        if (null == filters || filters.size() <= 0 || null == word
//                || "".equals(word))
//            return "";
//
//        AhoCorasick ac = new AhoCorasick();
//        for (int i = 0, len = filters.size(); i < len; i++) {
//            ac.add(filters.get(i).getBytes(), filters.get(i));
//        }
//        ac.prepare();
//        return matching(ac, word);
//    }
//
//    private String matching(AhoCorasick ac, String word) {
//        StringBuffer buffer = new StringBuffer();
//        Iterator<?> iterator = ac.search(word.getBytes());
//        while (iterator.hasNext()) {
//            SearchResult result = (SearchResult) iterator.next();
//            buffer.append(result.getOutputs()).append(",");
//        }
//        return buffer.length() > 0 ? buffer.substring(0, buffer.length() - 1)
//                : "";
//    }
//
//    public static void main(String[] args) {
//        String filters = "or,world,33,dd,test";
//        String word = "hello world, how are you!";
//        String regex = ",";
//        String result = new AcUtilImpl().contrast(filters, word, regex);
//        System.out.println(result);
//    }
//}
