import java.util.Random;
class Students {
    private int id; // key
    private String name; // value
    private int year;

    public Students(int year) {
        Random rnd = new Random();
        this.id = rnd.nextInt(60) + 1;
        //http://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        this.name = salt.toString();
        this.year = year;
    }

    public int getKey() {
        return id;
    }

    public void setKey(int id) {
        this.id = id;
    }

    public String getValue() {
        return name;
    }

    public void setValue(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

//http://www.algolist.net/Data_structures/Hash_table/Simple_example
public class HashMap {
    private final static int TABLE_SIZE = 128;

    Students [] table;

    public HashMap() {
        table = new Students[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

      public String get(int key) {
            int hash = (key % TABLE_SIZE);
            while (table[hash] != null && table[hash].getKey() != key) {
                hash = (hash + 1) % TABLE_SIZE;
            }
            if (table[hash] == null)
                  return null;
            else
                  return table[hash].getValue();
      }
    public void put(Students s) {
        int hash = (s.getKey() % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() == s.getKey()) {
            hash = (hash + 1) % TABLE_SIZE;
            s.setKey(hash);
        }
        table[hash] = s;
        System.out.println(s.getValue() + " (ID: "+ s.getKey() +")"+" is graduating from year " + s.getYear() +"!");
    }
}
