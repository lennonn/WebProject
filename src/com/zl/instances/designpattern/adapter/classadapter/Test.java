/**
 * 
 */
package com.zl.instances.designpattern.adapter.classadapter;

import org.apache.log4j.chainsaw.Main;

/**
 * @author zlennon
 *
 */
public class Test {
	public static void main(String[] args) {
		ClassApapter cApapter = new ClassApapter();
		System.out.println(cApapter.DrawCircle());
		System.out.println(cApapter.drawRcetangle());
	}
}
