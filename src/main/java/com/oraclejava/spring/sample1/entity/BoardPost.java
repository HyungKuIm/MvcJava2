package com.oraclejava.spring.sample1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_board_post")
public class BoardPost implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
				generator = "seq_board_post_gen")
	@SequenceGenerator(
			name = "seq_board_post_gen",
			sequenceName = "SEQ_BOARD_POST",
			allocationSize = 1)
	private Integer id;
	
	@Column(insertable = false)
	private String status;
	
	@Column(insertable = false)
	private String type;
	
	//@Column(insertable = false)
	private Integer parent_id;
	
	private Integer num;
	private Integer reply;
	private String category;
	private String title;
	
	@Column(insertable = false)
	private String is_notice;
	
	private String author_name;
	
	@Column(insertable = false)
	private Integer hit;
	
	@Column(insertable = false, updatable = false)
	private Date created_at;
	
	@Column(insertable = false)
	private Date updated_at;
	
	private String author_pass;
	
	private String content;
	
	
	
	public BoardPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardPost(Integer id, String status, String type, Integer parent_id, Integer num, Integer reply,
			String category, String title, String is_notice, String author_name, Integer hit, Date created_at,
			Date updated_at, String author_pass, String content) {
		super();
		this.id = id;
		this.status = status;
		this.type = type;
		this.parent_id = parent_id;
		this.num = num;
		this.reply = reply;
		this.category = category;
		this.title = title;
		this.is_notice = is_notice;
		this.author_name = author_name;
		this.hit = hit;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.author_pass = author_pass;
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getReply() {
		return reply;
	}
	public void setReply(Integer reply) {
		this.reply = reply;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIs_notice() {
		return is_notice;
	}
	public void setIs_notice(String is_notice) {
		this.is_notice = is_notice;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getAuthor_pass() {
		return author_pass;
	}
	public void setAuthor_pass(String author_pass) {
		this.author_pass = author_pass;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	// 조회수 증가
	public void increaseHit() {
		if (this.hit != null) {
			this.hit++;
		} else {
			this.hit = 0;
		}
	}
	
	@Override
	public String toString() {
		return "BoardPost [id=" + id + ", status=" + status + ", type=" + type + ", parent_id=" + parent_id + ", num="
				+ num + ", reply=" + reply + ", category=" + category + ", title=" + title + ", is_notice=" + is_notice
				+ ", author_name=" + author_name + ", hit=" + hit + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", author_pass=" + author_pass + ", content=" + content + "]";
	}
	
	
}
