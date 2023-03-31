package Exceptions;

public class InvalidReportException extends Exception{
    public InvalidReportException(Exception e){
        super("Invalid location for file.",e);
    }
}
