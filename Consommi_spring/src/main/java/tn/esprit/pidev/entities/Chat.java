package tn.esprit.pidev.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Chat {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne
	UserConsomi userSender;
	
	@ManyToOne
	UserConsomi userRecipient;
	
	private String msg;
	
	private LocalDateTime msgDate = LocalDateTime.now();

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chat(int id, UserConsomi userSender, UserConsomi userRecipient, String msg, LocalDateTime msgDate) {
		super();
		this.id = id;
		this.userSender = userSender;
		this.userRecipient = userRecipient;
		this.msg = msg;
		this.msgDate = msgDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserConsomi getUserSender() {
		return userSender;
	}

	public void setUserSender(UserConsomi userSender) {
		this.userSender = userSender;
	}

	public UserConsomi getUserRecipient() {
		return userRecipient;
	}

	public void setUserRecipient(UserConsomi userRecipient) {
		this.userRecipient = userRecipient;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(LocalDateTime msgDate) {
		this.msgDate = msgDate;
	}

	

	

}
