package model;

import lombok.Getter;

@Getter
public class DBObject {
    private Long id;
    private static long NEW_ID = 0;

    public DBObject(){
        this.id = ++this.NEW_ID;
    }
}
