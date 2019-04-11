package com.revature.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.models.User;
import com.revature.daos.UserDaoImpl;
import com.revature.utils.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {
	
	@Mock
    private Connection c;
    @Mock
    private Statement stmt;
    @Mock
    private ResultSet rs;
    private User u;

    
//    @Before
//    public void setUp() throws Exception {
//        assertNotNull(c);
//        //when(c.prepareStatement(any(String.class))).thenReturn(stmt);
//        when(c.createStatement()).thenReturn(stmt);
//        u = new User();
//        u.setId(1);
//        u.setUsername("Johannes");
//        u.setPassword("Smythe");
//        when(rs.first()).thenReturn(true);
//        when(rs.getInt(1)).thenReturn(1);
//        when(rs.getString(2)).thenReturn(u.getUsername());
//        when(rs.getString(3)).thenReturn(u.getPassword());
//        when(stmt.executeQuery(any(String.class))).thenReturn(rs);
//        when(stmt.executeUpdate(any(String.class))).thenReturn(1);
//    }
//
//    @Test(expected=IllegalArgumentException.class)
//    public void nullCreateThrowsException() {
//        new UserDaoImpl(c).createUser(null);
//    }
//	
//    @Test
//    public void  testUpdate() throws SQLException {
//    	new UserDaoImpl(c).updateUser(u);
//    	verify(stmt).executeUpdate("update user_table set password ='" + u.getPassword() + "' where  username = '" +  u.getUsername() +  "'");
//    	
//    }

}
