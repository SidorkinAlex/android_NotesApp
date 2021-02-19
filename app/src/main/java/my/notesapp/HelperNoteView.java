package my.notesapp;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelperNoteView {
    static View getRowNoteFromListView(Note note, Context context){
        LinearLayout rowLinearLayout = new LinearLayout(context,null,0, R.style.NoteListLinerLine);
        TextView dateTextView = new TextView(context,null, 0, R.style.NoteListDateTextView);
        TextView titleTextView = new TextView(context,null, 0, R.style.NoteListTitleTextView);
        dateTextView.setText(note.getDate());
        titleTextView.setText(note.getTitle());
        rowLinearLayout.addView(dateTextView);
        rowLinearLayout.addView(titleTextView);
        return rowLinearLayout;
    }

}
