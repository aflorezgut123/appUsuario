package co.org.poli.appusuarios;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddUsersFragment extends Fragment {

    private EditText etUserId, etUsername, etEmail, etName;
    private Button btnSendAction;
    private final static String API_URL = "https://jsonplaceholder.typicode.com/users/";


    View view;
    User user;
    EditText txtName;
    EditText txtDescription;
    EditText txtURLimage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.create_user_fragment, container, false);
        etUserId = view.findViewById(R.id.etUserID);
        etUsername = view.findViewById(R.id.etUserName);
        etEmail = view.findViewById(R.id.etEMail);
        etName = view.findViewById(R.id.etName);
        btnSendAction = view.findViewById(R.id.btnSendAction);

        btnSendAction.setOnClickListener(v -> makeGetRequest());

        return view;

    }


    private void makeGetRequest() {
        String numApi = etUserId.getText().toString();
        if (numApi.equals("1") || numApi.equals("2") ||
                numApi.equals("3") || numApi.equals("4") ||
                numApi.equals("5") || numApi.equals("6") ||
                numApi.equals("7") || numApi.equals("8") ||
                numApi.equals("9") || numApi.equals("10")) {

            StringRequest strRequest = new StringRequest(Request.Method.GET, API_URL + numApi, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject responseObject = new JSONObject(response);
                        String userId = responseObject.getString("id");
                        String userName = responseObject.getString("username");
                        String name = responseObject.getString("name");
                        String email = responseObject.getString("email");

                        etUserId.setText(userId);
                        etUsername.setText(userName);
                        etName.setText(name);
                        etEmail.setText(email);
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("[RESQUEST ERROR]", error.getMessage());
                        }
                    }
            );
            Volley.newRequestQueue(this.view.getContext()).add(strRequest);
        } else {
            Toast toast1 =
//                    Toast.makeText(getApplicationContext(),
                    Toast.makeText(this.view.getContext(),
                            "Por favor ingrese un valor entre 1 a 10", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

}
