package apiengine;

import utils.ConfigReader;

public class Endpoints {
    public static final String BASE_URL= ConfigReader.getProperty("base.url");
    public static final String REGISTER= ConfigReader.getProperty("register.endpoint");
    public static final String LOGIN= ConfigReader.getProperty("login.endpoint");
    public static final String USERS= ConfigReader.getProperty("users.endpoint");
    public static final String USERSBYPAGE= ConfigReader.getProperty("userspage.endpoint");
    public static final String USERSBYID= ConfigReader.getProperty("userid.endpoint");
    public static final String APIKEY= ConfigReader.getProperty("x-api-key");
    public static final String APIKEYBYID= ConfigReader.getProperty("x-api-key-by-id");
}
