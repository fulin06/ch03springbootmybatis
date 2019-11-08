package com.fulin.paixu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class maopao {

    @Test
    public void testmaopao(){
        int[] a = {5,2,7,1,6};
        int temp;

        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=a[i];
                }
            }
        }

        for(int i:a){
            System.out.print(i);
        }

    }
}
