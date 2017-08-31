package prefix;

import java.util.*;

public class Dictionary {

    private Set<String> names = new HashSet<>();
    private Map<String, Dictionary> prefixMap = new HashMap<>();

    Dictionary() {

    }

    void addName(String name) {
        if (name == null || name.length() == 0)
            throw new NullPointerException("name cannot be empty");

        char[] words = name.toCharArray();
        names.add(name);
        Dictionary dictionary = this;
        for (int i = 0; i < words.length; i++) {
            String key =  String.valueOf(words[i]);
            if (dictionary.prefixMap.containsKey(key) == false) {
                dictionary.prefixMap.put(key, new Dictionary());
            }
            dictionary.prefixMap.get(key).names.add(name);

            dictionary = dictionary.getDictionary(key);

        }

    }

    @Override
    public String toString() {
        return names.toString();
    }

    public Set<String> getNames() {
        return names;
    }

    public boolean isPrefixExist(String prefix) {
        return prefixMap.containsKey(prefix);
    }

    public Dictionary getDictionary(String prefix) {
        return prefixMap.get(prefix);
    }



}
