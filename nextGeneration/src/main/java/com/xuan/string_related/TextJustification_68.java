package com.xuan.string_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class TextJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int wordCount = 0, charCount = 0,  start = 0, padding;
        StringBuilder sb = new StringBuilder(maxWidth);
        char[] c = new char[maxWidth];
        Arrays.fill(c, ' ');
        if (words.length == 0) {
            result.add(new String(c));
            return result;
        }
        for(int i = 0; i < words.length; i++) {
            if (charCount + wordCount + words[i].length() > maxWidth) {
                padding = maxWidth - charCount;
                if (wordCount == 1) {
                    sb.append(words[start]);
                    if (padding > 0) {
                        sb.append(c, 0, padding);
                    }
                }
                else {
                    int extra = padding % (wordCount - 1);
                    int each = padding / (wordCount - 1);
                    sb.append(words[start]);
                    for(int j = 1; j < wordCount; j++) {
                        sb.append(c, 0, each);
                        if (j <= extra) {
                            sb.append(' ');
                        }
                        sb.append(words[start + j]);
                    }
                }
                result.add(sb.toString());
                sb = new StringBuilder(maxWidth);
                start = i;
                wordCount = 1;
                charCount = words[i].length();
            }
            else {
                wordCount++;
                charCount += words[i].length();
            }
        }
        sb = new StringBuilder(maxWidth);
        padding = maxWidth - charCount;
        for(int i = 0; i < wordCount - 1; i++) {
            sb.append(words[start + i]);
            sb.append(' ');
            padding--;
        }
        sb.append(words[start + wordCount - 1]);
        if (padding > 0) {
            sb.append(c, 0, padding);
        }
        result.add(sb.toString());
        return result;
    }
}
