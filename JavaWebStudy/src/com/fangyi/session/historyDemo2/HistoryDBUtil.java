package com.fangyi.session.historyDemo2;

import com.fangyi.bean.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FANGYI on 2016/12/6.
 */
public class HistoryDBUtil {
    private static

    Map<String, Book> books = new HashMap<>();

    static{
        books.put("1", new Book("1", "金瓶梅", 20, "王瑞鑫"));
        books.put("2", new Book("2", "葵花宝典", 20, "杨成毅"));
        books.put("3", new Book("3", "九阴真经", 30, "陈光"));
        books.put("4", new Book("4", "玉女心经", 10, "陈志家"));
    }

    /**
     * 得到所有书
     */
    public static Map<String, Book> findAllBooks(){
        return books;
    }

    /**
     * 根据id查找指定的书
     * @param id
     * @return
     */
    public static Book findBookById(String id){
        return books.get(id);
    }

}
