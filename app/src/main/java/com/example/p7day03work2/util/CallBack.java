package com.example.p7day03work2.util;

public interface CallBack<T> {
   void ok(T t);

   void no(String error);
}
