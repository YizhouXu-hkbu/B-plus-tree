public class Entry {
    private int key;
    private int record;


    public Entry(){
        this.key=0;
        this.record=0;
    }

    public Entry(int key){
        this.key=key;
        record=1;
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
