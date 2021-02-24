package my.notesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>{
    private final List<Note>  notes = new ArrayList<>();
    private final NotesAdapterCallback callback;

    public NotesAdapter(NotesAdapterCallback callback){
        this.callback = callback;
    }


    public void setNotes(ArrayList<Note> items){
        notes.clear();
        notes.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_notes,parent,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.onBind(notes.get(position),position);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleView;
        private final LinearLayout rowNote;
        private final TextView dateView;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
             titleView = itemView.findViewById(R.id.title_note_item);
            rowNote = itemView.findViewById(R.id.row_note_item);
             dateView = itemView.findViewById(R.id.date_note_item);
        }
        public void onBind(Note note, int position){
            titleView.setText(note.getTitle());
            dateView.setText(note.getDate());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getAdapterPosition() != RecyclerView.NO_POSITION) {
                        callback.onItemClicked(note);
                    }
                }
            });
        }
    }
}
