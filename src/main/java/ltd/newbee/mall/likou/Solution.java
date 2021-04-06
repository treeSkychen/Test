package ltd.newbee.mall.likou;

/**
 * @description:
 * @author: chenshutian
 * @create: 2021/4/1 20:13
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;
        while (index < strs[0].length()) {
            char c = strs[0].charAt(index);
            for (String str : strs) {
                if (index >= strs.length || c != str.charAt(index)) {
                    return stringBuffer.toString();
                }
            }
            stringBuffer.append(strs[0].charAt(index));
            index++;
        }
        return stringBuffer.toString();
    }
}

