package project.parsdata.com.V;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

    static List<RegisterUser> RegisterUserList;

    public static List<RegisterUser> parseData(String content) {

        JSONArray RegisterUser_arry = null;
        RegisterUser registeruser = null;
        try {

            RegisterUser_arry = new JSONArray(content);
            RegisterUserList = new ArrayList<>();

            for (int i = 0; i < RegisterUser_arry.length(); i++) {

                JSONObject obj = RegisterUser_arry.getJSONObject(i);
                registeruser = new RegisterUser();

                registeruser.setUserID(obj.getString("UserID"));
                registeruser.setAppID(obj.getString("AppID"));
                registeruser.setActiveCode(obj.getString("ActivationCode"));

                RegisterUserList.add(registeruser);
            }
            return RegisterUserList;

        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}