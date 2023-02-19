package applicationcontroller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class ApplicationControllerFactory{
    public static ApplicationController getApplicationControllerFactory(){
        ApplicationController app = null;
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream("/home/properties/app.properties"));

            String name = prop.getProperty("web");

            Class<?> c = Class.forName(name);
            app = (ApplicationController)c.getDeclaredConstructor().newInstance();
        }catch(FileNotFoundException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(IOException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(InstantiationException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(IllegalAccessException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
        return app;
    }
}