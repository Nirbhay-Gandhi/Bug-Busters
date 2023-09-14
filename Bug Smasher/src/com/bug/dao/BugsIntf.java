package com.bug.dao;

import com.bug.exception.BugAlreadyExistsException;
import com.bug.exception.BugNotFoundException;
import com.bug.model.Bugs;

public interface BugsIntf {
	
	void addBug(Bugs b) throws BugAlreadyExistsException;
	Bugs getBug(int bugId) throws BugNotFoundException;
	void deleteBug(int bugId) throws BugNotFoundException;
	void updateBug(Bugs bug) throws BugNotFoundException;
	

}
