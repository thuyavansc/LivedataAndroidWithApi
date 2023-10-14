package au.com.softclient.livedata1.services;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.GET;
import androidx.lifecycle.LiveData; // LiveData import from AndroidX


//package au.com.softclient.livedata1.services;

//import retrofit2.http.GET;

import au.com.softclient.livedata1.models.User;

//import android.telecom.Call;

import au.com.softclient.livedata1.models.User;

public interface UserService {
    @GET("user")
    Call<User> getUser();
}
