package kodlamaio.hrms.core.utilities.business;

public class ValidationTool {
    public static boolean run(boolean... logics){
        for(boolean logic : logics){
            if(!logic){
                return false;
            }
        }
        return true;
    }
}
