public class Entry {
    private int key;
    private int record;


    public Entry(){
        key=0;
        record=0;
    }

    public int getEntryKey(){
        return this.key;
    }

    public void setEntryKey(int key){
        this.key=key;
    }

    public int getRecord(){
        return this.record;
    }
}