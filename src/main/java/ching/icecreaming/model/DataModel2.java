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
import ching.icecreaming.model.DataModel1;

public class DataModel2 implements java.io.Serializable {
	private static final long serialVersionUID = 201211091608L;

	private String id;
	private String label1;
	private String type1;
	private String value1;
	private boolean mandatory;
	private boolean readOnly;
	private boolean visible;
	private java.util.List<DataModel1> options;

	public DataModel2(){}	

	public DataModel2(
		String id,
		String label1,
		String type1,
		String value1,
		boolean mandatory,
		boolean readOnly,
		boolean visible,
		java.util.List<DataModel1> options
	) {
		this.id = id;
		this.label1 = label1;
		this.type1 = type1;
		this.value1 = value1;
		this.mandatory = mandatory;
		this.readOnly = readOnly;
		this.visible = visible;
		this.options = options;
	}

	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}

	public String getLabel1(){
		return this.label1;
	}
	public void setLabel1(String label1){
		this.label1 = label1;
	}

	public String getType1(){
		return this.type1;
	}
	public void setType1(String type1){
		this.type1 = type1;
	}

	public boolean getMandatory(){
		return this.mandatory;
	}
	public void setMandatory(boolean mandatory){
		this.mandatory = mandatory;
	}

	public boolean getReadOnly(){
		return this.readOnly;
	}
	public void setReadOnly(boolean readOnly){
		this.readOnly = readOnly;
	}

	public boolean getVisible(){
		return this.visible;
	}
	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public String getValue1(){
		return this.value1;
	}
	public void setValue1(String value1){
		this.value1 = value1;
	}

	public java.util.List<DataModel1> getOptions(){
		return this.options;
	}
	public void setOptions(java.util.List<DataModel1> options){
		this.options = options;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
