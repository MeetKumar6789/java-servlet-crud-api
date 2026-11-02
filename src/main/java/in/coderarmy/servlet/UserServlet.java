package in.coderarmy.servlet;

import in.coderarmy.Service.UserService;
import in.coderarmy.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (id == null || email == null || name == null || mobile == null) {
//return 400 : not the proper Request
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("{\n" + "  \"message\": \"Some fields are missing\"\n" + "}");

        }

        User user = new User(id, name, email, mobile);
        User createdUser = userService.createUser(user);

        //created so -> 201
        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("{\n" + "  \"message\": \"User Added successfully\"\n" + "}");


    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        if (id == null)//means getAll users
        {
            List<User> users = userService.getAllUsers();
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usersToJsonConverter(users));

        }

        Integer idOne = Integer.parseInt(request.getParameter("id"));
        User userResp = userService.getUserById(idOne);

        if (userResp == null) {
            response.setStatus(400);
            response.setContentType("application/json");
        }
        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(userToJsonConverter(userResp));


    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        response.setContentType("application/json");

        if (id == null) {
            response.setStatus(400);
            response.getWriter().write(
                    "{\"message\":\"User ID is required\"}"
            );
            return;
        }

        Integer userId = Integer.parseInt(id);

        boolean deleted = userService.deleteUserById(userId);

        //if user is already deleted
        if (!deleted) {
            response.setStatus(404);
            response.getWriter().write(
                    "{\"message\":\"User not found\"}"
            );
            return;
        }

        response.setStatus(200);
        response.getWriter().write(
                "{\"message\":\"User Deleted successfully\"}"
        );
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        response.setContentType("application/json");

        User updatedUser = new User(id, name, email, mobile);

        User user = userService.updateUser(updatedUser);

        if (user == null) {
            response.setStatus(404);
            response.getWriter().write("{\"message\":\"User not found\"}");
            return;
        }

        response.setStatus(200);
        response.getWriter().write("{\"message\":\"User Updated successfully\"}");
    }

    // for the get/{id} ;
    private String userToJsonConverter(User user) {
        return "{\n" + "\n" + "    \"id\" : " + user.getId() + ",\n" + "    \"name\": " + user.getName() + ",\n" + "    \"email\": " + user.getEmail() + ",\n" + "    \"mobile\":" + user.getMobile() + "\n" + "}";
    }

    //for getAll()
    private String usersToJsonConverter(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < users.size(); i++) {
            stringBuilder.append(userToJsonConverter(users.get(i)));

            //now append " , "The Battle of Konya
            if (i < users.size() - 1) {
                stringBuilder.append(",");
            }

        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

}
