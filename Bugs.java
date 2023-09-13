package bugSmasher.model;
import java.util.*;


public class Bugs {
	private int  uid;
	private String title;
	private String description;
	//private String projectName;
	private Date createdOn;
	private int projectId;
	private Date closedOn;
	private String closedby;
	private String assignedTo;
	boolean markedForClosing;
	private bugStatus status;
	private Severity bugSevLevel;
	
	
	
	
	private String createdBy;
	private Date openDate;
	private int count;
	
	
	public enum bugStatus{
		OPEN,
		CLOSED
	}
	
	 public enum Severity{
		CRITICAL,
		MAJOR,
		MINOR,
		TRIVIAL
	}
	
	
	
	

	
	
	
	public Bugs(int uid, String title, String description, Date createdOn, int projectId, Date closedOn,
			String closedby, String assignedTo, boolean markedForClosing, bugStatus status, Severity bugSevLevel) {
		super();
		count ++;
		this.uid = count;
		this.title = title;
		this.description = description;
		this.createdOn = createdOn;
		this.projectId = projectId;
		this.closedOn = closedOn;
		this.closedby = closedby;
		this.assignedTo = assignedTo;
		this.markedForClosing = markedForClosing;
		this.status = status;
		this.bugSevLevel = bugSevLevel;
	}



	public Date getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public int getProjectId() {
		return projectId;
	}



	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}



	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public boolean isMarkedForClosing() {
		return markedForClosing;
	}

	public void setMarkedForClosing(boolean markedForClosing) {
		this.markedForClosing = markedForClosing;
	}

	public String getClosedby() {
		return closedby;
	}

	public void setClosedby(String closedby) {
		this.closedby = closedby;
	}

	public Date getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}

	public bugStatus getStatus() {
		return status;
	}

	public void setStatus(bugStatus status) {
		this.status = status;
	}

	public Severity getBugSevLevel() {
		return bugSevLevel;
	}

	public void setBugSevLevel(Severity bugSevLevel) {
		this.bugSevLevel = bugSevLevel;
	}

	public int getUid() {
		return uid;
	}

	@Override
	public String toString() {
		return "Bugs [uid=" + uid + ", title=" + title + ", description=" + description 
				+ ", createdBy=" + createdBy + ", openDate=" + openDate + ", assignedTo=" + assignedTo
				+ ", markedForClosing=" + markedForClosing + ", closedby=" + closedby + ", closedOn=" + closedOn
				+ ", status=" + status + ", bugSevLevel=" + bugSevLevel + ", count=" + count + "]";
	}
	
	
	
	
	
	

}
