/**
 * 
 */
package com.zl.interview;

/**
 * @author zlennon
 *
 */
public class Childern extends People {
		public Childern(){
			System.out.println("子类无参数构造");
		}
		
		public Childern(String name){
			System.out.println("子类有参数构造器");
		}
		
		
		public static void main(String[] args) {
			new Childern();
		}
}
