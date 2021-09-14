package com.sym.test;

import com.sym.singleton.AppConstants;
import com.sym.singleton.PropertiesHelper;

public class PropertiesHelperTester {

	public static void main(String[] args) {
		PropertiesHelper props = PropertiesHelper.getInstance();
		System.out.println(props.getString(AppConstants.driver));
	}

}
