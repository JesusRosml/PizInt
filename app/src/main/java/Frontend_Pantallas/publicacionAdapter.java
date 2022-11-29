package Frontend_Pantallas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jesus.pizint.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class publicacionAdapter extends RecyclerView.Adapter<publicacionAdapter.Viewholder> {
    private int resource;
    private ArrayList<subirBD> publicacionList;

    public publicacionAdapter(ArrayList<subirBD> publicacionList, int resource){
        this.publicacionList = publicacionList;
        this.resource = resource;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        subirBD titulo = publicacionList.get(position);
        subirBD contenido = publicacionList.get(position);
        subirBD imagen = publicacionList.get(position);
        holder.textViewTitulo.setText(titulo.getTitulo());
        holder.textViewContenido.setText(contenido.getContenido());
        Picasso.get().load(imagen.getImagen()).into(holder.ImageViewContenido);

    }

    @Override
    public int getItemCount() {
        return publicacionList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        private TextView textViewTitulo;
        private TextView textViewContenido;
        private ImageView ImageViewContenido;
        public View view;

        public  Viewholder(View view ){
            super(view);
            this.view = view;
            this.textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
            this.textViewContenido = (TextView) view.findViewById(R.id.textViewContenido);
            this.ImageViewContenido = (ImageView) view.findViewById(R.id.ImageViewContenido);
        }
    }
}
