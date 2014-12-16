package news;

import static org.junit.Assert.*;
import java.sql.Connection;
import net.news.db.Database;
import org.junit.Before;
import org.junit.Test;

public class DBTest {

	private Database db;
	
	@Before
	public void setup() {
		db = new Database();
	}
	@Test
	public void databaseConnection() {
		Connection con = db.getConnection();
		assertNotNull(con);
		
	}

}
