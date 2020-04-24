/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenerateParenthesis_22 <br/>
 * Function: <br/>
 * Date: 2019年10月25日 19:02 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class GenerateParenthesis_22 {

    public static void main(String[] args) {
        GenerateParenthesis_22 solution = new GenerateParenthesis_22();
        System.out.println(solution.generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        if(n < 1) {
            return null;
        }
        List<String> result = new ArrayList<>();
        String origin = "(";
        int left = n-1;
        int right = n-1;
        for(int i = 0; i < 2*(n-1); i++){
            origin = origin + "(";
            left--;
            origin = origin + ")";
            right--;
        }
        return null;
    }

    /*地点：北京 太原  大学：华北工业大学
    * n1:伪文艺男青年，优柔寡断，希望开始却又害怕结束，职业是
    * n2:技术宅男，推崇技术至上，认为大城市才是自己奋斗的地方，容易忽略别人感受，女朋友是太原人（毕业于山西师范大学）
    * n3:健身达人，热爱户外运动，女朋友是北京土著（毕业于华北工业大学）*/

    private void generateValid(List<String> list, String origin) {

    }

}
