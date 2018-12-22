package exception;

import sun.rmi.runtime.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LogException extends Exception {
    private static Logger logger = Logger.getLogger("Log of LogException");
    public LogException(String msg) {
        super(msg);
        StringWriter log = new StringWriter();
        printStackTrace(new PrintWriter(log));
        //logger.severe(log.toString());
        //logger.info(log.toString());
        logger.warning(log.toString());
    }
    public LogException() {
        super("LogException triggered");
        StringWriter log = new StringWriter();
        printStackTrace(new PrintWriter(log));
        logger.severe(log.toString());
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }

}

public class TestException4 {
    public static void throwLogException() throws LogException {
        throw new LogException("Throw for test.");
    }
    public static void main(String[] args) {
        for(int i = 0;i < 5;i++) {
            try {
                throwLogException();
            }
            catch (LogException e) {
                //e.printStackTrace();
            }
        }
    }
}
