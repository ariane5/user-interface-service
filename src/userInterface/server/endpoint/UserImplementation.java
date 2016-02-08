package userInterface.server.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.glassfish.jersey.client.ClientConfig;
import userInterface.server.model.HealthMeasureHistory;
import userInterface.server.model.User;
import userInterface.server.model.UserProcess;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * Created by bishruti on 2/3/16.
 */
public class UserImplementation {
    UserImplementation user = new UserImplementation();
    private static ClientConfig clientConfig = new ClientConfig();
    private static Client client = ClientBuilder.newClient(clientConfig);
    private static WebTarget serviceBusiness = client.target(getBaseBusinessURI());
    private static Response responseBusiness;
    private static WebTarget serviceProcess = client.target(getBaseProcessURI());
    private static Response responseProcess;
    private static String uId;
    private static ObjectMapper userMapper = new ObjectMapper();

    private static URI getBaseBusinessURI() {
        return UriBuilder.fromUri("http://127.0.1.1:8003/business/user").build();
    }

    private static URI getBaseProcessURI() {
        return UriBuilder.fromUri("http://127.0.1.1:8002/process/user").build();
    }

    /*  Request to obtain all the users and their details in the list.
        Expected Input: -
        Expected Output: List of users (List) */

    public static List<User> getListOfUser() throws IOException {
        responseBusiness = serviceBusiness.request().accept(MediaType.APPLICATION_JSON).get();
        String users = responseBusiness.readEntity(String.class);
        List<User> user = userMapper.readValue(users,
                TypeFactory.defaultInstance().constructCollectionType(List.class,
                        User.class));
        return user;
    }

    /* Request to obtain a user and the details associated to that user from the list.
       Expected Input: uId (Integer)
       Expected Output: User and the details associated to that user. (Object) */

    public static User getUserDetail(int uId) throws IOException {
        responseBusiness = serviceBusiness.path(String.valueOf(uId)).request().accept(MediaType.APPLICATION_JSON).get();
        User user = responseBusiness.readEntity(User.class);
        return user;
    }

    /* Request to obtain all measure details about a measure of a user in the list.
        Expected Input: uId (Integer)
                       measureType (String)
       Expected Output: List of details of measure types. (List) */

    public static List<HealthMeasureHistory> getUserHistory(int uId, String measureType) throws Exception {
        responseBusiness = serviceBusiness.path(String.valueOf(uId) + "/"  + measureType).request().accept(MediaType.APPLICATION_JSON).get();
        String healthMeasureHistories = responseBusiness.readEntity(String.class);
        List<HealthMeasureHistory> healthMeasureHistory = userMapper.readValue(healthMeasureHistories,
                TypeFactory.defaultInstance().constructCollectionType(List.class,
                        HealthMeasureHistory.class));
        return healthMeasureHistory;
    }

     /*  Request to obtain measure details about a particular measure of a user in the list.
        Expected Input: uId (Integer)
                        measureType (String)
                        hmhId (Integer)
        Expected Output: Details of a particular measure. (List) */

    public static List<HealthMeasureHistory> getUserMeasure(int uId, String measureType, int hmhId) throws Exception {
        responseBusiness = serviceBusiness.path(String.valueOf(uId) + "/"  + measureType + "/" + String.valueOf(hmhId)).request().accept(MediaType.APPLICATION_JSON).get();
        String healthMeasureHistories = responseBusiness.readEntity(String.class);
        List<HealthMeasureHistory> healthMeasureHistory = userMapper.readValue(healthMeasureHistories,
                TypeFactory.defaultInstance().constructCollectionType(List.class,
                        HealthMeasureHistory.class));
        return healthMeasureHistory;
    }

    /*  Request to add a new user in the list.
        Expected Input: User (Object)
        Expected Output: Newly created User with the details associated to that user. (Object) */

    public static UserProcess createUser(UserProcess userDetail) throws Exception {
        responseProcess = serviceProcess.request().accept(MediaType.APPLICATION_JSON).post(Entity.json(userDetail));
        UserProcess user = responseProcess.readEntity(UserProcess.class);
        return user;
    }

    /*  Request to edit a user in the list.
        Expected Input: uId (Integer) and User (Object)
        Expected Output: Edited User with the details associated to that user. (Object) */

    public static UserProcess updateUser(int userId, UserProcess userDetail) throws Exception {
        responseProcess = serviceProcess.path(String.valueOf(userId)).request().accept(MediaType.APPLICATION_JSON).put(Entity.json(userDetail));
        UserProcess user = responseProcess.readEntity(UserProcess.class);
        return user;
    }

    /*  Request to delete a user from the list.
        Expected Input: uId (Integer)
        Expected Output: Response Message. */

    public static void deleteUser(int userId) throws Exception {
        responseProcess = serviceProcess.path(String.valueOf(userId)).request().accept(MediaType.APPLICATION_JSON).delete();
    }

     /* Request to create measure details about a measure of a user in the list.
       Expected Input: uId (Integer)
       measureType (String)
       MeasureDetails (Object)
       Expected Output:
       List of newly created measure. (Object) */

    public static List<HealthMeasureHistory> createUserMeasure(int uId, String measuretype, HealthMeasureHistory healthMeasureHistoryDetails) throws Exception {
        responseProcess = serviceProcess.path(uId + "/" + measuretype).request().accept(MediaType.APPLICATION_JSON).post(Entity.json(healthMeasureHistoryDetails));
        String healthMeasureHistories = responseProcess.readEntity(String.class);
        List<HealthMeasureHistory> newHealthMeasureHistoryList = userMapper.readValue(healthMeasureHistories,
                TypeFactory.defaultInstance().constructCollectionType(List.class,
                        HealthMeasureHistory.class));
        return newHealthMeasureHistoryList;
    }

    /*  Request to update measure details about a measure of a user in the list.
        Expected Input: uId (Integer)
        measureType (String)
        hmhId (Integer)
        MeasureDetails (Object)
        Expected Output:
        List of updated measure. (String) */

    public static List<HealthMeasureHistory> updateUserMeasure(int uId, String measuretype, HealthMeasureHistory healthMeasureHistoryDetails, int hmhId) throws Exception {
        responseProcess = serviceProcess.path(uId + "/" + measuretype + "/" + hmhId).request().accept(MediaType.APPLICATION_JSON).put(Entity.json(healthMeasureHistoryDetails));
        String healthMeasureHistories = responseProcess.readEntity(String.class);
        List<HealthMeasureHistory> newHealthMeasureHistoryList = userMapper.readValue(healthMeasureHistories,
                TypeFactory.defaultInstance().constructCollectionType(List.class,
                        HealthMeasureHistory.class));
        return newHealthMeasureHistoryList;
    }
}
