package com.xuan.int_related;

/**
 * Created by xzhou2 on 10/5/16.
 */
public class ValidUtf8_393 {
    public boolean validUtf8(int[] data) {
        int index = 0;
        int[] masks = new int[]{0x80, 0x40, 0x20, 0x10};
        int count = 0;
        while(index < data.length) {
            int curr = data[index++];
            count = 4;
            for(int i = 0; i < masks.length; i++) {
                if ((masks[i] & curr) == 0) {
                    count = i;
                    break;
                }
            }
            //to many digits or invalid number of leading ones
            if (count == 1 || (count == 4 && (curr & 0x08) != 0)) {
                return false;
            }

            count--;
            while(index < data.length && count--> 0) {
                curr = data[index++];
                //leading is not 10
                if ((curr & 0x80) == 0 || (curr & 0x40) != 0) {
                    return false;
                }
            }
        }
        return count <= 0;
    }
}
