package me.kyrix.tasks.taskmanagement;

import java.util.HashMap;
import java.util.Map;

public class GroupManager {
    public Map<String, Group> groups = new HashMap();

    public Group currentGroup;

    public GroupManager() {
        currentGroup = null;
    }

    public void addGroup(String key, Group group) {
        groups.put(key, group);
    }
    public Group getGroup(String key) {
        return groups.get(key);
    }
    public void removeGroup(String key) {
        groups.remove(key);
    }
}
