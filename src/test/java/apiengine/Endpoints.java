package apiengine;

import utils.ConfigReader;

public class Endpoints {
    public static final String BASE_URL= ConfigReader.getProperty("base.url");
    public static final String REGISTER= ConfigReader.getProperty("register.endpoint");
    public static final String LOGIN= ConfigReader.getProperty("login.endpoint");
    public static final String USERS= ConfigReader.getProperty("users.endpoint");
}
