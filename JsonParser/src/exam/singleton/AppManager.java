package exam.singleton;

public class AppManager {
  private static AppManager instance = null;
  private String appData;
  private AppManager() {}
  public static AppManager getInstance() {
    if(instance == null) {
      instance = new AppManager();
    }
    return instance;
  }

  public String getAppData() {
    return appData;
  }

  public void setAppData(String appData) {
    this.appData = appData;
  }
}
