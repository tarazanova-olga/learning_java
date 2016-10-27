package my.learning_java.addressbook.model.db_model;


import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

//создание расширенных коллекций
public class GroupsDB extends ForwardingSet <GroupDataDB> {

    private  Set<GroupDataDB> delegate;

    public GroupsDB(GroupsDB groups) {
        this.delegate = new HashSet<GroupDataDB>(groups.delegate);
    }

    public GroupsDB() {
        this.delegate = new HashSet<GroupDataDB>();
    }

    @Override
    protected Set<GroupDataDB> delegate() {
        return delegate;
    }

    public GroupsDB withAdded(GroupDataDB group){
        GroupsDB groups = new GroupsDB(this);
        groups.add(group);
        return groups;
    }

    public GroupsDB withOut(GroupDataDB group){
        GroupsDB groups = new GroupsDB(this);
        groups.remove(group);
        return groups;
    }

}
