import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.dto.LoginDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.repository.ILoginDao;
import com.min.edu.repository.LoginDaoImpl;



public class LoginTest {

	
	@Test
	public void test() {
		SqlSessionFactory manager =  SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}
	
	//@Test
	public void Login() {
		ILoginDao dao  = new LoginDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", "이상훈");
		map.put("pw", "4567");
		
		LoginDto login = dao.getLogin(map);

		
		assertNotNull(login);
		
		
	}

	
	

}
