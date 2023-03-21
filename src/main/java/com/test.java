package com;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class test {

    public static void main(String[] args) {
//        JiebaSegmenter segmenter = new JiebaSegmenter();
//        List<String> list = new ArrayList<String>();
//        list.add("小明硕士毕业于中国科学院计算所，后在日本京都大学深造");
//        list.add("日本小明是个日本京都大学的傻逼硕士");
//        String st = "";
//        for (String str : list) {
//            String str1 = str.replace("，", "");
//            String str2 = str1.replace(" ", "");
//            st = st + str2;
//        }
//            List<String> words = segmenter.sentenceProcess(st);
//            HashMap<String, Integer> map = new HashMap<String, Integer>();
//            for (int i = 0; i < words.size(); i++) {
//                if (map.containsKey(words.get(i)) == false) {
//                    map.put(words.get(i), 1);
//                } else {
//                    map.replace(words.get(i), map.get(words.get(i)) + 1);
//                }
//            }
//            //进行排序
//            List<Map.Entry<String, Integer>> lists = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());//用map的内部接口Entry赋值
//            Collections.sort(lists, new Comparator<Map.Entry<String , Integer>>() {//通过实现Comparator接口的compare方法来完成自定义排序
//                @Override
//                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
//                    return o2.getValue().compareTo(o1.getValue());//按照value值（即计数）逆序排序
//                }
//
//            });
//            //频率最高的十个单词
//            for(int i=0;i<10;i++) {
//                System.out.println(lists.get(i).getKey() + "   " + lists.get(i).getValue());
//            }

        String i = "。";
        System.out.println(i.length());


    }
}
