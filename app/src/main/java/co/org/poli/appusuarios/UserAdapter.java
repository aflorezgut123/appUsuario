package co.org.poli.appusuarios;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ElementViewHolder>{

    private User[] localDataset;
    RecyclerView recyclerView;
    List<User> songs;
    private static String JSON_URL = "http://starlord.hackerearth.com/studio";
    Adapter adapter;
    LayoutInflater inflater;

    public UserAdapter(User[] inputDataset){
        this.localDataset = inputDataset;
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
        try{
            holder.getTextViewTitle().setText(songs.get(position).getBody());
            holder.getTextViewBody().setText(localDataset[position].getTitle());
        }
        catch (Exception ignored){

        }

    }

    @Override
    public int getItemCount() {
        return localDataset.length;
    }

    public static class ElementViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitle, textViewId;
        private TextView textViewBody,textViewUserId;
        public ElementViewHolder (@NonNull View itemView ){
            super(itemView);
            textViewId = itemView.findViewById(R.id.etUserID);
            textViewTitle = itemView.findViewById(R.id.etUserID);
            textViewTitle = itemView.findViewById(R.id.etUserID);
            textViewBody = itemView.findViewById(R.id.etUserName);
        }

        public TextView getTextViewTitle(){
            return textViewTitle;
        }
        public TextView getTextViewBody(){
            return textViewBody;
        }

    }

    private void extractSongs() {
        RequestQueue queue = Volley.newRequestQueue(this.recyclerView.getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject songObject = response.getJSONObject(i);

                        User song = new User();
                        song.setId(songObject.getString("id").toString());
                        song.setUserId(songObject.getString("userId".toString()));
                        song.setTitle(songObject.getString("title"));
                        song.setBody(songObject.getString("body"));
                        songs.add(song);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(),songs);
                recyclerView.setAdapter((RecyclerView.Adapter) adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

    }

}
