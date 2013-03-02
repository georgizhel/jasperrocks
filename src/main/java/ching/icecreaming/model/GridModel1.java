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

public class GridModel1 implements java.io.Serializable {
	private static final long serialVersionUID = 201210122038L;
	
	private Integer rows;
	private Integer page;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper; 
	private Integer total;
	private Integer records;
	private String id;
	private java.util.List gridModel = null; 

	public GridModel1(){}	

	public GridModel1(
		Integer rows,
		Integer page,
		String sord,
		String sidx,
		String searchField,
		String searchString,
		String searchOper,
		Integer total,
		Integer records,
		String id,
		java.util.List gridModel
	) {
		this.rows = rows;
		this.page = page;
		this.sord = sord;
		this.sidx = sidx;
		this.searchField = searchField;
		this.searchString = searchString;
		this.searchOper = searchOper;
		this.total = total;
		this.records = records;
		this.id = id;
		this.gridModel = gridModel;
	}

	public Integer getRows(){
		return this.rows;
	}
	public void setRows(Integer rows){
		this.rows = rows;
	}

	public Integer getPage(){
		return this.page;
	}
	public void setPage(Integer page){
		this.page = page;
	}

	public Integer getTotal(){
		return this.total;
	}
	public void setTotal(Integer total){
		this.total = total;
	}

	public Integer getRecords(){
		return this.records;
	}
	public void setRecords(Integer records){
		this.records = records;
	}

	public String getSord(){
		return this.sord;
	}
	public void setSord(String sord){
		this.sord = sord;
	}

	public String getSidx(){
		return this.sidx;
	}
	public void setSidx(String sidx){
		this.sidx = sidx;
	}

	public String getSearchField(){
		return this.searchField;
	}
	public void setSearchField(String searchField){
		this.searchField = searchField;
	}

	public String getSearchString(){
		return this.searchString;
	}
	public void setSearchString(String searchString){
		this.searchString = searchString;
	}

	public String getSearchOper(){
		return this.searchOper;
	}
	public void setSearchOper(String s){
		this.searchOper = searchOper;
	}

	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}

	public java.util.List getGridModel(){
		return this.gridModel;
	}
	public void setGridModel(java.util.List gridModel){
		this.gridModel = gridModel;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
