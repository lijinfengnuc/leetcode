/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: IntToRoman_12 <br/>
 * Function: <br/>
 * Date: 2019年10月15日 17:53 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class IntToRoman_12 {

    public static void main(String[] args) {
        IntToRoman_12 solution = new IntToRoman_12();
        System.out.println(solution.intToRoman(3889));
    }

    public String intToRoman(int num) {
        String result = "";
        for(int place = 1; num > 0; place = place*10) {
            result = getRomanByPlaceNum(place, num%10) + result;
            num = num/10;
        }
        return result;
    }

    private String getRomanByPlaceNum(int place, int currentPlaceNum){
        String roman = "";
        if(0 == currentPlaceNum){
            return roman;
        }
        String lowRoman;
        String middleRoman = "";
        String highRoman = "";
        switch(place) {
            case 1:
                lowRoman = "I";
                middleRoman = "V";
                highRoman = "X";
                break;
            case 10:
                lowRoman = "X";
                middleRoman = "L";
                highRoman = "C";
                break;
            case 100:
                lowRoman = "C";
                middleRoman = "D";
                highRoman = "M";
                break;
            default:
                lowRoman = "M";
        }
        int realCurrentPlaceNum = currentPlaceNum%5;
        if(currentPlaceNum < 5){
            if(realCurrentPlaceNum == 4){
                roman = lowRoman+middleRoman;
            }else{
                for(int i = 0; i < realCurrentPlaceNum; i++){
                    roman = roman + lowRoman;
                }
            }
        }else{
            if(realCurrentPlaceNum == 4){
                roman = lowRoman+highRoman;
            }else{
                roman = middleRoman;
                for(int i = 0; i < realCurrentPlaceNum; i++){
                    roman = roman + lowRoman;
                }
            }
        }
        return roman;
    }

}
