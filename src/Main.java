public class Main {
    public static void main(String[] args) {
        String login = "Login_2022";
        String password = "Password_8472";
        String confirmPassword = "Password_8472";
        System.out.println(logIn(login, password, confirmPassword));
    }

    public static boolean logIn(String login, String password, String confirmPassword){
        try{
            return loginCheck(login) && passwordCheck(password, confirmPassword);
        }catch (WrongLoginException | WrongPasswordException e){
            e.printStackTrace();
            return false;
        }
    }

    private static boolean loginCheck(String login) throws WrongLoginException {
        if(login.length() > 20){
            throw new WrongLoginException("Логин слишком длинный, максимальная длина 20");
        } else if(login.matches(".*\\W.*")){
            throw new WrongLoginException("Неверный формат логина");
        }
        return true;
    }

    private static boolean passwordCheck(String password, String confirmPassword) throws WrongPasswordException {
        if(password.length() >= 20){
            throw new WrongPasswordException("Пароль слишком длинный, максимальная длина 19");
        } else if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
        } else if(password.matches(".*\\W.*")){
            throw new WrongPasswordException("Неверный формат пароля");
        }
        return true;
    }
}