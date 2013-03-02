/*
 Copyright (c) 2013 ching@icecreaming.com
 All rights reserved.

 This source is subject to the GNU General Public License.
 Please see the License.txt file for more information.
 All other rights reserved.

 THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 PARTICULAR PURPOSE.
*/
package ching.icecreaming.model;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DataModel1 implements java.io.Serializable {
	private static final long serialVersionUID = 201211171944L;

	private String string1;
	private String string2;

	public DataModel1(){}	

	public DataModel1(
		String string1,
		String string2
	) {
		this.string1 = string1;
		this.string2 = string2;
	}

	public String getString1(){
		return this.string1;
	}
	public void setString1(String string1){
		this.string1 = string1;
	}

	public String getString2(){
		return this.string2;
	}
	public void setString2(String string2){
		this.string2 = string2;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
