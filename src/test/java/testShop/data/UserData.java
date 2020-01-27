//package testShop.data;
//
//import org.apache.commons.codec.binary.Base64;
//import springShop.dto.AccountDTO;
//
//public class UserData {
//    public static final String USERNAME = "testUser";
//    public static final String PASSWORD = "test";
//    public static final String FIRST_NAME = "Jean-Louis";
//    public static final String LAST_NAME = "O'Brian";
//    public static final String EMAIL = "ivan.petrov@yandex.ru";
//    public static final String PHONE_NUMBER = "+7 123 456 78 90";
//    public static final String ADDRESS = "ул. Итальянская, д. 7";
//    public static final String CITY = "New York";
//    public static final String COUNTRY = "USA";
//    public static final String ZIP = "222012";
//
//    public static final String BASIC_AUTH_VALUE = "Basic "
//            + new String(Base64.encodeBase64((USERNAME + ":" + PASSWORD).getBytes()));
//
//    public static final String WRONG_BASIC_AUTH_VALUE = "Basic "
//            + new String(Base64.encodeBase64((USERNAME + "111").getBytes()));
//
//    public static AccountDTO getAccountDTO(){
//        return new AccountDTO(USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,ADDRESS,CITY,COUNTRY,ZIP);
//    }
//}
