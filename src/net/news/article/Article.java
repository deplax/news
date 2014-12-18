package net.news.article;

public class Article {
	private int aid;
	private String uid;
	private int caid;
	private String title;
	private String contents;
	private String lasttime;
	private int comment;
	
	public Article(int aid, String uid, int caid, String title, String contents, String lasttime, int comment){
		this.aid = aid;
		this.uid = uid;
		this.caid = caid;
		this.title = title;
		this.contents = contents;
		this.lasttime = lasttime;
		this.comment = comment;
	}
	
	public Article(String uid, int caid, String title, String contents){
		this.uid = uid;
		this.caid = caid;
		this.title = title;
		this.contents = contents;
	}
	
	public int getAid() {
		return aid;
	}
	public String getUid() {
		return uid;
	}
	public int getCaid() {
		return caid;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public String getLasttime() {
		return lasttime;
	}
	public int getComment() {
		return comment;
	}
}


