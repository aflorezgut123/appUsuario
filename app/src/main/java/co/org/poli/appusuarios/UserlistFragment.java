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
        View fragmentView = inflater.inflate(R.layout.element, container, false);
        rvTeamsList = fragmentView.findViewById(R.id.idText);
        rvTeamsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTeamsList.setAdapter(new UserAdapter(dataset));
        return fragmentView;
    }

    private void fillData(){
        //llenarData();
        dataset = new User[3];
        for (int cont = 0; cont < dataset.length; cont++ ){
           // dataset[cont] = new User(dataset[cont].getName() + cont,dataset[cont].getGenre(),dataset[cont].getDescription(),dataset[cont].getUrlImage());
            dataset[cont] = new User("Andrey"+cont,"Male","Engineer"+cont,"https://www.esic.edu/sites/default/files/rethink/c7a84832-data-engineer.jpg");
        }
    }

    private void llenarData(){

        dataset[0].setUserId("Jose");
        dataset[0].setId("Male");
        dataset[0].setTitle("He is a Teacher with concepts of System Engineer");
        dataset[0].setBody("https://img.lovepik.com/original_origin_pic/18/08/07/4e59abef8ee0df40cdfb674c0050c2d6.png_wh860.png");
//        dataset[1].setName("Daniel");
//        dataset[1].setGenre("Male");
//        dataset[1].setDescription("He is a Artist of the university of the Andes");
//        dataset[1].setUrlImage("https://img.lovepik.com/original_origin_pic/18/08/07/4e59abef8ee0df40cdfb674c0050c2d6.png_wh860.png");
//        dataset[2].setName("Maria");
//        dataset[2].setGenre("Feme");
//        dataset[2].setDescription("She is an arquitec and a medic");
//        dataset[2].setUrlImage("https://img.lovepik.com/original_origin_pic/18/08/07/4e59abef8ee0df40cdfb674c0050c2d6.png_wh860.png");
//        dataset[0] = new User("Jose","Male","He is a Teacher with concepts of System Engineer","https://img.lovepik.com/original_origin_pic/18/08/07/4e59abef8ee0df40cdfb674c0050c2d6.png_wh860.png");

    }
}
