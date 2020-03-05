package edu.cnm.deepdive.notes.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.notes.model.entity.Note;
import io.reactivex.Single;
import java.util.List;


@Dao // This makes it a Room Dao interface.
public interface NoteDao {

  @Insert
  Single<Long> insert(Note note);  //  Single, Maybe or Completable for auto threading.

  @Insert
  Single<List<Long>> insert(Note... notes);  //  ... means zero or more of (this is a varargs).

  @Update
  Single<Integer> update(Note... notes);

  @Delete
  Single<Integer> delete(Note... notes);


  // Queries
  @Query("SELECT * FROM Note ORDER BY created DESC")  // In Room the text of the @Query must be written.
  LiveData<List<Note>> select();

  @Query("SELECT * FROM Note WHERE note_id = :id" )
  Single<Note> select(long id);

}
