package my.learning_java.addressbook.model;


import com.google.common.collect.ForwardingSet;
import my.learning_java.addressbook.model.db_model.GroupDataDB;

import java.util.HashSet;
import java.util.Set;

//создание расширенных коллекций
public class Groups extends ForwardingSet <GroupData> {

    private  Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups withOut(GroupData group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }

}
