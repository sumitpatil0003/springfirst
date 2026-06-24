package springcollection;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//@Component
public class Emp {

//    @Autowired
//    private Tree tree;
//
//
//
//    public void showTree( JdbcTemplate jdbcTemplate){

//        tree.setName("mango tree");
//        tree.setAge(19);
//        System.out.println(tree);
//
//
//
//        // ✅ save to database
//        String sql = "INSERT INTO tree(name, age) VALUES(?, ?)";
//        int rows = jdbcTemplate.update(sql, tree.getName(), tree.getAge());
//        System.out.println("✅ Tree saved! Rows inserted: " + rows);
//    }
//    }


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("cole.xml");

//        Emp emp = (Emp) context.getBean("emp");
//        emp.showTree ();

        col col = (col) context.getBean("col");

        System.out.println(col);


        // 2. Fetch the JDBC client bean and execute a live database connectivity check
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        try {
            String mysqlVersion = jdbcTemplate.queryForObject("SELECT VERSION()", String.class);

            System.out.println("✅ MySQL Connection Test Successful! Server Version: " + mysqlVersion);

            String sql = "INSERT INTO student(name,phone,address) VALUES(?,?,?)";
            int rows = jdbcTemplate.update(sql, col.getName(),
                    col.getPhones().get(0),
                    col.getAddress().iterator().next());

            System.out.println("dat saved rows interserted" + rows);

        } catch (Exception e) {
            System.out.println("❌ Database Connection Failed! Verify credentials in cole.xml.");
            e.printStackTrace();
        }
    }
}




