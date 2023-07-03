package com.tw.phctw.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 对实体注释。任何Hibernate映射对象都要有这个注释
@Table(name = "user") // 声明此对象映射到数据库的数据表，通过它可以为实体指定表(talbe),目录(Catalog)和schema的名字。
public class User {
	// if @GeneratedValue(strategy = GenerationType.AUTO) is not work
	// ,you have to chaange @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id // 声明此属性为主键。该属性值可以通过应该自身创建，但是Hibernate推荐通过Hibernate生成
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 指定主键的生成策略。有如下四个值 TABLE：使用表保存id值 IDENTITY：identitycolumn
														// SEQUENCR ：sequence AUTO：根据数据库的不同使用上面三个
	@Column(name = "id") // 声明该属性与数据库字段的映射关系，意思就是說你DB欄位要跟這邊 name ="id" id值要一樣
	private int id;

	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User(int id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
