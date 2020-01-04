public class HashDictionary {

    String[] dictionary = new String[471848];
    int length = dictionary.length;
    int loadFactor =0;

    public int hashKey(String word){
        int some=0;
        for(int i=0 ; i < word.length(); i++)
            some+=(word.charAt(i)+(31*i));
        return  some%length;
    }
    public int hashKey(int key){
        return  key%length;
    }


    public void insert(String value){

        int hashedKey = hashKey(value);
        boolean alreadyExist = false;
        if(occupied(hashedKey) ){
            if(!dictionary[hashedKey].equals(value)) {
                int stopIndex = hashedKey;
                if (hashedKey == length - 1) {
                    hashedKey = 0;
                } else {
                    hashedKey++;
                }
                while (occupied(hashedKey) && hashedKey != stopIndex) {
                    hashedKey = hashKey(hashedKey + 1);
                }
            }else{
                alreadyExist = true;
            }
        }

        if(alreadyExist != true) {
            if (occupied(hashedKey)) {
                System.out.println("already occupied");
            } else {
                dictionary[hashedKey] = value;
                System.out.println(dictionary[hashedKey]);
            }
        }else{
            System.out.println(value+" already in the dictionary");
        }
    }


    public String delete(String value){
        int hashedKey =findKey(value);
        if(hashedKey==-1) {
            return null;
        }else {
            String deleted = dictionary[hashedKey];
            dictionary[hashedKey] = "null";
            return deleted;
        }
    }

    public boolean occupied(int key){
        return dictionary[key]!=null;
    }

    public void search(String value){
        int hashedKey = findKey(value);
        if(hashedKey == -1)
            System.out.println(value+" does not exist");
        else
            System.out.println(value+" exist");
    }
    public int findKey(String value){
        int hashedKey =hashKey(value);
        System.out.println("findkey works");
        if(dictionary[hashedKey] != null  && dictionary[hashedKey].equals(value)) {
            System.out.println(dictionary[hashedKey]+" yesp");
            return hashedKey;
        }else {
            int stopIndex = hashedKey;
            if (hashedKey == length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            while (dictionary[hashedKey] !=null && !dictionary[hashedKey].equals(value) && hashedKey != stopIndex)
                hashedKey = hashKey(hashedKey + 1);

            if (dictionary[hashedKey] !=null && dictionary[hashedKey].equals(value)){
                return hashedKey;
            }else {
                return -1;
            }
        }
    }

    public String[] getDictionary(){
        return dictionary;
    }
    }


