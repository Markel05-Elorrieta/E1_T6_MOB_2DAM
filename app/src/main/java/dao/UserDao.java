package dao;

import android.util.Log;

import com.example.e1_t6_mob_2dam.ConectionDB;
import com.example.e1_t6_mob_2dam.GlobalVariables;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

import objects.User;

public class UserDao {
    private ConectionDB conectionDB = new ConectionDB();

    public ArrayList<User> getUsers(){
        ArrayList <User> usersDBAux = new ArrayList<User>();

        FirebaseFirestore db = conectionDB.getConnection();
        db.collection("erabiltzaileak").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                int cont = 0;
                for (QueryDocumentSnapshot document : task.getResult()) {
                    User userDB = new User(
                            cont,
                            document.getString("izena"),
                            document.getString("abizenak"),
                            document.getString("erabiltzailea"),
                            document.getString("pasahitza"),
                            document.getDate("jaiotze_data"),
                            document.getString("email"),
                            document.getDouble("telefonoa").intValue(),
                            document.getDouble("maila").intValue()
                    );
                    usersDBAux.add(userDB);
                    cont++;
                }
            } else {
                Log.d("casca", "casca");
            }
            Log.d("DBFinish", "finish" + GlobalVariables.usersDB.size());
        });
        GlobalVariables.usersDB = usersDBAux;
        return usersDBAux;
    }
}
