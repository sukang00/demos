package org.example.utils;

import cn.hutool.extra.pinyin.PinyinUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/6 9:06
 */
public class PinyinUtils {

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        String pinyin = PinyinUtil.getPinyin("你好哈，李白！", "");
        System.out.println(pinyin);
    }
}
