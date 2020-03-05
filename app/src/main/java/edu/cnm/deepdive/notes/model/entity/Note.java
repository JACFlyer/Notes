package edu.cnm.deepdive.notes.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;
//  Room only works directly with SQLite database which is part of androidx
//  Room uses setters and getters.  Jpa does not use setters and getters for all fields.

@Entity
public class Note {


  @ColumnInfo(name = "note_id")
  // Every Entity must have a primary key and the standard name is "id". PK is automatically indexed.
  @PrimaryKey(autoGenerate = true)
  private long id;

  @NonNull
  @ColumnInfo(index = true)
  private Date created = new Date();


  @NonNull  // This tells Room that the fields are non-nullable.
  @ColumnInfo(index = true, collate = ColumnInfo.NOCASE)  // Index created is case insensitive.  Only strings are collated
  private String subject;


  @NonNull
  private String text;  // In many SQL dialects, text is a key word.



  //  Setters and Getters
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getSubject() {
    return subject;
  }

  public void setSubject(@NonNull String subject) {
    this.subject = subject;
  }

  @NonNull
  public String getText() {
    return text;
  }

  public void setText(@NonNull String text) {
    this.text = text;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }
}
