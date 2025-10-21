package payloads;

public class Payload {
    public static String userRegister(String email, String password) {
        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
    }
    public static String userRegisterMissingEmail(String email, String password) {
        return "{ \"password\": \"" + password + "\" }";
    }
    public static String userRegisterMissingPassword(String email, String password) {
        return "{ \"email\": \"" + email + "\" }";
    }
    public static String userNonDefinedRegis(String email, String password) {
        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
    }
    public static String userValidLogin(String email, String password) {
        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
    }
    public static String userMissingEmailLogin(String email, String password) {
        return "{  \"password\": \"" + password + "\" }";
    }
    public static String userMissingPasswordLogin(String email, String password) {
        return "{ \"email\": \"" + email + "\" }";
    }
    public static String userWrongEmail(String email, String password) {
        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
    }
    public static String userWrongPassword(String email, String password) {
        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
    }

}
