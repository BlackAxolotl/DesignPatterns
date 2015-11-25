package CreationalPatterns.SingletonPattern.GeneralStructure;

/**
 * Created by Ricardo Perez Silva on 29.10.2015.
 */
public class Singleton {

    /**
     * Only access point to the singleton instance.
     * Use of volatile when "instance" will be accessed by multiple threads.
     */
    private volatile static Singleton instance = null;

    /**
     * Implicit private declaration of constructor of the singleton.
     */
    private Singleton(){}

    /**
     * 1st version : Public access for constructing or calling of the singleton instance.
     * Problem: creates multiple instance if two thread access this method simultaneously
     * @return Singleton Return the singleton instance.
     */
    public static Singleton getInstance() {

        if ( instance == null )
            instance = new Singleton();

        return instance;
    }

    /**
    * 2nd version : This definitely thread-safe and only creates one instance of Singleton on concurrent environment
    * but unnecessarily expensive due to cost of synchronization at every call.
    * @return Singleton Return the singleton instance.
    */
    public static synchronized Singleton getInstanceTS() {

        if (instance == null)
            instance = new Singleton();

        return instance;
    }

    /**
     * 3rd version : An implementation of double checked locking of Singleton.
     * Minimize cost of synchronization and improve performance, by only locking critical section of code, the code
     * which creates instance of Singleton class.
     * By the way this is still broken, if we don't make "instance" volatile, as another thread can see a half
     * initialized instance of Singleton.
     * @return Singleton Return the singleton instance.
     */
    public static Singleton getInstanceDC() {

        if (instance == null)
            synchronized ( Singleton.class ) {
                if (instance == null)
                    instance = new Singleton();
            }

        return instance;
    }
}