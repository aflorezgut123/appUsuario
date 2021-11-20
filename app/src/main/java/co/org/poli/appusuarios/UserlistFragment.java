package co.org.poli.appusuarios;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserlistFragment extends Fragment {

    private User[] dataset;
    private RecyclerView rvTeamsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fillData();
        View fragmentView = inflater.inflate(R.layout.user_list_fragment, container, false);
        rvTeamsList = fragmentView.findViewById(R.id.rvUserListp);
        rvTeamsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTeamsList.setAdapter(new UserAdapter(dataset));
        return fragmentView;
    }

    private void fillData(){
        dataset = new User[3];

        dataset[0] = new User("pedro","Male", "System Enginer","");
        dataset[1] = new User("pedro","Male", "System Enginer","");
        dataset[2] = new User("pedro","Male", "System Enginer","");
        /*for (int cont = 0; cont < dataset.length; cont++ ){
            dataset[cont].name = "Element"+cont;
            dataset[cont].description = "Element"+cont;
            dataset[cont].image = "Element"+cont;
        }*/
    }
}
