import io.bace.core.BaceApp;
import io.bace.core.BaceAppPackage;

@BaceAppPackage("io.checkpost")
public class AppBace extends BaceApp {

    public static void main(String[] args) throws Exception {
        BaceApp.run(AppBace.class, args);
    }

}
