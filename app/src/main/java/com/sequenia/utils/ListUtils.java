package com.sequenia.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ListUtils {
    public static List<String> removeAllEquals(List<String> entryList) {
        return new ArrayList<>(new LinkedHashSet<>(entryList));
    }

    public static List<String> makeFirsLetterUppercase(List<String> entryList) {
        for (int i = 0; i < entryList.size(); i++) {
            entryList.set(i, entryList.get(i).substring(0, 1).toUpperCase() + entryList.get(i).substring(1));
        }
        return entryList;
    }
}
