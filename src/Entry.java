public class Entry {
    private int key;
    private int value;

    public Entry(int key){
        this.key=key;
        this.value=0;
    }

    public int getEntryKey(){
        return this.key;
    }

    public void setEntryKey(int key){
        this.key=key;
    }

    public int getRecord(){
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
