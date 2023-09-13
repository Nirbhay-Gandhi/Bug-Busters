package bugSmasher.daointerface;

import bugSmasher.exceptions.BugAlreadyExistsException;
import bugSmasher.exceptions.BugNotFoundException;
import bugSmasher.model.Bugs;

public interface BugsIntf {
	
	void addBug(Bugs b) throws BugAlreadyExistsException;
	Bugs getBug(int bugId) throws BugNotFoundException;
	void deleteBug(int bugId) throws BugNotFoundException;
	void updateBug(int bugId) throws BugNotFoundException;
	

}
