/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hwalgorithm1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yo
 */
public class HwAlgorithm1 {

    /**
     * @param args the command line arguments
     */
    static float RanNum(){
        Random ran = new Random();
        return ran.nextFloat(); 
    }
    static ArrayList CreateNum(int N){
        ArrayList<Float> myList = new ArrayList<Float>();
        
        for(int i=0;i<N;i++){
            float rN = RanNum();
            myList.add(rN);
        }
        
        return myList;        
    }
    static ArrayList mergesort(ArrayList list){
        ArrayList<Float> newList = new ArrayList<Float>();
        for(int i=0;i<list.size();i++){
           newList.add(1.0f);
        }
        cutsort(list,newList,0,list.size());
        return newList;
    }
    static void cutsort(ArrayList list,ArrayList newList,int start,int count){
        if(count < 2) return;
        cutsort(list,newList,start,count/2);
        cutsort(list,newList,start + count/2 ,count - count/2);
        mergesort(list,newList,start,count/2,start + count / 2,count - count / 2 );
    }
    static void mergesort(ArrayList list,ArrayList newList,int leftStart, int leftCount, int rightStart, int rightCount){
         int i = leftStart, j = rightStart, leftBound = leftStart + leftCount, rightBound = rightStart + rightCount, index = leftStart; 
	 while (i < leftBound || j < rightBound) 
	 { 
	     if (i < leftBound && j < rightBound) 
	     {   
                 if(Double.parseDouble(list.get(j).toString()) < Double.parseDouble(list.get(i).toString()))
	             newList.set(index, list.get(j++)); 
	         else
                     newList.set(index, list.get(i++));
	     } 
	     else if (i < leftBound) 
                 newList.set(index, list.get(i++));
	     else
	         newList.set(index, list.get(j++));
	     ++index; 
	 } 
	 for (i = leftStart; i < index; ++i) 
             list.set(i, newList.get(i));
    }
    public static void main(String[] args) {
        
        System.out.println("Enter N to generate numbers:");
        Scanner sc = new Scanner(System.in);
        int enternum = sc.nextInt();
        ArrayList cnList = CreateNum(enternum);
       
        Float[] f = new Float[cnList.size()];
        //for (int i = 0; i < cnList.size(); i++) {
        //    f[i]= (Float) cnList.get(i);
            //f[i].floatValue(); System.out.println(f[1].floatValue());
       //     System.out.print(f[i].floatValue());
            System.out.print(cnList);
       // }
        
        System.out.println("");
        System.out.println("Sorted by merge sort:"); 
        //Float[] merge  = mergesort(cnList);
        ArrayList<Float> merge = mergesort(cnList);
        //for (int i = 0; i < merge.size(); i++) {
            //f[i].floatValue(); System.out.println(f[1].floatValue());
            //System.out.print(merge.get(i));
            //System.out.print("  ");
            System.out.print(merge);
       // }
        System.out.println("");
        System.out.println("Sorted by the Java Collections.sort method:"); 
        
        Collections.sort(cnList);
        System.out.println(cnList);
    }
    
}
