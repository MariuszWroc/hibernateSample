package pl.mariuszczarny.hibernateSample;

import pl.mariuszczarny.hibernateSample.dao.RoleDao;
import pl.mariuszczarny.hibernateSample.entity.Role;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       RoleDao dao = new RoleDao();
       Role role = new Role(1, "Admin", 1);
       dao.add(role );
    }
}
