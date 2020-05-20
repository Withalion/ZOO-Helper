package Models;

import Help.UserDB;

public class VisitorMaker {
    private Strategy TicketStrategy = null;

    public void SetStrategy(Strategy NewStrategy){
        this.TicketStrategy = NewStrategy;
    }

    public void MakeVisitor(String Name){
        TicketStrategy.WriteUserDetails(Name);
        UserDB.users.add((User) TicketStrategy);
        UserDB.saveDB();
    }
}
