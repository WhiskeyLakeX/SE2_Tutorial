package edu.hanu.mynote.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;
import java.util.List;
import edu.hanu.mynote.R;
import edu.hanu.mynote.models.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    //view holder
    protected class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewContent;
        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            // get ref to textview
            textViewContent = itemView.findViewById(R.id.tvContent);
            // TODO: events
        }
        public void bind(Note note){
            // bind content
            textViewContent.setText(note.getContent());
        }
    }
    //dataset
    private List<Note> notes;
    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }
    @Override
    public int getItemCount() {
        return notes.size();
    }
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // context
        Context context = parent.getContext();
        // inflater xml -> object view
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_note, parent, false);
        return new NoteHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        // get data item at position
        Note  note = notes.get(position);
        // bind data to view
        holder.bind(note);
    }
}

