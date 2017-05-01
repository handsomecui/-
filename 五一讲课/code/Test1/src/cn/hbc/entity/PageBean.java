package cn.hbc.entity;

import java.util.List;

public class PageBean {
	private int pageCount = 4;
	private int totalCount;
	private int totalPage;
	private int curPage;
	private List<Student>list;
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		if(totalCount % pageCount == 0){
			return totalCount / pageCount;
		}else{
			return totalCount / pageCount + 1;
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	
	
}
