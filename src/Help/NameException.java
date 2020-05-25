package Help;

/**
 * Vlastná výnimka, ktorá poukazuje na zlé zadanie mena návštevníka.
 */
public class NameException extends Exception {
    public NameException (String text){
        super(text);
    }
}
