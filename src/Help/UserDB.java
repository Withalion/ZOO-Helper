package Help;

import java.util.ArrayList;
import Models.*;

public class UserDB {
    public static ArrayList<User> users = new ArrayList<User>();

    public void loadDB(){   //deserialize

    }

    public void fillDB(){   //naplnenie databazy prototypmi ak neexistuje zaloha
        users.add(new Dieta(10001, "Janko"));
        users.add(new Dospeli(10002, "Marian"));
        users.add(new Senior(10003, "Imrich"));
        users.add(new Pokladnik(50001, "Marienka"));
        users.add(new Manazer(90001, "Alfonz"));
        users.add(new Osetrovatel(50002, "Edo"));

    }

    public void saveDB(){   //serialize

    }
}
