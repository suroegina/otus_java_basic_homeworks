package otus.java.basic.homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceJDBCImpl implements UserServiceJDBC{
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/otus-db";
    private static final String USERS_QUERY = "select * from users";
    private static final String USERS_ROLE_QUERY = """
            select r.id, r."name" from roles r
                        	join users_to_roles ur on r.id = ur.role_id
                        	where user_id = ?
            """;

    private static final String IS_ADMIN_QUERY = """
            select count(1) from roles r
                        	join users_to_roles ur on r.id = ur.role_id
                        	join users u on u.id = ur.user_id
                        	where u.username = ? and r."name" = 'admin'
            """;
    private static final String USER_ADD_QUERY = "insert into users (username, password, email) values (?,?,?)";


    private final Connection connection;

    public UserServiceJDBCImpl() throws SQLException {
        this.connection = DriverManager.getConnection(DATABASE_URL, "admin", "password");
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            try (ResultSet resultSet = statement.executeQuery(USERS_QUERY)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String username = resultSet.getString("username");
                    User user = new User(id, password, email, username);
                    allUsers.add(user);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try (PreparedStatement prStatement = connection.prepareStatement(USERS_ROLE_QUERY)) {
            for (User user: allUsers) {
                prStatement.setInt(1, user.getId());
                List<Role> roleList = new ArrayList<>();
                try (ResultSet resultSet = prStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        Role role = new Role(id, name);
                        roleList.add(role);
                    }
                    user.setRoles(roleList);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public boolean isAdmin(String username) {
        int flag = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(IS_ADMIN_QUERY)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    flag = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag == 1;
    }

    @Override
    public void addUser(String username, String password, String email) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_ADD_QUERY)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
