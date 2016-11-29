package com.iacthink.base;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * @author sunzihan
 * @version $Id: Main.java V 0.1 10/11/16 17:17 sunzihan EXP $
 */
public class Main {

    public static void main(String[] args) {
        String script = "String s =  @@uct_testindicator(\"$userId\");String b = $$eq(a,b)";
        while (StringUtils.lastIndexOf(script, "(") >= 0) {

            int start = StringUtils.lastIndexOf(script, "(") + 1;

            String after = StringUtils.substring(script, start);

            int end = StringUtils.indexOf(after, ")");

            String between = StringUtils.substring(after, 0, end);

            String before = StringUtils.substring(script, 0, start - 1);

            script = before;
            System.out.println(before);

        }
        //int start = StringUtils.lastIndexOf(script, "(") + 1;


        System.out.println(StringUtils.lastIndexOf(script,"@"));
        String res = StringUtils.substring(script,StringUtils.lastIndexOf(script,"@@"));
        System.out.println(res);


        String param = "\"$userId\"";

        boolean s = param.startsWith("\"$") && param.endsWith("\"");

        System.out.println(param.length());

        String strContent = StringUtils.substring(param, 1, param.length() - 1);

        System.out.println(strContent.length());

        System.out.println(StringUtils.contains(strContent, "\""));

        String ss =StringUtils.substring(strContent,1);


        String s1 = "24Hours";

        System.out.println("24HOurs".equals(s1));


        String regx = "^[1-9]+$";

        String check = "52323335";

        Pattern pattern = Pattern.compile(regx);

       Matcher matcher =  pattern.matcher(check) ;

        System.out.println(matcher.find());



        List<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.add("b");
        strings.add("s");
        strings.add("d");

        List<String> ff = retry(strings,new ArrayList<String>(),1);

        System.out.println(ff);


        c(5,0);

    }




    private final static List<String> retry(List<String> retries, List<String> toRetry, int count){
        if (retries.size() == 0){
            return new ArrayList<String>(0);
        }
        if (count == 3){
            //give up
            return retries;
        }
        for(String v : retries){
            if (count ==1){
                if (!v.equals("s")){
                    toRetry.add(v);
                }
            }

            if (count ==2){
                if (!v.equals("a")){
                    toRetry.add(v);
                }
            }

        }

        return retry(toRetry,new ArrayList<String>(),++count);
    }


    private  static void c(int a , int lev){
        if (a ==0){
            return ;
        }
        if (a > 0){
            a--;
            System.out.println(lev);
            c(a,++lev);

            System.out.println("df"+ lev);

        }
    }

}

