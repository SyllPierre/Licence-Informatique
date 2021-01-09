package fil.coo.Actions;

import static org.junit.Assert.*;
import org.junit.Test;

public abstract class ActionTest {

	protected Action action;
	public abstract Action createAction();
	
	@org.junit.Before
	public void Before() {
		this.action = this.createAction();
	}
	
	@Test
	public void ActionNotNull() {
		assertNotNull(this.action);
	}

}
