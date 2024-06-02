
 
import java.io.BufferedReader;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.catalina.connector.Response;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
 
import rest.dao.UserDAO;
import rest.model.User;
 
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            /* report an error */ }
 
        User aux = null;
        try {
            JSONObject jsonObject = HTTP.toJSONObject(jb.toString());
            aux = getUser(jsonObject);
        } catch (JSONException e) {
            // crash and burn
            throw new IOException("Error parsing JSON request string");
        }
 
        if (aux != null) {
            User user = UserDAO.getUserByUsername(aux.getUsername());
                       
            if (user != null && user.getPassword().equals(aux.getPassword())) {
            	response.getWriter().print(String.valueOf(user.getId()));
                response.setStatus(200);
            } else {
                response.setStatus(401);
            }
        } else {
            response.setStatus(401);   
        }
    }
 
    private User getUser(JSONObject jsonObject) {
        User user = null;      
        String[] result = jsonObject.getString("Method").split("\"");
       
        if(result.length > 6 && !result[3].equals("") && !result[7].equals("")) {
            user = new User(-1, result[3], result[7], null, null, null, null, null, null);
        }
       
        return user;
    }
}